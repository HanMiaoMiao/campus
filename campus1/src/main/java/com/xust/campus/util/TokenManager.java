package com.xust.campus.util;

import com.xust.campus.vo.TokenModel;

/**
 * 对token进行操作的接口
 */
public interface TokenManager {
    /**
     * 创建一个token关联指定用户
     * @param userNumber  指定用户的number
     * @return 生成的Token
     */
    public TokenModel createToken(String userNumber);

    /**
     * 检查Token是否有效
     * @param model
     * @return
     */
    public boolean checkToken(TokenModel model);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public TokenModel getToken(String authentication);

    /**
     * 清除token
     * @param userNumber 用户登录的userNumber
     */
    public void deleteToken(String userNumber);

}
