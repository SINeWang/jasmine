package com.sinewang.wave.jsm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 * Created by wangyanjiong on 6/16/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sinewang.wave.jsm")
public class BaseConfig {

}
