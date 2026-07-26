package com.rajesh.hard;

/*
https://leetcode.com/problems/candy/description/

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.


Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.


 */


import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        int n = ratings.length;
        Arrays.fill(res, 1);
        //Fill left side candry

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        //fill right side candy

        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += res[i];
        }


        return sum;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = new int[]{1, 2, 2};
        System.out.println(candy.candy(ratings));
        System.out.println(candy.candy(new int[]{1, 0, 2}));
    }
}
