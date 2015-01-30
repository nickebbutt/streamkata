package com.od.streamkata.util;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by GA2EBBU on 27/01/2015.
 */
public class StreamUtils {

    public static <V, R> R processAndClose(Supplier<Stream<V>> streamSupplier, Function<Stream<V>, R> processing) {
        try ( Stream<V> lines = streamSupplier.get()) {
           return processing.apply(lines);
        }
    }

    public static Predicate<String> contains(String term) { return s -> s.contains(term); }
}