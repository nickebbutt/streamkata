package com.od.cryptokata.decrypting;

import java.util.Set;

/**
 * Created by nick on 23/01/15.
 */
public interface DecryptingAnalyzer {

    public Set<String> findMatches(String knownPlaintext, int matchCount);

    public Set<String> findAllMatches(String knownPlaintext);

}
