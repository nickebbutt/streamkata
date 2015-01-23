package com.od.cryptokata.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubstitutionCipherTest {

   //a substitution key which shouldn't affect the plaintext since every character is substituted with itself
   private static final String LIKE_FOR_LIKE_SUBSTITUTION = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private SubstitutionCipher substitutionCipher;

    @Before
    public void setUp() {
        substitutionCipher = new SubstitutionCipher();
    }

    @Test
    public void testEncrypt() throws Exception {
        String myTest = substitutionCipher.encrypt("England is done for", LIKE_FOR_LIKE_SUBSTITUTION);
        assertEquals("England is done for", myTest);

        myTest = substitutionCipher.decrypt("England is done for", LIKE_FOR_LIKE_SUBSTITUTION);
        assertEquals("England is done for", myTest);
    }

    @Test
    public void testRandomKeys() {
        for ( int loop=0; loop < 1000; loop++) {
            String key = new KeyGenerator().generateKey();
            String plainText = "A random String \"with some\" weird chars z?1";
            String encrypted = substitutionCipher.encrypt(plainText, key);
            String decrypted = substitutionCipher.decrypt(encrypted, key);
            assertEquals(plainText, decrypted);

        }
    }
}