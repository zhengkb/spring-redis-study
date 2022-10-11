package com.zkb.springredisstudy.service;

import com.zkb.springredisstudy.entity.User;
import com.zkb.springredisstudy.mapper.GameRoleMapper;
import com.zkb.springredisstudy.mapper.UserCurrentMapper;
import com.zkb.springredisstudy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestAnnotation {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserCurrentMapper userCurrentMapper;
    @Autowired
    private GameRoleMapper gameRoleMapper;

    public void execute1(Long uid, String value) {
        execute(uid, value);
    }

    @Transactional()
    public void execute(Long uid, String value) {
        User user = new User(uid, value);
        userMapper.updateImei(user);
        userCurrentMapper.updateImei(user);
        gameRoleMapper.updateImei(user);
    }
}
