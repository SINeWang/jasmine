package com.sinewang.wave.jsm.model;

import java.io.Serializable;

/**
 * Created by wangyanjiong on 6/18/15.
 */
public class RESTResult implements Serializable {

    private int c;

    private String m;

    private Object d;

    public static RESTResult newSuccess(Object data) {
        RESTResult r = new RESTResult();
        r.c = 0;
        r.d = data;
        return r;
    }

    public static RESTResult newFailed(int code, String message, Object data) {
        RESTResult r = new RESTResult();
        r.c = code;
        r.m = message;
        r.d = data;
        return r;
    }

    public static RESTResult newFailed(int code, String message) {
        RESTResult r = new RESTResult();
        r.c = code;
        r.m = message;
        return r;
    }

    private RESTResult() {
    }


    public int getC() {
        return c;
    }

    public String getM() {
        return m;
    }

    public Object getD() {
        return d;
    }

}
