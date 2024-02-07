package homework12;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortElementsTest extends BaseTest {
    @Test
    public void sortElements() {
        List<Integer> list = Arrays.asList(-79, 99, -83, -75, -78, -22, -57, 84, 11, 15);
        List<Integer> sorted_list = new ArrayList<Integer>();
        for (Integer element : list) {
            sorted_list.add(Math.abs(element));
        }
        Collections.sort(sorted_list);
        System.out.println(sorted_list);
    }
}
