package com.od.cryptokata.decrypting;

import java.io.BufferedReader;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by nick on 23/01/15.
 */
public class AwfulDecryptingAnalyzerTest extends AbstractDecryptingAnalyzerTest {

    @Override
    protected AwfulDecryptingAnalyzer createAnalyzer(Supplier<BufferedReader> readerSupplier, List<String> decryptionKeys) {
        return new AwfulDecryptingAnalyzer(readerSupplier, decryptionKeys);
    }
}
