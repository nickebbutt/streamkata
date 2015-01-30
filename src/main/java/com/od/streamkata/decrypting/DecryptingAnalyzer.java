package com.od.streamkata.decrypting;

        import java.io.BufferedReader;
        import java.util.Set;
        import java.util.function.Supplier;

/**
 * Created by nick on 23/01/15.
 */
public interface DecryptingAnalyzer {

    public Set<String> findAllLinesContaining(Supplier<BufferedReader> cipherTextSupplier, String searchTerm);

    public Set<String> findSomeLinesContaining(Supplier<BufferedReader> cipherTextSupplier, int numberToFind, String searchTerm);

}
