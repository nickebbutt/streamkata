package com.od.cryptokata.decrypting;

import com.od.cryptokata.util.Cipher;
import com.od.cryptokata.util.SubstitutionCipher;

import java.io.BufferedReader;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by nick on 23/01/15.
 */
public class StreamingDecryptingAnalyzer implements DecryptingAnalyzer {

    private final List<String> keys;
    private final Cipher cipher = new SubstitutionCipher();

    public StreamingDecryptingAnalyzer(List<String> keys) {
        this.keys = keys;
    }

    @Override
    public Set<String> findAllLinesContaining(Supplier<BufferedReader> cipherTextSupplier, String searchTerm) {
        return Collections.emptySet();  //TODO - fix me
    }

    @Override
    public Set<String> findSomeLinesContaining(Supplier<BufferedReader> cipherTextSupplier, int numberToFind, String searchTerm) {
        return Collections.emptySet();  //TODO - fix me
    }
}
