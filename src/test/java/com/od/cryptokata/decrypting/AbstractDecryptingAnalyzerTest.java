package com.od.cryptokata.decrypting;

import com.od.cryptokata.util.MessageReaders;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static com.od.cryptokata.util.RunWithTiming.runWithTiming;
import static junit.framework.TestCase.assertEquals;

/**
 * Test for decrypting analyzers
 */
public abstract class AbstractDecryptingAnalyzerTest {

    private DecryptingAnalyzer messageAnalyser;

    @Before
    public void setUp() throws IOException {
        messageAnalyser = createAnalyzer(MessageReaders.getCipherTextReader(), MessageReaders.getDecryptionKeys());
    }

    @Test
    public void testGetNMatches() throws Exception {
        runWithTiming(getClass().getSimpleName() + " findMatches ", () -> {
            Set<String> results = messageAnalyser.findMatches("Napoleon", 4);
            assertEquals(4, results.size());
        });
    }

    @Test
    public void testGetAllMatches() throws Exception {
        runWithTiming(getClass().getSimpleName() + " findAllMatches ", () -> {
            Set<String> results = messageAnalyser.findAllMatches("Napoleon");
            assertEquals(582, results.size());
        });
    }

    /**
     * Subclass implement to supply the MessageAnalyzer we are testing
     */
    protected abstract DecryptingAnalyzer createAnalyzer(Supplier<BufferedReader> readerSupplier, List<String> decryptionKeys);
}
