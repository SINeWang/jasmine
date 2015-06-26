package com.sinewang.wave.jsm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyanjiong on 6/26/15.
 */
public class User implements Serializable {

    private String userId;

    private String userName;

    private String userPassword;

    private List<Module> modules;

    public User() {
        this.modules = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public User addModule(Module module) {
        this.modules.add(module);
        return this;
    }
}
