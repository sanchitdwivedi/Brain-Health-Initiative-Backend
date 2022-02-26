package com.healthcare.service;

import com.healthcare.dao.UserDao;
import com.healthcare.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserByUserId(Long userId){
        return userDao.findByUserId(userId);
    }
}
