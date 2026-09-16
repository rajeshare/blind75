package org.paskalTriangle;

import java.util.ArrayList;
import java.util.List;

public class PaskalTriangle {
    public static void main(String[] args) {
        System.out.println(paskaltriangle(7));
    }
    private static List<List<Integer>> paskaltriangle(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<List<Integer>> result = new ArrayList<>();
        result.add(list);
        if (n == 1) {
            return result;
        }
        for (int i = 1; i < n; i++) {
            List<Integer> prev = result.get(i-1);
            List<Integer> newlist = new ArrayList<>();
            newlist.add(1);
            for(int j = 0; j < i-1; j++){
                newlist.add(prev.get(j)+prev.get(j+1));
            }
            newlist.add(1);
            result.add(newlist);
        }
        return result;
    }
}
