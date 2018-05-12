package com.xust.campus.util;

import com.xust.campus.vo.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Constants;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;
import com.scienjus.config.Constants;

import java.util.UUID;

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
        String token= UUID.randomUUID().toString().replace("-"," ");
        TokenModel model=new TokenModel(userNumber,token);
       // redis.boundValueOps(userNumber).set(token, Constannts);
        return null;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        return false;
    }

    @Override
    public TokenModel getToken(String authentication) {
        return null;
    }

    @Override
    public void deleteToken(String userNumber) {

    }

    public TokenModel
}
