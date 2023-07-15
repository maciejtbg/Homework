package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElevationMapTest {

    @Test
    public void shouldReturn1() {

        List<Integer> inputMap = new ArrayList<>(Arrays.asList(2, 1, 2));
        int waterLevel = 2;
        int expectedWater = 1;

        int actualWater = ElevationMap.GetNumberOfWater(inputMap, waterLevel);

        Assertions.assertEquals(expectedWater, actualWater);
    }

    @Test
    public void shouldReturn2() {

        List<Integer> inputMap = new ArrayList<>(Arrays.asList(2, 1, 1, 2));
        int waterLevel = 2;
        int expectedWater = 2;

        int actualWater = ElevationMap.GetNumberOfWater(inputMap, waterLevel);

        Assertions.assertEquals(expectedWater, actualWater);
    }

    @Test
    public void shouldReturn5() {

        List<Integer> inputMap = new ArrayList<>(Arrays.asList(3, 1, 0, 3));
        int waterLevel = 3;
        int expectedWater = 5;

        int actualWater = ElevationMap.GetNumberOfWater(inputMap, waterLevel);

        Assertions.assertEquals(expectedWater, actualWater);
    }

    @Test
    public void shouldReturn0() {

        List<Integer> inputMap = new ArrayList<>(Arrays.asList(3, 2, 1, 1));
        int waterLevel = 2;
        int expectedWater = 0;

        int actualWater = ElevationMap.GetNumberOfWater(inputMap, waterLevel);

        Assertions.assertEquals(expectedWater, actualWater);
    }

    @Test
    public void shouldReturn3() {

        List<Integer> inputMap = new ArrayList<>(Arrays.asList(2, 1, 0, 3));
        int waterLevel = 2;
        int expectedWater = 3;

        int actualWater = ElevationMap.GetNumberOfWater(inputMap, waterLevel);

        Assertions.assertEquals(expectedWater, actualWater);
    }
}