package ds.twopointer;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortedSquare {
    public static void main(String[] args) {

        Integer[] array=new Integer[]{-4,0,1,2,3,5};

       Integer[] result=sortedSquare(array);
       System.out.println(Arrays.toString(result));

    }

    private static Integer[] sortedSquare(Integer[] array) {

        Integer[] res=new Integer[array.length];
        List<Integer> list=new ArrayList<>();

        int start=0;
        int end=array.length-1;
        for(int i=end;i>0;i--){

            if(Math.abs(array[start])>Math.abs(array[end])){
                int value=array[start];
                res[i]= Math.abs(value*value);
                start++;
            }else{
                int value=array[end];
                res[i]= Math.abs(value*value);
                end--;
            }


        }


        return res;
    }

}
