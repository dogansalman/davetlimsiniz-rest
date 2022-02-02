package com.rest.davetlimsiniz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class RequestHandler implements HandlerInterceptor {

    @Autowired
    private RequestFilter requestFilter;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // todo invitation kaldırılacak.
        if (request.getServletPath().startsWith("/auth") || request.getServletPath().startsWith("/invitation")) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }

        if(!requestFilter.doFilterRequest(request)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not authorized");
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
