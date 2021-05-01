package src;

public class MyOwnTest {
    public static void main(String[] args) {
        String aSpace = " ";
        char charSpace = ' ';
        System.out.println("This is the char. Is it a letter? " + Character.isLetter(charSpace));
        System.out.println("This is the String. Is it a letter? " + Character.isLetter(aSpace.charAt(0)));

        String notASpace = "a";
        char notCharSpace = 'z';
        System.out.println("This is the letter a. Is it a letter? " + Character.isLetter(notASpace.charAt(0)));
        System.out.println("This is the letter a. Is it a letter? " + Character.isLetter(notCharSpace));
    }
}
