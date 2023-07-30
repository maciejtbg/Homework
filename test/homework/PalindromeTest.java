package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    @Test
    public void shouldReturnElgoogle(){
        String inputString = "google";
        String expected = "elgoogle";
        Assertions.assertEquals(expected,Palindrome.FindShortestPalindrome(inputString));
    }

    @Test
    public void shouldReturnJakaj(){
        String inputString = "jaka";
        String expected = "jakaj";
        Assertions.assertEquals(expected,Palindrome.FindShortestPalindrome(inputString));
    }

    @Test
    public void shouldReturnIkajaki(){
        String inputString = "kajaki";
        String expected = "ikajaki";
        Assertions.assertEquals(expected,Palindrome.FindShortestPalindrome(inputString));
    }

    @Test
    public void shouldReturnEcarace(){
        String inputString = "race";
        String expected = "ecarace";
        Assertions.assertEquals(expected,Palindrome.FindShortestPalindrome(inputString));
    }


    @Test
    public void shouldReturnAtemokometa(){
        String inputString = "kometa";
        String expected = "atemokometa";
        Assertions.assertEquals(expected,Palindrome.FindShortestPalindrome(inputString));
    }


    @Test
    public void shouldReturnUlu(){
        String inputString = "ul";
        String expected = "lul";
        Assertions.assertEquals(expected,Palindrome.FindShortestPalindrome(inputString));
    }

}