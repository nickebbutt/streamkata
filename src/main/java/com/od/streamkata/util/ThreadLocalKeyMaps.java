package com.od.streamkata.util;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by nick on 23/01/15.
 *
 * Don't regenerate mappings for every encrypt/decrypt
 */
public class ThreadLocalKeyMaps {

    private static ThreadLocal <IdentityHashMap<String, Map<Integer,Integer>>> threadLocalEncryptMaps =
            ThreadLocal.withInitial(IdentityHashMap::new);

    private static ThreadLocal<IdentityHashMap<String, Map<Integer,Integer>>> threadLocalDecryptMaps =
            ThreadLocal.withInitial(IdentityHashMap::new);

    public Map<Integer, Integer> getDecryptionMap(String key) {
        return getMap(key, threadLocalDecryptMaps);
    }

    public Map<Integer, Integer> getEncryptionMap(String key) {
        return getMap(key, threadLocalEncryptMaps);
    }

    private Map<Integer, Integer> getMap(String key, ThreadLocal<IdentityHashMap<String, Map<Integer, Integer>>> threadLocal) {
        Map<Integer,Integer> decryptMap = threadLocal.get().get(key);
        if ( decryptMap == null) {
            decryptMap = new HashMap<>();
            threadLocal.get().put(key, decryptMap);
        }
        return decryptMap;
    }
}
