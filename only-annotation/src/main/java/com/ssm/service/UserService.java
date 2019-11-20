package com.ssm.service;


import com.ssm.entity.User;
import com.ssm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ljh
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User login(String username) {
        User user = userDao.getUser(username);
        return user;
    }
}
