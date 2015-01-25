package com.od.cryptokata.plaintext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by Nick on 22/01/2015.
 *
 * A bad MessageAnalyzer written with Jdk 1.5 language constructs -
 * don't copy this
 */
public class AwfulPlainTextAnalyzer implements MessageAnalyzer {


    @Override
    public long countLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm) {
        List<String> plainText = readMessage(plainTextSupplier);
        int count = 0;
        for ( String s : plainText) {
            if ( s.contains(searchTerm)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Set<String> findAllLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm) {
        List<String> plainText = readMessage(plainTextSupplier);
        Set<String> matchingLines = new HashSet<>();
        for (String s : plainText) {
            if ( s.contains(searchTerm)) {
                matchingLines.add(s);
            }
        }
        return matchingLines;
    }

    @Override
    public Set<String> findSomeLinesContaining(Supplier<BufferedReader> plainTextSupplier, int numberToFind, String searchTerm) {
        List<String> plainText = readMessage(plainTextSupplier);
        Set<String> matchingLines = new HashSet<>();
        int count = 0;
        for (String s : plainText) {
            if ( s.contains(searchTerm)) {
                matchingLines.add(s);

                if ( ++count == numberToFind) {
                    break;
                }
            }
        }
        return matchingLines;
    }


    public List<String> readMessage(Supplier<BufferedReader> supplier) {
        List<String> messageContents = new ArrayList<>();

        //read the buffer handling the exceptions the old jdk 1.5 way
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = supplier.get();
            String s = bufferedReader.readLine();
            while ( s != null) {
                messageContents.add(s);
                s = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return messageContents;
    }

}
