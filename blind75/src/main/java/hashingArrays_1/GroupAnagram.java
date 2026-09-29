package hashingArrays_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] str= {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list=new ArrayList<>();
        System.out.println(groupAnagram(str));


    }
    public static List<List<String>> groupAnagram(String[] str){

        Map<String, List<String>> map = new HashMap<>();
        for(String s:str){
            int[] arr=new int[26];
            for(char c:s.toCharArray()){
                arr[c-'a']++;
            }
            StringBuilder builder=new StringBuilder();
            for(int i=0;i<arr.length;i++){
                builder.append("#"+arr[i]);
            }

            if(!map.containsKey(builder.toString())){
                ArrayList<String> list=new ArrayList<>();
                list.add(s);
                map.put(builder.toString(),list);
            }else {
                map.get(builder.toString()).add(s);
            }


        }

        return new ArrayList<>(map.values());
    }
}
