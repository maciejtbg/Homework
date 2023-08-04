package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxSubArrayTest {

    @Test
    public void ShouldReturn30 () throws Exception {
        int[] inputArray = {2,3,4,5,6,7,8};
        int k = 3;
        int expected = 4+5+6+7+8;
        Assertions.assertEquals(expected, MaxSubArray.CountMaxValueFromSubArrays(inputArray,k));
    }

    @Test
    public void ShouldReturn10() throws Exception {
        int [] inputArray = {1,2,3,4};
        int k = 1;
        int expected = 10;
        Assertions.assertEquals(expected,MaxSubArray.CountMaxValueFromSubArrays(inputArray,k));
    }

    @Test
    public void ShouldReturnException(){
        int [] inputArray = {1,2,3};
        int [] k = {-1,0,4};
        for (int valueOfK : k) {
            Assertions.assertThrows(Exception.class, () -> MaxSubArray.CountMaxValueFromSubArrays(inputArray, valueOfK));
        }
    }


}