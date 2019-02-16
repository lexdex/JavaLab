package util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;				
import org.junit.Test;		

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class ArrayUtilsTest {

    @Test
    public void  arrayCheckFor0(){
    boolean checked=Assert.assertArrayEqual(0,0);
    assume True(checked);
    }


    @Test
    public void arrayContainsValueTest() {
        boolean contains = ArrayUtils.contains(new int[]{1, 2, 3}, 2);

        assumeTrue(contains);
    }

    @Test
    public void addValueToArrayTest() {
        int[] ints = ArrayUtils.addToArray(new int[]{1, 2, 3}, 4);
        List<Integer> array_to_test  = Arrays.stream(ints).boxed().collect( Collectors.toList() );
        assertThat(array_to_test, contains(1,2,3,4));
    }

}