package com.sinewang.wave.jsm.model;

import java.io.Serializable;

/**
 * Created by wangyanjiong on 6/30/15.
 */
public class Action implements Serializable {

    private String actionId;

    private String actionName;

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
