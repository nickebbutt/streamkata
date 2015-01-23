package com.od.cryptokata.plaintext;

import com.od.cryptokata.util.AbstractStreamingAnalyzer;

import java.io.BufferedReader;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

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
        // Stream<String> lines = readerSupplier.get().lines()
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public Set<String> findAllMatches(List<String> patterns) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public Set<String> findMatches(int matchCount, List<String> patterns) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

}
