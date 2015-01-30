package com.od.streamkata.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Generate a substitution key
 */
public class KeyGenerator {

    public static void main(String[] args) {
        for ( String c : new KeyGenerator().generateKeys(100)) {
            System.out.println(c);
        }
    }

    public List<String> generateKeys(int count) {
        List<String> result = new ArrayList<String>();
        for ( int loop=0 ; loop <count ; loop++) {
            result.add(generateKey());
        }
        return result;
    }

    public String generateKey() {
        LinkedList<Integer> toAdd = new LinkedList<Integer>();
        IntStream.range(0, 26).forEach(toAdd::add);

        char[] key = new char[26];
        IntStream.range(0, 26).forEach(i -> {
            int index = (int) (Math.random() * toAdd.size());
            Integer v = toAdd.remove(index);
            key[i] = (char)(65 + v);
        });

        String result = new String(key);
        new KeyValidator().validateKey(result);
        return result;
    }


}
