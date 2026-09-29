package hashingArrays_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Duplicate {

    public static void main(String[] args) {
        int[] array={2,7,11,15,2};
        containsDuplicate(array);
        System.out.println(containsDuplicate(array));
    }
    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
       boolean match= Arrays.stream(nums).boxed().anyMatch(x->!set.add(x));
        return match;


    }
}
