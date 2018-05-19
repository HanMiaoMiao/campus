package com.xust.campus.util;

import com.xust.campus.annotation.CurrentUser;
import com.xust.campus.dao.LoginMapper;
import com.xust.campus.entity.Login;
import com.xust.campus.util.redis.Constants;
import com.xust.campus.vo.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 增加方法注入，将含有CurrentUser注解的方法参数注入当前登录用户
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //如果参数类型是TokenModel 并且有CurrenUser注解则支持
        if(methodParameter.getParameterType().isAssignableFrom(Login.class)&&methodParameter.hasParameterAnnotation(CurrentUser.class)){
            System.out.println("55555555555555555555555555555555555555555555555555555555555555555");
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
       //取出鉴权时存入的登录用户number
        String currentUserNumber=(String)nativeWebRequest.getAttribute(Constants.CURRENT_USER_NUMBER, RequestAttributes.SCOPE_REQUEST);
       if(currentUserNumber!=null){
           System.out.println("10101001010001111101011010111101000000000000011111110");
            return loginMapper.selectUserByNumber(currentUserNumber);
       }
        throw new MissingServletRequestPartException(Constants.CURRENT_USER_NUMBER);
    }
}
