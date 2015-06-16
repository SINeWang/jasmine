package com.sinewang.wave.jsm.dao;

import com.sinewang.wave.jsm.model.Config;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangyanjiong on 6/16/15.
 */


public interface ConfigDao {

    List<Config> getAllConfigs(@Param("namespace") String namespace);


}
