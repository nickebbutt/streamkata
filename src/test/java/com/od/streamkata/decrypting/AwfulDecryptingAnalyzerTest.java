package com.od.streamkata.decrypting;

import java.util.List;

/**
 * Created by nick on 23/01/15.
 */
public class AwfulDecryptingAnalyzerTest extends AbstractDecryptingAnalyzerTest {

    @Override
    protected AwfulDecryptingAnalyzer createAnalyzer(List<String> decryptionKeys) {
        return new AwfulDecryptingAnalyzer(decryptionKeys);
    }
}
