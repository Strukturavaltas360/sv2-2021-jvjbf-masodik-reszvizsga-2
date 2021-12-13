package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public void addWord(String word) {
        checkValidity(word);
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (words.lastIndexOf(word) > i) {
                return true;
            }
        }
        return false;
    }

    private void checkValidity(String word) {
        for (char ch: word.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                throw new IllegalArgumentException("It should be one word!");
            }
            if (!Character.isLowerCase(ch)) {
                throw new IllegalArgumentException("Word should be lower case!");
            }
        }
    }

    public List<String> getWords() {
        return words;
    }
}
