package models;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Control text.
 */
public class controlText {

    private final HashMap<String, Integer> mapTopWords;

    /**
     * Instantiates a new Control text.
     * Constructor
     */
    public controlText() {
        mapTopWords = new HashMap<>();
    }

    /**
     * This method counts the total words of the text
     *
     * @param text the text
     * @return the int
     */
    public int countWords(String text) {
        StringTokenizer stringTokenizer = new StringTokenizer(text);
        return stringTokenizer.countTokens();
    }

    /**
     * This method counts the total letters of the text
     *
     * @param text the text
     * @return the int
     */
    public int countLetter(String text) {
        return text.length();
    }

    /**
     * This method obtains the total lines of the text
     *
     * @param text the text
     * @return the lines
     */
    public int getLines(String text) {
        if (text.equals("")) {
            return 0;
        } else {
            return text.split("\n").length;
        }
    }

    /**
     * This method counts the repeated words of the text
     *
     * @param wordToSearch the word to search
     * @param listWords    the list words
     * @return the top words
     */
    public int getTopWords(String wordToSearch, String[] listWords) {
        int count = 0;
        for (String word : listWords) {
            if (wordToSearch.equals(word)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Manage get top words hash map.
     *
     * @param text the text
     * @return the hash map
     */
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

    /**
     * This method Order map words hash map.
     *
     * @param text the text
     * @return the hash map
     */
    public HashMap<String, Integer> orderMapWords(String text) {
        HashMap<String, Integer> mapAux = manageGetTopWords(text);
        return mapAux.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    /**
     * This method returns an array of the words in the text to send to the controller.
     *
     * @param text the text
     * @return the object [ ] [ ]
     */
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
