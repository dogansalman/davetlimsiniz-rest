package com.rest.davetlimsiniz.controller.auth;

import com.rest.davetlimsiniz.security.AuthManager;
import com.rest.davetlimsiniz.service.UserService;
import com.rest.davetlimsiniz.dto.auth.AuthDTO;
import com.rest.davetlimsiniz.dto.auth.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired UserService userService;
    @Autowired AuthManager authManager;


    @PostMapping
    public ResponseEntity<AuthDTO> auth(@RequestBody LoginDTO dto) throws Exception {
        AuthDTO authDTO = authManager.auth(dto);
        return new ResponseEntity<>(authDTO, HttpStatus.OK);
    }
}
