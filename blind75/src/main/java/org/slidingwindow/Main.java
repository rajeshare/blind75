package org.slidingwindow;

import java.util.stream.IntStream;

class ContigousSubArrayAvgKelements {
    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5, 6,7,5,4,3};
        int k=4;
        Integer maxSum=0;
        Integer curSum=0;

        for (int i = 0; i <k; i++) {
            curSum+=array[i];
        }
        maxSum=curSum;

        for(int j=k;j<array.length;j++){
            curSum=curSum-array[j-k]+array[j];
           if(maxSum<curSum){
               maxSum=curSum;
           }
        }
        double average=maxSum/k;
        System.out.println(average);
    }
}