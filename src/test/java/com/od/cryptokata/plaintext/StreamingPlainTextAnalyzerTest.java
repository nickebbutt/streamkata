package com.od.cryptokata.plaintext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.function.Supplier;

/**
 * Created by Nick on 22/01/2015.
 */
public class StreamingPlainTextAnalyzerTest extends AbstractAnalyzerTest {

    @Override
    protected MessageAnalyzer createAnalyzer(Supplier<BufferedReader> readerSupplier) throws FileNotFoundException {
        return new StreamingPlainTextAnalyzer(readerSupplier);
    }
}
