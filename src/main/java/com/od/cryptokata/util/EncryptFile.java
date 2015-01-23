package com.od.cryptokata.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Encrypt a file
 */
public class EncryptFile {

    public static void main(String[] args) {
        try (
            PrintWriter bw = new PrintWriter(new FileWriter(new File("src/main/resources/newCipherText.txt")));
            Stream<String> in = Files.lines(Paths.get("src/main/resources/plainText.txt"))
        ) {

            String key = new KeyGenerator().generateKey();
            bw.println("Key:");
            bw.println("-------");
            bw.println(key);
            bw.println("-------");

            SubstitutionCipher substitutionCipher = new SubstitutionCipher();
            in.map(s -> substitutionCipher.encrypt(s, key)).forEach(s -> {bw.println(s);});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
