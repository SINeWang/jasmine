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
public class User {


    @RequestMapping("/user")
    public RESTResult user(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("wave-user");
        if (user != null) {
            return RESTResult.newSuccess(user);
        } else {
            return RESTResult.newFailed(-1, "Not Found User");
        }

    }

}