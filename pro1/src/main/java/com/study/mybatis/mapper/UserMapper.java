package com.study.mybatis.mapper;

import com.study.mybatis.pojo.User;

import java.util.List;

/**
 * @author LY
 * @create 2022-04-26 0:26
 */
public interface UserMapper {

    public List<User> findAllUser();

    public void updateInfoById();

    public void deleteInfoById();

    public void addUserById();
}
