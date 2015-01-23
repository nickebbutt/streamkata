package com.od.cryptokata.plaintext;

import com.od.cryptokata.util.Matching;
import com.od.cryptokata.util.MessageReaders;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static com.od.cryptokata.util.RunWithTiming.runWithTiming;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test for plain Analyzers
 */
public abstract class AbstractAnalyzerTest {

    private MessageAnalyzer messageAnalyser;

    @Before
    public void setUp() throws FileNotFoundException {
        messageAnalyser = createAnalyzer(MessageReaders.getPlainTextReader());
    }

    @Test
    public void testCountLinesContaining() throws Exception {
        runWithTiming(getClass().getSimpleName() + " countLinesContaining", () -> {
            assertEquals("Should be 100 lines containing cannon",
                100, messageAnalyser.countLinesContainingWord("cannon")
            );
        });
    }

    @Test
    public void testFindAllMatches() throws Exception {
        runWithTiming(getClass().getSimpleName() + " findAllMatches", () -> {

            List<String> patterns = Arrays.asList(
                    "England.*done",
                    "slyboots",
                    "the famous Count");

            Set<String> results = messageAnalyser.findAllMatches(patterns);
            assertEquals(3, results.size());
            results.forEach(Matching.matchesAtLeastOne(patterns));
        });
    }


    @Test
    public void testFindMatches() throws Exception {
        runWithTiming(getClass().getSimpleName() + " findMatches", () -> {
            List<String> patterns = Arrays.asList(
                    "Zat, my dear sir.*",
                    "reproach");

            Set<String> results = messageAnalyser.findMatches(4, patterns);
            assertEquals(4, results.size());
            results.forEach(Matching.matchesAtLeastOne(patterns));
        });
    }

    /**
     * Subclass implement to supply the MessageAnalyzer we are testing
     */
    protected abstract MessageAnalyzer createAnalyzer(Supplier<BufferedReader> readerSupplier) throws FileNotFoundException;


}
