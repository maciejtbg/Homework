package homework;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubstringTest {

    @Test
    public void ShouldReturnBcb(){
        String inputString = "abcba";
        int k = 2;
        String expected = "bcb";
        Assertions.assertEquals(expected,LongestSubstring.FindLongestSubstring(inputString,k));
    }

    @Test
    public void ShouldReturnGhghg(){
        String inputString = "abbacbabacghghgabd";
        int k = 2;
        String expected = "ghghg";
        Assertions.assertEquals(expected,LongestSubstring.FindLongestSubstring(inputString,k));
    }

}