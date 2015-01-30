package com.od.streamkata.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nick on 22/01/2015.
 */
public class MessageReaders {

    public static final String PLAINTEXT_FILE_PATH = "src/main/resources/plainText.txt";
    public static final String CIPHERTEXT_FILE_PATH = "src/main/resources/cipherText.txt";
    public static final String KEY_FILE_PATH = "src/main/resources/cipherKeys.txt";


    public static Supplier<BufferedReader> getPlainTextReader() {
        return () -> {
            try {
                return new BufferedReader(new FileReader(PLAINTEXT_FILE_PATH));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Failed to read file", e);
            }
        };
    }

    public static Supplier<BufferedReader> getCipherTextReader() {
        return () -> {
            try {
                return new BufferedReader(new FileReader(CIPHERTEXT_FILE_PATH));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Failed to read file", e);
            }
        };
    }

    public static List<String> getDecryptionKeys() throws IOException {
        try ( Stream<String> keysStream = Files.lines(Paths.get(KEY_FILE_PATH)) ) {
            return keysStream.collect(Collectors.toList());
        }
    }
}
