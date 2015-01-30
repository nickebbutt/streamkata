package com.od.streamkata.decrypting;

import java.util.List;

/**
 * Created by Nick on 22/01/2015.
 */
public class StreamingDecryptingAnalyzerTest extends AbstractDecryptingAnalyzerTest {

    @Override
    protected StreamingDecryptingAnalyzer createAnalyzer(List<String> decryptionKeys) {
        return new StreamingDecryptingAnalyzer(decryptionKeys);
    }
}
