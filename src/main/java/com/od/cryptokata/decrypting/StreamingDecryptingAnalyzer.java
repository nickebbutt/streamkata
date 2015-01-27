package com.od.cryptokata.decrypting;

import com.od.cryptokata.util.Cipher;
import com.od.cryptokata.util.SubstitutionCipher;

import java.io.BufferedReader;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.od.cryptokata.util.StreamUtils.contains;
import static com.od.cryptokata.util.StreamUtils.processAndClose;

/**
 * Created by nick on 23/01/15.
 */
public class StreamingDecryptingAnalyzer implements DecryptingAnalyzer {

    private final List<String> keys;
    private final Cipher substitutionCipher = new SubstitutionCipher();

    public StreamingDecryptingAnalyzer(List<String> keys) {
        this.keys = keys;
    }

    public Set<String> findAllLinesContaining(Supplier<BufferedReader> cipherTextSupplier, String searchTerm) {
        return processAndClose(cipherTextSupplier.get()::lines,
            lines -> {
                return lines
                        .parallel()
                        .flatMap(streamOfDecryptedValues())
                        .filter(contains(searchTerm))
                        .collect(Collectors.toSet());
            }
        );
    }

    public Set<String> findSomeLinesContaining(Supplier<BufferedReader> cipherTextSupplier, int numberToFind, String searchTerm) {
        return processAndClose(cipherTextSupplier.get()::lines,
            lines -> {
                return lines
                        .flatMap(streamOfDecryptedValues())
                        .filter(contains(searchTerm))
                        .limit(numberToFind)
                        .collect(Collectors.toSet());
            }
        );
    }

    private Function<String, Stream<String>> streamOfDecryptedValues() {
        return s -> keys.stream().map(
                k -> substitutionCipher.decrypt(s, k));
    }

}
