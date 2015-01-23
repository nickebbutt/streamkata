package com.od.cryptokata.plaintext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.function.Supplier;

public class AwfulPlainTextAnalyzerTest extends AbstractAnalyzerTest {

    @Override
    protected MessageAnalyzer createAnalyzer(Supplier<BufferedReader> readerSupplier) throws FileNotFoundException {
        return new AwfulPlainTextAnalyzer(readerSupplier);
    }
}