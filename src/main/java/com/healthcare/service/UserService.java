package com.healthcare.service;

import com.healthcare.dao.UserDao;
import com.healthcare.entity.User;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserByUserId(Long userId){
        return userDao.findByUserId(userId);
    }

    public void deleteUser(User user) {
        if(user==null) throw new APIRequestException("Invalid User");
        user.setActive(0);
        userDao.save(user);
    }
}
