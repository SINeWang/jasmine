package com.sinewang.wave.jsm.model;

/**
 * Created by wangyanjiong on 6/26/15.
 */
public class Module {

    private String moduleId;

    private String moduleName;

    public Module(String moduleId, String moduleName) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
    }

    public Module() {
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
