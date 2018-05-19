package com.xust.campus.util;

import com.xust.campus.annotation.Authorization;
import com.xust.campus.util.redis.Constants;
import com.xust.campus.vo.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，判断此次请求是否有权限
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private TokenManager tokenManager;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handle){
        //不是映射到方法直接通过
        if(!(handle instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)handle;
        Method method=handlerMethod.getMethod();
        //从header中得到token
        String authorization=request.getHeader(Constants.AUTHORIZATION);
        //token验证
        TokenModel model=tokenManager.getToken(authorization);
        if(tokenManager.checkToken(model)){
            //token验证成功 ，将用户number存在request中，便于之后注入
            request.setAttribute(Constants.CURRENT_USER_NUMBER,model.getUserNumber());
            System.out.println("6666666666666666666666666666666666666666666666666666666");
            return true;
        }else if(method.getAnnotation(Authorization.class)!=null){
            ////如果验证token失败，并且方法注明了Authorization，返回401错误
            System.out.println("7777777777777777777777777777777777777");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
