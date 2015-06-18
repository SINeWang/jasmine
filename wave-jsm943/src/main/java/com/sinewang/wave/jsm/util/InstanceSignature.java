package com.sinewang.wave.jsm.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wangyanjiong on 6/18/15.
 */
public class InstanceSignature {

    private static String hostNameSignature;

    static {
        buildHostNameSignature();
    }

    public static String fromHostName(){
        return hostNameSignature;
    }

    private static void buildHostNameSignature() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(inetAddress.getAddress());
            hostNameSignature = Base16.encode(digest);
        } catch (UnknownHostException ignore) {
        } catch (NoSuchAlgorithmException ignore) {
        }
    }

}
