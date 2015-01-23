# streamkata

A code kata to practise Java 8 functional programming with streams

### Preamble, not at all contrived ###

While stowing your White Tuxedo/Black Cocktail Dress after a well-lubricated Christmas party you fall into your wardrobe (it could happen to anybody) and wake up in an alternate reality. It's late September 1812, and it's freezing. You're holed up in a leaking Muscovite garret, and the city is about to be crushed by Napolean's advance.

Luckily someone left you a cache of cipher keys and some intercepted communications from the Grande Armée. If only you'd brought your Macbook Pro with you, you'd be able to decrypt Napoleon's secret communications, and perhaps turn the tide of the war...

### Your mission ###

This kata provides a means of experimenting with Streams and functional programming in Java 8.

The exercise is based around two interfaces:

* MessageAnalyser
* DecryptingAnalyser

These can be used to count words and find phrases, in a plain text file or an encrypted file  
An encrypted ciphertext is provided along with several keys, only one of which will decrypt it.

Two working but awful implementations are provided, along with tests - these monstrosities employ outmoded java 5 constructs (in keeping with the 19th century theme). They take much longer to run than they should. Perhaps the developer was recovering from a Christmas party at the time.

Your mission is to complete the Stream-based implementations for MessageAnalyser and DecryptingAnalyser, using as much cool stuff from JDK 8 as you can justify.  
These should be a lot prettier and run faster. 









