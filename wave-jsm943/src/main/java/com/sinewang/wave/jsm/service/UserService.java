package com.sinewang.wave.jsm.service;

import com.sinewang.wave.jsm.dao.UserDao;
import com.sinewang.wave.jsm.model.Action;
import com.sinewang.wave.jsm.model.Module;
import com.sinewang.wave.jsm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangyanjiong on 6/26/15.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(String userId, String companyId) {
        User user = userDao.getUser(userId, companyId);
        if (user != null) {
            List<Module> modules = userDao.getModulesByUser(userId);
            for (Module module : modules) {
                List<Action> actions = userDao.getActionsByUser(userId, module.getModuleId());
                module.setActions(actions);
            }
            user.setModules(modules);
        }
        return user;
    }
}
