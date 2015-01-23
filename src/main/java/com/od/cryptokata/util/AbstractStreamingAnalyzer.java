package com.od.cryptokata.util;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Nick on 23/01/2015.
 */
public class AbstractStreamingAnalyzer {

    protected List<Pattern> compile(List<String> patterns) {
        return patterns.stream().map(Pattern::compile).collect(Collectors.toList());
    }

    protected Predicate<String> matches(List<Pattern> patternList) {
        return s -> patternList.stream().anyMatch(p -> p.matcher(s).find());
    }

    protected Predicate<String> contains(String substring) {
        return s -> s.contains(substring);
    }

    public static Consumer<String> valuePeaker() {
        return s -> System.out.println("Thread " + Thread.currentThread() + " Value " + s);
    }

}
