package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {

    private String word;
    private List<String> translations = new ArrayList<>();

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        this.translations = translations;
    }

    public void addTranslations(List<String> bevitel) {
        for (String elem : bevitel) {
            if (!translations.contains(elem)) {
                translations.add(elem);
            }

        }
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }
}
