package com.sinewang.wave.jsm.dao;

import com.sinewang.wave.jsm.model.Action;
import com.sinewang.wave.jsm.model.Module;
import com.sinewang.wave.jsm.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangyanjiong on 6/26/15.
 */


public interface UserDao {

    User getUser(@Param("userId") String userId, @Param("companyId") String companyId);

    List<Module> getModulesByUser(@Param("userId") String userId);

    List<Action> getActionsByUser(@Param("userId") String userId, @Param("moduleId") String moduleId);

}
