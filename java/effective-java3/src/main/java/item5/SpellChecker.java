package item5;

import java.util.Arrays;
import java.util.List;

public class SpellChecker {

    private final Lexicon dictionary;

    // 자원을 직접 명시하지 말고, 의존 객체 주입을 사용하기.
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String word) {
        return true;
    }

    public List<String> suggestions(String type) {
        return Arrays.asList("");
    }
}
