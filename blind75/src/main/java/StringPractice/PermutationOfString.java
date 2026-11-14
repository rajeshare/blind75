package StringPractice;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

    public static void main(String[] args) {

        String str = "abc";
        List<String> output = new ArrayList<>();

        perm(str,"",output,str.length());
        System.out.println(output);
    }

    public static void perm(String str, String path, List<String> output,int length) {
        if (path.length() == length) {
            output.add(path);
            return;
        }
        //abc
        for (int i = 0; i < str.length(); i++) {
            char   ch=str.charAt(i);
            String tmp=str.substring(0,i)+str.substring(i+1);
            perm(tmp,path+ch,output,length);
        }

    }




}
