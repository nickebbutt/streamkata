package com.od.cryptokata.plaintext;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Set;

import static com.od.cryptokata.util.MessageReaders.getPlainTextReader;
import static com.od.cryptokata.util.RunWithTiming.runWithTiming;
import static junit.framework.TestCase.assertEquals;

/**
 * Test for plain Analyzers
 */
public abstract class AbstractAnalyzerTest {

    private MessageAnalyzer messageAnalyser;

    @Before
    public void setUp() throws FileNotFoundException {
        messageAnalyser = createAnalyzer();
    }

    @Test
    public void testCountLinesContaining() throws Exception {
        runWithTiming(getClass().getSimpleName() + " countLinesContaining", () -> {
            assertEquals(100, messageAnalyser.countLinesContaining(getPlainTextReader(), "cannon")
            );
        });
    }

    @Test
    public void testFindAllLinesContaining() throws Exception {
        runWithTiming(getClass().getSimpleName() + " testFindAllLinesContaining", () -> {
            Set<String> results = messageAnalyser.findAllLinesContaining(getPlainTextReader(), "England");
            assertEquals(15, results.size());
            //results.forEach(System.out::println);
        });
    }

    @Test
    public void testFindSomeLinesContaining() throws Exception {
        runWithTiming(getClass().getSimpleName() + " testFindSomeLinesContaining", () -> {
            Set<String> results = messageAnalyser.findSomeLinesContaining(getPlainTextReader(), 4, "Napoleon");
            assertEquals(4, results.size());
        });
    }

    @Test
    public void testFindSomeLinesCaseInsensitive() throws Exception {
        runWithTiming(getClass().getSimpleName() + " testFindSomeLinesCaseInsensitive", () -> {
            Set<String> results = messageAnalyser.findSomeLinesCaseInsensitive(getPlainTextReader(), 100, "wine");
            assertEquals(57, results.size());
        });
    }

    /**
     * Subclass implement to supply the MessageAnalyzer we are testing
     */
    protected abstract MessageAnalyzer createAnalyzer() throws FileNotFoundException;


}
