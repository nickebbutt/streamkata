package com.od.streamkata.util;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by nick on 22/01/15.
 *
 * Decrypt from a BufferedReader using the decryptionKey
 * Only the readLine() method decrypts
 */
public class DecryptingReader extends BufferedReader {

    private final BufferedReader reader;
    private String decryptionKey;
    private SubstitutionCipher substitutionCipher = new SubstitutionCipher();

    public DecryptingReader(BufferedReader reader, String decryptionKey) {
        super(reader);
        this.reader = reader;
        this.decryptionKey = decryptionKey;
    }

    public String readLine() throws IOException {
        String l = reader.readLine();
        return l == null ? null : substitutionCipher.decrypt(l, decryptionKey);
    }
}
