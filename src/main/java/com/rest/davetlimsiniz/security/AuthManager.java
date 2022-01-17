package com.rest.davetlimsiniz.security;

import com.rest.davetlimsiniz.dto.auth.AuthDTO;
import com.rest.davetlimsiniz.dto.auth.LoginDTO;
import com.rest.davetlimsiniz.entity.user.User;
import com.rest.davetlimsiniz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class AuthManager {

    @Autowired JwtUtil jwtUtil;
    @Autowired UserService userService;
    final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthDTO auth(LoginDTO login) throws Exception {

        User user = userService.findFirstByEmail(login.getEmail());
        if(user == null || !encoder.matches(login.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not authorized");
        }

        String token = jwtUtil.generateToken(user);
        AuthDTO authDTO = new AuthDTO();
        authDTO.setToken(token);
        return authDTO;
    }
}
