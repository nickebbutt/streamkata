package com.od.cryptokata.plaintext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * Created by Nick on 22/01/2015.
 *
 * Awful MessageAnalyzer
 *
 * A very bad MessageAnalyzer written with Jdk 1.7 -
 * don't copy this
 */
public class AwfulPlainTextAnalyzer implements MessageAnalyzer {

    private Supplier<BufferedReader> readerSupplier;

    public AwfulPlainTextAnalyzer(Supplier<BufferedReader> readerSupplier) {
        this.readerSupplier = readerSupplier;
    }

    @Override
    public long countLinesContainingWord(String searchWord) {
        List<String> plainText = readMessage();
        int count = 0;
        for ( String s : plainText) {
            if ( s.contains(searchWord)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Set<String> findAllMatches(List<String> patterns) {
        List<String> plainText = readMessage();
        Set<String> matchingLines = new HashSet<>();
        for (String s : plainText) {
            for (String p : patterns) {
                if (Pattern.compile(p).matcher(s).find()) {
                    matchingLines.add(s);
                }
            }
        }
        return matchingLines;
    }

    @Override
    public Set<String> findMatches(int matchCount, List<String> patterns) {
        List<String> plainText = readMessage();
        Set<String> matchingLines = new HashSet<>();
        int count = 0;
        for (String s : plainText) {
            for (String p : patterns) {
                if (Pattern.compile(p).matcher(s).find() && ++count <= matchCount) {
                    matchingLines.add(s);
                }
            }
        }
        return matchingLines;
    }


    public List<String> readMessage() {
        List<String> messageContents = new ArrayList<>();

        //read the buffer handling the exceptions the old jdk 1.5 way
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = readerSupplier.get();
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
