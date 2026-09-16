package org.twopointer;

class Polindrome {
    public static void main(String[] args) {


        System.out.println(polindrome("RADAR"));


    }
    public static boolean polindrome(String text){
        int start=0;
        int end=text.length()-1;

        while (start<end){
            if(text.charAt(start)==text.charAt(end)) {
                start++;
                end--;
            }else  {
                return false;
            }
        }
        return true;
    }
}