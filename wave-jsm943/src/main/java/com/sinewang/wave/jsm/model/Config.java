package com.sinewang.wave.jsm.model;

import java.io.Serializable;

/**
 * Created by wangyanjiong on 6/16/15.
 */
public class Config implements Serializable{

    private String namespace;

    private String key;

    private String value;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
