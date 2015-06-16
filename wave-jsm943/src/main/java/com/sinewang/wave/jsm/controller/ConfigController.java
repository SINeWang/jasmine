package com.sinewang.wave.jsm.controller;

import com.sinewang.wave.jsm.model.Config;
import com.sinewang.wave.jsm.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangyanjiong on 6/15/15.
 */
@RestController
@RequestMapping("api")
public class ConfigController {

    @Autowired
    private ConfigService service;

    @RequestMapping("/config/{namespace}")
    public List<Config> configs(@PathVariable String namespace) {
        return service.getWorld(namespace);
    }

}