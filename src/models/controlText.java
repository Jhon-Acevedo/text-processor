package models;

import java.util.*;
import java.util.stream.Collectors;

public class controlText {

    private final HashMap<String, Integer> mapTopWords;

    public controlText() {
        mapTopWords = new HashMap<>();
    }

    public int countWords(String text) {
        StringTokenizer stringTokenizer = new StringTokenizer(text);
        return stringTokenizer.countTokens();
    }

    public int countLetter(String text) {
        return text.length();
    }

    public int getLines(String text) {
        if (text.equals("")) {
            return 0;
        } else {
            return text.split("\n").length;
        }
    }

    public int getTopWords(String wordToSearch, String[] listWords) {
        int count = 0;
        for (String word : listWords) {
            if (wordToSearch.equals(word)) {
                count++;
            }
        }
        return count;
    }

    public HashMap<String, Integer> manageGetTopWords(String text) {
        int countWords = 0;
        mapTopWords.clear();
        String[] listWords = text.split("[ \n]");

            for (String word : listWords) {
                if (!word.equals("") && !word.equals("\t")) {
                    countWords = getTopWords(word, listWords);
                    mapTopWords.put(word, countWords);
                }
            }
        return mapTopWords;
    }

    public HashMap<String, Integer> orderMapWords(String text) {
        HashMap<String, Integer> mapAux = manageGetTopWords(text);
        return mapAux.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public Object[][] showMatrixTable(String text){
        HashMap<String, Integer> mapData = orderMapWords(text);
        Integer[] values = mapData.values().toArray(new Integer[0]);
        String[] keys = mapData.keySet().toArray(new String[0]);
        Object[][] matrix = new Object[values.length][];
        for (int i = 0; i < values.length; i++) {
            if (i < 10){
                matrix[i] = new Object[]{i+1,keys[i],values[i]};
            }
        }
        return matrix;
    }
}
