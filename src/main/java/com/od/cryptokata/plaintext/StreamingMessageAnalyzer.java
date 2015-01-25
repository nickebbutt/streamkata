package com.od.cryptokata.plaintext;

import java.io.BufferedReader;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nick on 22/01/2015.
 */
public class StreamingMessageAnalyzer implements MessageAnalyzer {

    @Override
    public long countLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm) {
        try ( Stream<String> lines = plainTextSupplier.get().lines() ) {
            return lines.filter(s -> s.contains(searchTerm)).count();
        }
    }

    @Override
    public Set<String> findAllLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm) {
        try ( Stream<String> lines = plainTextSupplier.get().lines() ) {
            return lines.filter(s -> s.contains(searchTerm)).collect(Collectors.toSet());
        }
    }

    @Override
    public Set<String> findSomeLinesContaining(Supplier<BufferedReader> plainTextSupplier, int numberToFind, String searchTerm) {
        try ( Stream<String> lines = plainTextSupplier.get().lines() ) {
            return lines.filter(s -> s.contains(searchTerm)).limit(numberToFind).collect(Collectors.toSet());
        }
    }

}
