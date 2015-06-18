package com.sinewang.wave.jsm.controller;

import com.sinewang.wave.jsm.model.RESTResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangyanjiong on 6/15/15.
 */
@RestController
public class User {


    private final int CODE_BASE = 101;

    private final String SESSION_KEY_USER = "wave-user";

    public enum UserCode {
        cannot_find_user,
        username_or_password_error
    }

    @RequestMapping("/user")
    public RESTResult user(HttpServletRequest request) {
        Object user = request.getSession().getAttribute(SESSION_KEY_USER);
        if (user != null) {
            return RESTResult.newSuccess(user);
        } else {
            return RESTResult.newFailed(CODE_BASE, UserCode.cannot_find_user);
        }
    }

    @RequestMapping("/login")
    public RESTResult login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
        if (username.equals("admin")) {
            request.getSession().setAttribute(SESSION_KEY_USER, username);
            return RESTResult.newSuccess("OK");
        } else {
            return RESTResult.newFailed(CODE_BASE, UserCode.username_or_password_error);
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute(SESSION_KEY_USER);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}