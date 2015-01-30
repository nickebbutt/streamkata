package com.od.streamkata.util;

/**
 * Created by GA2EBBU on 23/01/2015.
 */
public interface Cipher {

    public String encrypt(String toEncrypt, String key);

    public String decrypt(String toDecrypt, String key);
}
