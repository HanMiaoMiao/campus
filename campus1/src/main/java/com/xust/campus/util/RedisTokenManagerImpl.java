package com.xust.campus.util;

import com.xust.campus.util.redis.Constants;
import com.xust.campus.vo.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;


import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 通过Redis存储和验证Token的实现类
 * @Author hanmiaomiao
 * @Date 2018/05/12
 */
@Component
public class RedisTokenManagerImpl implements TokenManager{
    private RedisTemplate redis;
    @Autowired
    public void setRedis(RedisTemplate redis){
        this.redis=redis;
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    @Override
    public TokenModel createToken(String userNumber) {
        //uuid作为源token
        String token= UUID.randomUUID().toString().replace("-","");
        TokenModel model=new TokenModel(userNumber,token);
        System.out.println("000000000000000000000000000000000000000000000000000000000000000000model-------------------------"+model);
        //存储到redis并设置过期时间
        redis.boundValueOps(userNumber).set(token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if(model==null){
            return false;
        }
        String token =(String )redis.boundValueOps(model.getUserNumber()).get();
        if(token==null||!token.equals(model.getToken())){
            return false;
        }
        //验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redis.boundValueOps(model.getUserNumber()).expire(Constants.TOKEN_EXPIRES_HOUR,TimeUnit.HOURS);

        return true;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if(authentication==null||authentication.length()==0){
            return null;
        }
        String[] param=authentication.split("_");
        if(param.length!=2){
            return null;
        }
        //?????????????????????????????????????????????
        //使用userNumber 和源token简单拼接成的token,可以增加加密措施
        String userNumber=param[0];
        String token=param[1];
        return new TokenModel(userNumber,token);
    }

    @Override
    public void deleteToken(String userNumber) {
        redis.delete(userNumber);
    }

}
