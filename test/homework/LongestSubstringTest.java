package homework;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

class LongestSubstringTest {

    @Test
    public void ShouldReturnBcb(){
        String inputString = "abcba";
        int k = 2;
        String expected = "bcb";
        Assertions.assertEquals(expected,LongestSubstring.FindLongestSubstring(inputString,k));
    }

}