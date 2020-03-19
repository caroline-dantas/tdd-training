package wordcounter;

import org.junit.jupiter.api.Test;
import wordcounter.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {
    private WordCounter counter = new WordCounter();

    @Test
    public void emptyStringHasNoWords() {
        counter.add("");
        assertEquals(0, counter.getUniqueWordCount());
    }

    @Test
    public void oneWordSentenceHasOneWord() {
        counter.add("Andressa");
        assertEquals(1, counter.getUniqueWordCount());
    }

    @Test
    public void twoWordSentenceHasTwoWords() {
        counter.add("Andressa");
        counter.add("Dantas");
        assertEquals(2, counter.getUniqueWordCount());
    }

    @Test
    public void multiWordSentenceHasCorrectWordCount() {
        counter.add("one two tree");
        assertEquals(3, counter.getUniqueWordCount());
    }

    @Test
    public void spacedOutMultiWordSentenceHasCorrectWordCount() {
        counter.add(" one   two  tree  ");
        assertEquals(3, counter.getUniqueWordCount());
    }

    @Test
    public void severalMultiWordSentenceHasCorrectWordCount() {
        counter.add("one two tree");
        counter.add("four five six");
        assertEquals(6, counter.getUniqueWordCount());
    }

    @Test
    public void duplicateWordSentenceHasCorrectWordCount() {
        counter.add("one two two");
        assertEquals(2, counter.getUniqueWordCount());
    }

    @Test
    public void mixedCaseDuplicateWordSentenceHasCorrectWordCount() {
        counter.add("one One ONE");
        assertEquals(1, counter.getUniqueWordCount());
    }

    @Test
    public void punctuationDuplicateWordSentenceHasCorrectWordCount() {
        counter.add("one. ");
        counter.add("one, two");
        counter.add("one, two!");
        assertEquals(2, counter.getUniqueWordCount());
    }
}