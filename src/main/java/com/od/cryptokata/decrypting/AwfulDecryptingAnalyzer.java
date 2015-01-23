package com.od.cryptokata.decrypting;

import com.od.cryptokata.plaintext.AwfulPlainTextAnalyzer;
import com.od.cryptokata.util.DecryptingReader;

import java.io.BufferedReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by nick on 22/01/15.
 */
public class AwfulDecryptingAnalyzer implements DecryptingAnalyzer {

    private Supplier<BufferedReader> cipherTextSupplier;
    private List<String> keys;

    public AwfulDecryptingAnalyzer(Supplier<BufferedReader> cipherTextSupplier, List<String> keys) {
        this.cipherTextSupplier = cipherTextSupplier;
        this.keys = keys;
    }

    @Override
    public Set<String> findMatches(String knownPlaintext, int matchCount) {
        Set<String> matches = new HashSet<>();
        for ( String key : keys) {
            AwfulPlainTextAnalyzer plainTextAnalyzer = new AwfulPlainTextAnalyzer(new Supplier<BufferedReader>() {
                public BufferedReader get() {
                    return new DecryptingReader(cipherTextSupplier.get(), key);
                }
            });

            matches.addAll(plainTextAnalyzer.findMatches(matchCount - matches.size(), Collections.singletonList(knownPlaintext)));
            if ( matches.size() >= matchCount) {
                break;
            }
        }
        return matches;
    }

    @Override
    public Set<String> findAllMatches(String knownPlaintext) {
        return findMatches(knownPlaintext, Integer.MAX_VALUE);
    }

}
