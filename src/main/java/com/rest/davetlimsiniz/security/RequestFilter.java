package com.rest.davetlimsiniz.security;

import com.rest.davetlimsiniz.entity.user.User;
import com.rest.davetlimsiniz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestFilter {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserService userService;

    public boolean doFilterRequest(HttpServletRequest request) throws Exception {
        String requestHeader =  request.getHeader("Authorization");
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {

            // 'Bearer' substring in header
            String token = requestHeader.substring(7);

            String userId = jwtUtil.extractUserId(token);

            if(userId != null) {
                User user = userService.findById(Long.valueOf(userId));
                if(user == null) return false;
                return jwtUtil.validateToken(token, user);
            }

        }
        return false;
    }
}
