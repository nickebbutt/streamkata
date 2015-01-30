package com.od.streamkata.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Validate a key
 */
public class KeyValidator {

    public void validateKey(String key) {
        checkKeyLength(key);
        checkAsciiUpperCase(key);
        checkUniqueCharCount(key);
    }

    private void checkUniqueCharCount(String key) {
        Set<Character> chars = new HashSet<>();
        for (char c: key.toCharArray()) {
            chars.add(c);
        }
        if ( chars.size() != 26 ) {
            throw new UnsupportedOperationException("Not all A-Z characters existed in key");
        }
    }

    private void checkKeyLength(String key) {
        if ( key.length() != 26) {
            throw new UnsupportedOperationException("Key must contain just 26 characters");
        }
    }

    private void checkAsciiUpperCase(String chars) {
        for ( char c : chars.toCharArray()) {
            if (c < 65 || c > 90) {
                throw new UnsupportedOperationException("Key must contain characters in range A-Z");
            }
        }
    }
}
