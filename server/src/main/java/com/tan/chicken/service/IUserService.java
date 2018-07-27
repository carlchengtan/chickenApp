package com.tan.chicken.service;

import java.util.List;

import com.tan.chicken.domain.User;
import com.tan.chicken.domain.UserDto;

public interface IUserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);
    List<User> findByRoles_Id(Long id);
    User findById(Long id);
}