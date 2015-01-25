package com.od.cryptokata.plaintext;

import java.io.FileNotFoundException;

/**
 * Created by Nick on 22/01/2015.
 */
public class StreamingMessageAnalyzerTest extends AbstractAnalyzerTest {

    @Override
    protected MessageAnalyzer createAnalyzer() throws FileNotFoundException {
        return new StreamingMessageAnalyzer();
    }
}
