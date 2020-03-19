package wordcounter;

import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    private Set<String> uniqueWords = new HashSet<>();

    public void add(String sentence) {
        if (sentence.isEmpty()) {
            return;
        }
        String [] words = sentence.trim().toLowerCase().split("[.,!? ]+");
        for (String s : words) {
            uniqueWords.add(s);
        }
    }

    public int getUniqueWordCount() {
        return uniqueWords.size();
    }
}
