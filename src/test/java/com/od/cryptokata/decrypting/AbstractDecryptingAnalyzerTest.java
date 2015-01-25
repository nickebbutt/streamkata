package com.od.cryptokata.decrypting;

import com.od.cryptokata.util.MessageReaders;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static com.od.cryptokata.util.RunWithTiming.runWithTiming;
import static junit.framework.TestCase.assertEquals;
import static com.od.cryptokata.util.MessageReaders.getCipherTextReader;

/**
 * Test for decrypting analyzers
 */
public abstract class AbstractDecryptingAnalyzerTest {

    private DecryptingAnalyzer messageAnalyser;

    @Before
    public void setUp() throws IOException {
        messageAnalyser = createAnalyzer(MessageReaders.getDecryptionKeys());
    }

    @Test
    public void testFindAllLinesContaining() throws Exception {
        runWithTiming(getClass().getSimpleName() + " testFindAllLinesContaining ", () -> {
            Set<String> results = messageAnalyser.findAllLinesContaining(getCipherTextReader(), "Napoleon");
            assertEquals(582, results.size());
        });
    }

    @Test
    public void testFindSomeLinesContaining() throws Exception {
        runWithTiming(getClass().getSimpleName() + " testFindSomeLinesContaining ", () -> {
            Set<String> results = messageAnalyser.findSomeLinesContaining(getCipherTextReader(), 4, "Napoleon");
            assertEquals(4, results.size());
        });
    }


    /**
     * Subclass implement to supply the MessageAnalyzer we are testing
     */
    protected abstract DecryptingAnalyzer createAnalyzer(List<String> decryptionKeys);
}
