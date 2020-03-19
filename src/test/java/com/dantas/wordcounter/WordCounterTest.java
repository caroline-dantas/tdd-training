package com.dantas.wordcounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {
    private WordCounter counter = new WordCounter();

    @Test
    public void emptyStringHasNoWordsTest() {
        counter.add("");
        assertEquals(0, counter.getUniqueWordCount());
    }

    @Test
    public void oneWordSentenceHasOneWordTest() {
        counter.add("Andressa");
        assertEquals(1, counter.getUniqueWordCount());
    }

    @Test
    public void twoWordSentenceHasTwoWordsTest() {
        counter.add("Andressa");
        counter.add("Dantas");
        assertEquals(2, counter.getUniqueWordCount());
    }

    @Test
    public void multiWordSentenceHasCorrectWordCountTest() {
        counter.add("one two tree");
        assertEquals(3, counter.getUniqueWordCount());
    }

    @Test
    public void spacedOutMultiWordSentenceHasCorrectWordCountTest() {
        counter.add(" one   two  tree  ");
        assertEquals(3, counter.getUniqueWordCount());
    }

    @Test
    public void severalMultiWordSentenceHasCorrectWordCountTest() {
        counter.add("one two tree");
        counter.add("four five six");
        assertEquals(6, counter.getUniqueWordCount());
    }

    @Test
    public void duplicateWordSentenceHasCorrectWordCountTest() {
        counter.add("one two two");
        assertEquals(2, counter.getUniqueWordCount());
    }

    @Test
    public void mixedCaseDuplicateWordSentenceHasCorrectWordCountTest() {
        counter.add("one One ONE");
        assertEquals(1, counter.getUniqueWordCount());
    }

    @Test
    public void punctuationDuplicateWordSentenceHasCorrectWordCountTest() {
        counter.add("one. ");
        counter.add("one, two");
        counter.add("one, two!");
        assertEquals(2, counter.getUniqueWordCount());
    }
}