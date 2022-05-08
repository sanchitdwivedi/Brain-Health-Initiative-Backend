package com.healthcare.dao;

import com.healthcare.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.userId=?1 and u.active=1")
    public User findByUserId(Long userId);
}
