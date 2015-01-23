package com.od.cryptokata.plaintext;

import com.od.cryptokata.util.AbstractStreamingAnalyzer;

import java.io.BufferedReader;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nick on 22/01/2015.
 */
public class StreamingPlainTextAnalyzer extends AbstractStreamingAnalyzer implements MessageAnalyzer {

    private Supplier<BufferedReader> readerSupplier;

    public StreamingPlainTextAnalyzer(Supplier<BufferedReader> readerSupplier) {
        this.readerSupplier = readerSupplier;
    }

    @Override
    public long countLinesContainingWord(String searchWord) {
        try ( Stream<String> lines = readerSupplier.get().lines() ) {
            return lines.filter(contains(searchWord)).count();
        }
    }

    @Override
    public Set<String> findAllMatches(List<String> patterns) {
        try ( Stream<String> lines = readerSupplier.get().lines() ) {
            return lines.parallel().filter(matches(compile(patterns))).collect(Collectors.toSet());
        }
    }

    @Override
    public Set<String> findMatches(int matchCount, List<String> patterns) {
        try ( Stream<String> lines = readerSupplier.get().lines() ) {
            return lines.filter(matches(compile(patterns))).limit(matchCount).collect(Collectors.toSet());
        }
    }

}
