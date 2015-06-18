package com.sinewang.wave.jsm.controller;

import com.sinewang.wave.jsm.model.RESTResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangyanjiong on 6/15/15.
 */
@RestController
public class UserLogin {


    @RequestMapping("/login")
    public RESTResult configs(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
        if (username.equals("admin")) {
            request.getSession().setAttribute("wave-user", username);
            return RESTResult.newSuccess("OK");
        } else {
            return RESTResult.newFailed(-1, "LoginFailed");
        }
    }

}