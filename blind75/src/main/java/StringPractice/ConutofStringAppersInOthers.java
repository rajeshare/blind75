package StringPractice;

public class ConutofStringAppersInOthers {

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abcdabcabc";

        int count = 0;

        int s1Length = s1.length();
        int s2Length = s2.length();
        for (int i = 0; i <= s2Length-s1Length; i++) {
            if(s2.substring(i,s1Length+i).equals(s1)){
                count++;
            }
        }
        System.out.println(count);
    }

}
