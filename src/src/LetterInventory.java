package src;

/**
 * The LetterInventory class creates an object that
 * keeps track of the frequency of the letters of the alphabet.
 * LetterInventory objects keep track of how often each letter shows
 * given text. Clients are able to manipulate and return the frequency
 * and percentage of different letters of the alphabet.
 *
 * @Author Brandon Said
 * @Section EGR227A SP21
 * @Date April 23, 2021
 */
public class LetterInventory {
    private static final int NUM_LETTERS = 26;
    private int[] charCount;
    private int size;
    private boolean isEmpty;

    //DONE

    /**
     * Constructs an inventory with 0-counts for all letters.
     */
    public LetterInventory() {
        this("");
    }

    //DONE

    /**
     * Constructs an inventory with values based on the passed String
     *
     * @param data frequency of letters in this String are added
     *             to the counts in the inventory
     */
    public LetterInventory(String data) {
        // Initialize simple state first
        this.charCount = new int[NUM_LETTERS];
        this.isEmpty = true;
        this.size = 0;

        // Modify the values due to the String
        for (int i = 0; i < data.length(); i++) {
            // Only enter loop if char at String is a letter
            Character aChar = data.charAt(i); // Not necessary, but cleaner
            if (Character.isLetter(aChar)) {
                // increment letter count in charCount
                this.charCount[getIndex(aChar)]++;
                // set isEmpty to false
                this.isEmpty = false;
                // increment size
                this.size++;
            }
            //else go to next character
        }
    }


    /**
     * Returns the number of times the letter is found in the inventory.
     * Pre: Letter passed should only be a letter. Otherwise a
     * an IllegalArgumentException is thrown.
     *
     * @param letter letter of the alphabet
     * @return frequency
     */
    public int get(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("letter is not a letter." +
                    "\nletter: " + letter);
        }
        return charCount[getIndex(letter)];
    }

    /**
     * Manually changes the inventory's frequency for a given letter.
     * Post: charCount[] should have the the index of the letter updated with
     * the new value. Additionally, the size and isEmpty should be updated.
     *
     * @param letter a letter, otherwise IllegalArgumentException is thrown
     * @param value  a non-negative integer, otherwise IllegalArgumentException
     *               is thrown
     */
    public void set(char letter, int value) {
        // Check for Exceptions
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("letter parameter is not a " +
                    "letter.\nletter: " + letter);
        } else if (value < 0) {
            throw new IllegalArgumentException("value is negative." +
                    "\nvalue: " + value);
        }

        // Adjust size for new value
        int sizeDelta = value - charCount[getIndex(letter)];
        this.size += sizeDelta;

        // Adjust isEmpty value if needed
        this.isEmpty = (size == 0);

        // Set Value
        charCount[getIndex(letter)] = value;
    }

    /**
     * Checks inventory total count.
     *
     * @return sum of inventory counts
     */
    public int size() {
        return size;
    }

    /**
     * Checks if inventory is empty
     *
     * @return true if inventory has no values > 0
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    /**
     * Yields a representation of the inventory as a String of letters
     * between brackets. The frequency of a letter is indicated by how often
     * it appears in the String.
     *
     * @return a String in the form of "[abcd...]"
     */
    public String toString() {
        String thisString = "[";
        for (int i = 0; i < NUM_LETTERS; i++) {
            for (int j = 0; j < charCount[i]; j++) {
                thisString += ((char) ('a' + i)); //MIGHT WANT TO MAKE THIS A METHOD
            }
        }
        thisString += "]";
        return thisString;
    }


    /**
     * Generates a LetterInventory object that combines the
     * inventories of the two LetterInventory objects
     * Post: Both LetterInventory objects are unchanged.
     *
     * @param other another LetterInventory object to be added
     *              to the original one
     * @return a LetterInventory object that has combined
     * sums of the two
     */
    public LetterInventory add(LetterInventory other) {
        LetterInventory third = new LetterInventory();
        for (int i = 0; i < NUM_LETTERS; i++) {
            third.set(indexToChar(i), this.charCount[i] + other.charCount[i]);
        }
        return third;
    }

    /**
     * Generates a LetterInventory object that has an inventory taken from
     * the difference of another LetterInventory object inventory
     * Post: this LetterInventory and other LetterInventory are
     * unmodified
     *
     * @param other a second LetterInventory class
     * @return a LetterInventory with inventory that is the difference of
     * other from this
     */
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory third = new LetterInventory();
        for (int i = 0; i < NUM_LETTERS; i++) {
            int value = this.charCount[i] - other.charCount[i];
            if (value < 0) {
                return null;
            } else {
                char letter = indexToChar(i);
                third.set(letter, value);
            }
        }
        return third;
    }

    /**
     * Gives the ratio of frequency of a letter to sum of all letter frequencies
     *
     * @param letter a letter of the alphabet as a char
     * @return value from 0.0 to 1.0 representing ratio of times letter is in
     * inventory compared to other letters
     */
    public double getLetterPercentage(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("\nChar passed to getLetterPercentage" +
                    "was not a letter.\nChar passed: " + letter);
        }
        int index = getIndex(letter);
        return ((double) charCount[index]) / size;
    }

    /**
     * Figures out the index of the char in the array
     * Pre: char is a letter, else IllegalArgumentException thrown
     *
     * @param aChar a char character
     * @return the index the char corresponds to in the inventory (charCount[])
     */
    private int getIndex(char aChar) {
        // I preferred to not instantiate a new Character object each time I used this class
        return Character.toLowerCase(aChar) - 'a';
    }


    /**
     * Takes index and figures out its char
     *
     * @param index value form 0 to 25
     * @return char the char value associated with the index
     */
    private char indexToChar(int index) {
        return (char) ('a' + index);
    }

}


