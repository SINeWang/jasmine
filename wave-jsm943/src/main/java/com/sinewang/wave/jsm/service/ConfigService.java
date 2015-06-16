package com.sinewang.wave.jsm.service;

import com.sinewang.wave.jsm.dao.ConfigDao;
import com.sinewang.wave.jsm.model.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangyanjiong on 6/16/15.
 */
@Service
public class ConfigService {

    @Autowired
    private ConfigDao configDao;

    public List<Config> getWorld(String namespace) {
        return configDao.getAllConfigs(namespace);
    }
}
