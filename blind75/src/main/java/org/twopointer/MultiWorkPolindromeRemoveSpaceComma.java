package org.twopointer;

public class MultiWorkPolindromeRemoveSpaceComma {

    public static void main(String[] args) {
        polindromeRemoveSpaceComma("A man, a plan, a canal, a Panama");
    }


    public static boolean polindromeRemoveSpaceComma(String text){
        text = text.toLowerCase();
        int start=0;
        int end=text.length()-1;
        while (start < end) {
            while(start<end && !Character.isLetterOrDigit(text.charAt(start))) {
                start++;
            }
            while(start<end && !Character.isLetterOrDigit(text.charAt(end))) {
                end--;
            }
            if(text.charAt(start)==text.charAt(end)) {
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
