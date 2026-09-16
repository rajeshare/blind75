package org.monotonicstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GreaterNextElement {
    public static void main(String[] args) {
        Integer[] array = {3,1,5,2,1,0,7,9,2,3};
        Integer[] result=nextGreaterElement(array);

    }
    public static Integer[] nextGreaterElement(Integer[] array)
    {
        Stack<Integer> stack = new Stack<>();
        Integer[] result = new Integer[array.length];
       Integer n= array.length-1;
        result[n]=-1;
        stack.push(array[n]);

        for (int i = array.length-2; i >=0; i--) {

            while(!stack.isEmpty()&&stack.peek()<array[i]){
                stack.pop();
            }
// Stack top is the next greater element
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(array[i]);
        }
        return result;

    }
}
