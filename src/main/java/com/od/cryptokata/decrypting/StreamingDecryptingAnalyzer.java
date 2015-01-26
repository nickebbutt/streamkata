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

        //We don't know which key will decrypt the cipher text

        //Since we are using a simple substitution cipher, if we decrypt using the wrong key the operation will succeed but
        //we may still end up with a cipher text result

        //One possibility is to decrypt line by line trying all the keys we know
        //Hint: can you use flatmap for this? How might we improve the search time?

        return Collections.emptySet();  //TODO - fix me
    }

    @Override
    public Set<String> findSomeLinesContaining(Supplier<BufferedReader> cipherTextSupplier, int numberToFind, String searchTerm) {
        return Collections.emptySet();  //TODO - fix me
    }
}
