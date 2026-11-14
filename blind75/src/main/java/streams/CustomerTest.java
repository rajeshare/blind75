package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
//  A customer can have many orders, so sum their  amounts.
 - Cities must be in alphabetical order.
 - If two orders spent the same amount, sort them by name ascending
 */
public class CustomerTest {
    public static void main(String[] args) {
        List<Order> order=new ArrayList<>();
        Order o1=new Order(1,100,1);
        Order o2=new Order(2,200,1);
        Order o3=new Order(3,300,1);
        Order o4=new Order(4,400,2);
        Order o5=new Order(5,500,2);
        order.add(o1);
        order.add(o2);
        order.add(o3);
        order.add(o4);
        order.add(o5);


        Map<Integer, List<Order>> orders =
                order.stream()
                        .collect(Collectors.groupingBy(Order::getCustomerId));
        System.out.println(orders);

       // Seperate Even and Odd
       List<Integer> nums=List.of(1,2,2,3,4,5);

        Map<Boolean, List<Integer>> collect = nums.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(collect);
        List<Integer> collect1 = nums.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);
        String s= "ANAGRAM";
        Map<Character, Long> collect2 = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), TreeMap::new,Collectors.counting()));
        System.out.println(collect2);

        Map<Integer, Long> collect3 = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect3);
        nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::print);
        String[] strs={"A","B","C","D","E"};
        String collect4 = Arrays.stream(strs).collect(Collectors.joining(":", "\"", "\""));
        System.out.println(collect4);
        nums.stream().filter(i -> i % 2 == 0).forEach(System.out::print);
        Integer i = nums.stream().min(Comparator.naturalOrder()).get();
        Integer i1 = nums.stream().max(Comparator.naturalOrder()).get();
        System.out.println(i+" : "+i1);
        IntStream.concat(IntStream.of(1, 2, 3), IntStream.of(4, 5, 6)).sorted().forEach(System.out::print);

        String s1="ANAGRAM",s2="NAGARAM";
        String s1resul=s1.chars().mapToObj(ch -> (char) ch).map(c1->""+Character.toUpperCase(c1)).sorted().collect(Collectors.joining());
        String s2resul=s2.chars().mapToObj(ch -> (char) ch).map(c1->""+Character.toUpperCase(c1)).sorted().collect(Collectors.joining());

        if(s1resul.equals(s2resul)){
            System.out.println("ANAGRAM");
        }

        // MERGE UnSORTED ARRYA

        Optional<Integer> reduce = nums.stream().reduce((k1, k2) -> k1 + k2);
        reduce.ifPresent(System.out::print);

        Integer number=12345;

        Integer collect5 = Stream.of(String.valueOf(number).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(collect5);
    }
}
