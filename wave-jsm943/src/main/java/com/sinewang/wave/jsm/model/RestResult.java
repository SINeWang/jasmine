package com.sinewang.wave.jsm.model;

import com.sinewang.wave.jsm.util.InstanceSignature;

import java.io.Serializable;

/**
 * Created by wangyanjiong on 6/18/15.
 */
public class RESTResult implements Serializable {

    private int c;

    private String m;

    private Object d;

    private String i;

    private final static String I = InstanceSignature.fromHostName();

    public static RESTResult newSuccess(Object data) {
        RESTResult r = new RESTResult();
        r.c = 0;
        r.d = data;
            return r;
    }

    public static RESTResult newFailed(int base, Enum<?> codeMessage) {
        RESTResult r = new RESTResult();
        r.c = base + codeMessage.ordinal();
        r.m = codeMessage.name();
        return r;
    }

    private RESTResult() {
        this.i = I;
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

    public String getI() {
        return i;
    }
}
