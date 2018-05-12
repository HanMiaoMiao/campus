package com.xust.campus.service;

import com.xust.campus.entity.Consumer;
import com.xust.campus.vo.request.Register;
import com.xust.campus.vo.response.Msg;

public interface ConsumerService {
    /**
     * 向login表和consumer表插入 一条用户信息
     * @param register
     * @return
     */
    public Msg insertSelective(Register register);
}
