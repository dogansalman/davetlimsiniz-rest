package com.rest.davetlimsiniz.config;

import com.rest.davetlimsiniz.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rest.davetlimsiniz.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@Component
public class DbInit {
    @Autowired private UserService userService;

    final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostConstruct
    private void postConstruct() throws Exception {

        if(userService.getAll().size() == 0) {
            User user = new User();
            user.setEmail("admin");
            user.setIsAdmin(true);
            user.setPassword(encoder.encode("admin"));
            userService.save(user);
            System.out.println("Default admin user added...");
        }

    }


}
