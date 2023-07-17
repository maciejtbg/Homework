package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    @Test
    public void shouldReturnFalse(){
        String str1 = "gdag";
        String str2 = "gadeg";
        String str3 = "gadtag";
        String str4 = "godotegodoti";
        String str5 = "gotoegodote";
        String str6 = "abcdefgedcba";
        String str7 = "asdasdasdasdasdfsadsadsadsadas";
        String str8 = "sdfsdfsdfsdfsdfsdfsdffdsfdsfdssfdssdffdsd";
        boolean expected = false;
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str1));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str2));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str3));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str4));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str5));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str6));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str7));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str8));
    }
    @Test
    public void shouldReturnTrue(){
        String str1 = "gaag";
        String str2 = "gadag";
        String str3 = "gaddag";
        String str4 = "godotetodog";
        String str5 = "gotoegodote";
        String str6 = "abcdefgedcba";
        String str7 = "asdasdasdasdasdfsadsadsadsadas";
        String str8 = "sdfsdfsdfsdfsdfsdfsdffdsfdsfdssfdssdffdsd";
        boolean expected = false;
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str1));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str2));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str3));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str4));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str5));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str6));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str7));
        Assertions.assertEquals(expected,Palindrome.CheckIfPalindrome(str8));
    }

}