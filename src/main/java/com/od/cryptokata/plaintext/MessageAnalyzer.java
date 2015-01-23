package com.od.cryptokata.plaintext;


import java.util.List;
import java.util.Set;

/**
 * Created by Nick on 22/01/2015.
 */
public interface MessageAnalyzer {

    long countLinesContainingWord(String searchWord);

    Set<String> findAllMatches(List<String> patterns);

    Set<String> findMatches(int matchCount, List<String> patterns);

}
