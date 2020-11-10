package controliteration.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {
    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String word, List<String> translate) {
        boolean talalat = false;
        for (DictionaryItem item : dictionaryItems) {
            if (item.getWord().equals(word)) {
                item.addTranslations(translate);
                talalat=true;
            }
        }
        if (!talalat){
            dictionaryItems.add(new DictionaryItem(word,translate));
        }
    }

    public List<String> findTranslations(String word) {
        for (DictionaryItem item : dictionaryItems) {
            if (item.getWord().equals(word)) {
                return item.getTranslations();
            }
        }
        return new ArrayList<>();
    }


    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("test",Arrays.asList("tes","ted","sad"));
        System.out.println(dictionary.findTranslations("test"));
        dictionary.addItem("agsjhd",Arrays.asList("ads","ads","adsf"));
        System.out.println(dictionary.findTranslations("agsjhd"));
        System.out.println(dictionary.findTranslations("asda"));
        dictionary.addItem("test",Arrays.asList("asd"));
        System.out.println(dictionary.findTranslations("test"));

    }
}
