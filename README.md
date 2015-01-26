# streamkata

A code kata to practise Java 8 functional programming with streams

### Your mission - Primary Objectives ###

This kata lets you experiment with Streams and functional programming in Java 8.

The exercise is based around two interfaces:

* MessageAnalyser
* DecryptingAnalyser

These can be used to find words and phrases in a plain text file or an encrypted file

Two working but awful implementations are provided, along with tests  
The tests take longer to run than they should, you should be able to do better with streams.

Your mission is to complete the Stream-based implementations, using as much cool stuff from JDK 8 as you feel you can justify.

* Get familiar with Streams, Predicates, Map and FlatMap, Collectors
* Try lambda expressions, method references and functions as instances of java.util.function.Function and its related classes
* Use 'Try-With-Resources (from jdk 1.7)' to keep things tidy since Stream implements AutoCloseable
* Have a look at the new 'default' methods on Iterator, and have a think about default methods in general.
* How is the 'Spliterator' related to the Stream API?
* To what extent will be benefit from parallelism in the streams used for this exercise?

### Your mission - Secondary Targets ###

If you get finished early, here are some more possible exercises:

* Add a method to return a List of Tuple, where the Tuple contains a line number and a search result. Implement Tuple
* Add a method to return the number of times each word appears, given a list of search words as input










