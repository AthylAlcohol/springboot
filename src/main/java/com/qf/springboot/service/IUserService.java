package com.qf.springboot.service;

import com.qf.springboot.entity.Student;

/**
 * @author PanYouGEn
 * @Date 2019/10/21
 */
public interface IUserService {
    Student getById(int id);
}
