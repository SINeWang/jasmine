package com.sinewang.wave.jsm.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangyanjiong on 6/26/15.
 */
public class Module implements Serializable{

    private String moduleId;

    private String moduleName;

    private List<Action> actions;

    public Module(String moduleId, String moduleName) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
    }

    public Module() {
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
