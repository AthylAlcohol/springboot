package com.qf.springboot.service.impl;

import com.qf.springboot.entity.Student;
import com.qf.springboot.mapper.StudentMapper;
import com.qf.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PanYouGEn
 * @Date 2019/10/21
 */
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getById(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
