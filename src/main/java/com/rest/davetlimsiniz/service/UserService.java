package com.rest.davetlimsiniz.service;

import com.rest.davetlimsiniz.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.davetlimsiniz.dao.user.UserDAO;

@Service
public class UserService extends AbstractService<User>{
    @Autowired
    UserDAO dao;

    @Override
    public User findById(Long id) throws Exception {
        return super.findById(id);
    }

    public User findFirstByEmail(String email) throws Exception {
        return dao.findFirstByEmail(email);
    }
}
