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


    /**
     * Prints out all possible anagrams of a word/phrase using at most a certain
     * number of words
     * @param text word/phrase to make anagrams out of
     * @param max number of words allowed to make anagrams out of
     */
    public void print(String text, int max) {
        //Check for Illegal Argument (max < 0)
        if (max < 0) {
            throw new IllegalArgumentException("max is less than 0\nmax: " + max);
        }

        // Get LetterInventory for String
        LetterInventory textInventory = new LetterInventory(text);


        //Prune dictionary based on text
        List<String> prunedDict = pruneDictionary(dictionary, textInventory);

        // use private helper to add to List
        //printing lists every time a list is complete
        List<String> listToPrint = makeList(textInventory, prunedDict);


        //print list
        System.out.print(listToPrint);
    }

    private List<String> makeList(LetterInventory textInventory, List<String> dict){


        return new ArrayList<String>();
    }



    //returns a pruned dictionary based on how many words are available
    private List<String> pruneDictionary(List<String> dictionary,
                                         LetterInventory textInventory) {
        List<String> newDict = new LinkedList<>();
        for (String word : dictionary) {
            LetterInventory testInventory = textInventory.subtract(inventories.get(word));
            if (testInventory != null && testInventory.isEmpty()) {
                newDict.add(word);
            }
        }

        return newDict;
    }

}
