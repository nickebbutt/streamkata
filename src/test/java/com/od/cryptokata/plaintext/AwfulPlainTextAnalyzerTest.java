package com.od.cryptokata.plaintext;

import java.io.FileNotFoundException;

public class AwfulPlainTextAnalyzerTest extends AbstractAnalyzerTest {

    @Override
    protected MessageAnalyzer createAnalyzer() throws FileNotFoundException {
        return new AwfulPlainTextAnalyzer();
    }
}