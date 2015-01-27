package com.od.cryptokata.plaintext;

import java.io.BufferedReader;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.od.cryptokata.util.StreamUtils.processAndClose;

/**
 * Created by Nick on 22/01/2015.
 */
public class StreamingMessageAnalyzer implements MessageAnalyzer {

    @Override
    public long countLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm) {
        return processAndClose(plainTextSupplier.get()::lines,
            lines -> {
                return lines
                        .filter(s -> s.contains(searchTerm))
                        .count();
            });
    }

    @Override
    public Set<String> findAllLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm) {
        return processAndClose(plainTextSupplier.get()::lines,
            lines -> {
                return lines
                        .filter(s -> s.contains(searchTerm))
                        .collect(Collectors.toSet());
            });
    }

    @Override
    public Set<String> findSomeLinesContaining(Supplier<BufferedReader> plainTextSupplier, int numberToFind, String searchTerm) {
        return processAndClose(plainTextSupplier.get()::lines,
            lines -> {
                return lines
                        .filter(s -> s.contains(searchTerm))
                        .limit(numberToFind)
                        .collect(Collectors.toSet());
            });
    }

    @Override
    public Set<String> findSomeLinesCaseInsensitive(Supplier<BufferedReader> plainTextSupplier, int numberToFind, String searchTerm) {
        return processAndClose(plainTextSupplier.get()::lines,
            lines -> {
                return lines
                        .map(String::toUpperCase)
                        .filter(s -> s.contains(searchTerm.toUpperCase()))
                        .limit(numberToFind)
                        .collect(Collectors.toSet());
        });
    }

}
