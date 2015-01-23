package com.od.cryptokata.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;

/**
 *
 * Encrypt and decrypt String values using a simple character by character substitution cipher
 *
 * For goodness sake don't use this for anything which actually needs to be secure....
 *
 */
public class SubstitutionCipher {

    private final KeyValidator keyValidator = new KeyValidator();
    private ThreadLocalKeyMaps threadLocalKeyMaps = new ThreadLocalKeyMaps();

    private static BiFunction<Integer, Map<Integer,Integer>, Integer> mappingFunction = (c ,m ) -> {
        Integer mapped = m.get(c);
        //if a mapped character, replace it
        return mapped == null ? c : mapped;
    };

    //collect streaming ints into a StringBuilder as characters
    private static ObjIntConsumer<StringBuilder> charAccumulator = (sb, i) -> {
        sb.append((char) i);
    };

    /**
     * Perform an entirely trivial decryption using key
     * Don't use this in real life
     */
    public String encrypt(String s, String key) {
        Map<Integer,Integer> encoding = getEncodingMap(key);
        StringBuilder result = s.chars().map(using(encoding)).collect(StringBuilder::new, charAccumulator, StringBuilder::append);
        return result.toString();
    }

    public String decrypt(String s, String key) {
        Map<Integer,Integer> decoding = getDecodingMap(key);
        StringBuilder result = s.chars().map(using(decoding)).collect(StringBuilder::new, charAccumulator, StringBuilder::append);
        return result.toString();
    }

    private static <K,V> Map<V, K> reverseMap(Map<K, V> map) {
        Map<V, K> myNewHashMap = new HashMap<>();
        for(Map.Entry<K, V> entry : map.entrySet()){
            myNewHashMap.put(entry.getValue(), entry.getKey());
        }
        return myNewHashMap;
    }

    private static IntUnaryOperator using(Map<Integer, Integer> map) {
        return (c) -> { return (int) SubstitutionCipher.mappingFunction.apply(c, map); };
    }

    /**
     * The char[] provides a simple substitution mapping for the characters A-Z
     *
     * To get the mapping for the character A we take the character at index zero in the array
     * To get the mapping for the character B we take the character at index 1 in the array, etc.
     * e.g.
     *
     * We also add the equivalent mapping for the lower case chars a-z
     */
    private Map<Integer, Integer> getEncodingMap(String key) {
        Map<Integer, Integer> encoding = threadLocalKeyMaps.getEncryptionMap(key);
        if ( encoding.isEmpty()) {
            keyValidator.validateKey(key);
            for (int i = 0; i < 26; i++) {
                encoding.put(65 + i, (int) key.charAt(i));
                encoding.put(97 + i,  key.charAt(i) + 32);
            }
        }
        return encoding;
    }

    private Map<Integer, Integer> getDecodingMap(String key) {
        Map<Integer, Integer> decoding = threadLocalKeyMaps.getDecryptionMap(key);
        if ( decoding.isEmpty()) {
            decoding = reverseMap(getEncodingMap(key));
        }
        return decoding;
    }


}
