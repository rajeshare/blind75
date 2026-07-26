
package com.rajesh.hard;

import java.util.*;

/*
The Skyline Problem
 buildings[i] = [lefti, righti, heighti]:

Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
Explanation:
Figure A shows the buildings of the input.
Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.

https://leetcode.com/problems/the-skyline-problem/description/

 */

public class Skyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events=new ArrayList<>();
        for(int[] building:buildings){

            events.add(new int[]{building[0],building[2],1});

            events.add(new int[]{building[1],building[2],0});
        }
        events.sort((a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> activeHeights=new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> skyline=new ArrayList<>();
        int previousMax=0;

        for(int[] event:events){
            int x=event[0], h=event[1];
            boolean isStart= event[2]==1;
            if(isStart){
                activeHeights.offer(h);

            }else{
                activeHeights.remove(h);
            }
            int curmax= activeHeights.isEmpty()?0:activeHeights.peek();

            if(curmax != previousMax){
                skyline.add(Arrays.asList(x,curmax));
                previousMax=curmax;
            }
        }
        return skyline;
    }

    public static void main(String[] args) {
        Skyline skyline=new Skyline();
        int[][] buildings=new int[][]{{0,2,3},{2,5,3}};
        List<List<Integer>> skyline1=skyline.getSkyline(buildings);
        System.out.println(skyline1);
    }


}
