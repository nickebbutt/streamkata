package com.od.streamkata.decrypting;

import com.od.streamkata.plaintext.AwfulMessageAnalyzer;
import com.od.streamkata.util.DecryptingReader;

import java.io.BufferedReader;
import java.util.*;
import java.util.function.Supplier;

/**
 * Created by nick on 22/01/15.
 */
public class AwfulDecryptingAnalyzer implements DecryptingAnalyzer {

    private List<String> keys;

    public AwfulDecryptingAnalyzer(List<String> keys) {
        this.keys = keys;
    }

    @Override
    public Set<String> findSomeLinesContaining(Supplier<BufferedReader> cipherTextSupplier, int numberToFind, String searchTerm) {
        List<Supplier<BufferedReader>> decryptingReaders = getDecryptingReaders(cipherTextSupplier);
        LinkedList<String> matches = getMatches(numberToFind, searchTerm, decryptingReaders);
        return new HashSet<>(matches);
    }

    private LinkedList<String> getMatches(int matchCount, String searchTerm, List<Supplier<BufferedReader>> decryptingReaders) {
        LinkedList<String> matches = new LinkedList<>();
        for ( Supplier<BufferedReader> s : decryptingReaders) {

            int remainingToFind = matchCount - matches.size();

            AwfulMessageAnalyzer plainAnalyzer = new AwfulMessageAnalyzer();
            matches.addAll(plainAnalyzer.findSomeLinesContaining(s, remainingToFind, searchTerm));

            if ( matches.size() >= matchCount) {
                break;
            }
        }
        return matches;
    }

    //We don't know which is the correct key so try decrypting with each in turn
    private List<Supplier<BufferedReader>> getDecryptingReaders(Supplier<BufferedReader> cipherTextSupplier) {
        List<Supplier<BufferedReader>> decryptingReaders = new ArrayList<>();
        for ( String key : keys) {
            decryptingReaders.add( () -> new DecryptingReader(cipherTextSupplier.get(), key));
        }
        return decryptingReaders;
    }

    @Override
    public Set<String> findAllLinesContaining(Supplier<BufferedReader> cipherTextSupplier, String searchTerm) {
        return findSomeLinesContaining(cipherTextSupplier, Integer.MAX_VALUE, searchTerm);
    }

}
