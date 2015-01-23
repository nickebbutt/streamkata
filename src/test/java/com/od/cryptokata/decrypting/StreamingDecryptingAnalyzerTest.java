package com.od.cryptokata.decrypting;

import java.io.BufferedReader;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Nick on 22/01/2015.
 */
public class StreamingDecryptingAnalyzerTest extends AbstractDecryptingAnalyzerTest {


    @Override
    protected StreamingDecryptingAnalyzer createAnalyzer(Supplier<BufferedReader> readerSupplier, List<String> decryptionKeys) {
        return new StreamingDecryptingAnalyzer(readerSupplier, decryptionKeys);
    }
}
