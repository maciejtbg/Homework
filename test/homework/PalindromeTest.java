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

}