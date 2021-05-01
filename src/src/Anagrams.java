package src;

import java.util.*;
/**
 * An Anagrams object can store a set of words and print the complete
 * set of anagrams that can be made out of the set of words from a
 * given String.
 *
 * @Author Brandon Said
 * @Section EGR227A SP21
 * @Date April 28, 2021
 */

public class Anagrams {
    //Implement this class
    List<String> dictionary;
    Map<String, LetterInventory> inventories;

    /**
     * Constructs an Anagrams object with a list of words
     * as it's dictionary to create anagrams from.
     *
     * @param dictionary to be used as a dictionary for anagrams
     */
    public Anagrams(List<String> dictionary) {
        // Initialize this.dictionary and inventories
        this.dictionary = dictionary;
        this.inventories = new HashMap<>();

        // Want to create HashMap to store List<String> dictionary data
        for (String n : dictionary) {
            this.inventories.put(n, new LetterInventory(n));
        }
    }


    public void print(String text, int max) {
        //Check for Illegal Argument (max < 0)
        if (max < 0) {
            throw new IllegalArgumentException("max is less than 0\nmax: " + max);
        }

        // Get LetterInventory for String
        LetterInventory textInventory = new LetterInventory(text);


        //Prune dictionary based on text
        List<String> prunedDict = new LinkedList<>();
        Collections.copy(prunedDict, dictionary);

        // use private helper to add to List

        // while ((i < max || max == 0) and not out of words)

        //print list
    }

    //returns a pruned dictionary based on how many words are available
    private List<String> pruneDictionary(List<String> dictionary,
                                         LetterInventory textInventory) {
        List<String> newDict = new LinkedList<>();
        for (String word : dictionary) {
            if ()
        }
    }

}
