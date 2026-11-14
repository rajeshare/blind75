package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsClass {


    public static void main(String[] args) {
        List<Integer> list=(List.of(1,2,3,6,4,5,6,6));
        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(collect);

        List<Integer> collect1 = list.stream().distinct().collect(Collectors.toList());
        //Frequency char in string
        String str= "RAJESH";
        Map<Character, Long> collect2 = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect2);
        //Sort the list sort order asc
      List<Integer> asc= list.stream().sorted().collect(Collectors.toList());
        List<Integer> dsc= list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(dsc);

     //   String collect3 = list.stream().collect(Collectors);

        int[] arr={1,2,3,4,5,6};
        IntStream.range(0,arr.length).map(i -> arr[arr.length-i-1]).forEach(System.out::println);
        int sum=IntStream.range(0,11).sum();
        System.out.println(sum);
        IntStream.range(0,11).forEach(System.out::println);
    }
}
