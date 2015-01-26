package com.od.cryptokata.plaintext;


import java.io.BufferedReader;
import java.util.Collections;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by Nick on 22/01/2015.
 */
public class StreamingMessageAnalyzer implements MessageAnalyzer {

    // Stream<String> lines = plainTextSupplier.get().lines()

    @Override
    public long countLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm) {
        return 0; // TODO - Fix me
    }

    @Override
    public Set<String> findAllLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm) {
        return Collections.emptySet();  // TODO - Fix me
    }

    @Override
    public Set<String> findSomeLinesContaining(Supplier<BufferedReader> plainTextSupplier, int numberToFind, String searchTerm) {
        return Collections.emptySet();   // TODO - Fix me
    }

    @Override
    public Set<String> findSomeLinesCaseInsensitive(Supplier<BufferedReader> plainTextSupplier, int numberToFind, String searchTerm) {
        return Collections.emptySet();   // TODO - Fix me
    }
}
