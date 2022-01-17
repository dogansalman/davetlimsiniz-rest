package com.rest.davetlimsiniz.dao.user;

import com.rest.davetlimsiniz.dao.GenericDAO;
import com.rest.davetlimsiniz.entity.user.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAO extends GenericDAO<User> {

    public User findFirstByEmail(String email);
}
