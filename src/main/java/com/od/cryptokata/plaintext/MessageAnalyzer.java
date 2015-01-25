package com.od.cryptokata.plaintext;


import java.io.BufferedReader;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by Nick on 22/01/2015.
 */
public interface MessageAnalyzer {

    long countLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm);

    Set<String> findAllLinesContaining(Supplier<BufferedReader> plainTextSupplier, String searchTerm);

    Set<String> findSomeLinesContaining(Supplier<BufferedReader> plainTextSupplier, int numberToFind, String searchTerm);

}
