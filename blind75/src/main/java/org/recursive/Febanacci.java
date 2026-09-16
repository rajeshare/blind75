package org.recursive;

public class Febanacci {
    public static void main(String[] args) {
        //0,1,1,2,3,5,8,13,21,34,55
       // System.out.println(febnacci(10));
        System.out.println(febnacci2(10));

    }

   public static int febnacci(int n)
    {
        if(n<=1){
            return n;
        }
        return febnacci(n-1)+febnacci(n-2);
    }
    public static int febnacci2(int n)
    {
        if(n<=1){
            return n;
        }
        int[] mem=new int[n+1];
        mem[0]=1;
        mem[1]=1;

        for (int i = 2; i <=n ; i++) {
            mem[i]=mem[i-1]+mem[i-2];
        }
        return mem[n];


    }
}
