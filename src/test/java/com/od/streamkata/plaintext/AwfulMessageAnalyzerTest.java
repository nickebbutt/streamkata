package com.od.streamkata.plaintext;

import java.io.FileNotFoundException;

public class AwfulMessageAnalyzerTest extends AbstractAnalyzerTest {

    @Override
    protected MessageAnalyzer createAnalyzer() throws FileNotFoundException {
        return new AwfulMessageAnalyzer();
    }
}