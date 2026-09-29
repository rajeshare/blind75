package hashingArrays_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class ValidAnagram {

    public static void main(String[] args) {
            String src="anagram";
            String target="nagaram";

        System.out.println(isAnagram1(src,target));
    }

    public static boolean isAnagram(String s, String t) {

        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();

        HashMap<Character,Integer> map=new HashMap<>();

        for(Character c:sArr){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Character c:tArr){
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }
        }
        Collection<Integer> values = map.values();
        for(Integer value:values){
            if(value!=0){
                return false;
            }
        }
        return  true;
    }
    public static boolean isAnagram1(String s, String t) {

        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();
        int[] arr=new int[26];

        for(int i=0;i<sArr.length;i++){
            arr[sArr[i]-'a']++;
            arr[tArr[i]-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }


}
