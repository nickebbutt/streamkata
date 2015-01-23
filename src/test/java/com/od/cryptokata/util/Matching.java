package com.od.cryptokata.util;

import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Created by GA2EBBU on 23/01/2015.
 */
public class Matching {
    public static Consumer<String> matchesAtLeastOne(List<String> patterns) {
        return r -> assertTrue(patterns.stream().anyMatch(p -> Pattern.compile(p).matcher(r).find()));
    }
}
