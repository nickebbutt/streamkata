package com.od.cryptokata.decrypting;

import com.od.cryptokata.util.AbstractStreamingAnalyzer;
import com.od.cryptokata.util.SubstitutionCipher;

import java.io.BufferedReader;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nick on 23/01/15.
 */
public class StreamingDecryptingAnalyzer extends AbstractStreamingAnalyzer implements DecryptingAnalyzer {

    private final Supplier<BufferedReader> cipherTextSupplier;
    private final List<String> keys;
    private final SubstitutionCipher substitutionCipher = new SubstitutionCipher();

    public StreamingDecryptingAnalyzer(Supplier<BufferedReader> cipherTextSupplier, List<String> keys) {
        this.cipherTextSupplier = cipherTextSupplier;
        this.keys = keys;
    }

    public Set<String> findMatches(String knownPlaintext, int matchCount) {
        try ( Stream<String> lines = cipherTextSupplier.get().lines() ) {
            return lines.flatMap(streamOfDecryptedValues()).filter(
                    contains(knownPlaintext)).limit(matchCount).collect(Collectors.toSet());
        }
    }

    public Set<String> findAllMatches(String knownPlaintext) {
        try ( Stream<String> lines = cipherTextSupplier.get().lines() ) {
            return lines.parallel().flatMap(streamOfDecryptedValues()).filter(
                    contains(knownPlaintext)).collect(Collectors.toSet());
        }
    }

    private Function<String, Stream<? extends String>> streamOfDecryptedValues() {
        return s -> keys.stream().map(
                k -> substitutionCipher.decrypt(s, k));
    }
}
