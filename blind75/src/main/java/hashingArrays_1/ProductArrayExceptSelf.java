package hashingArrays_1;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};;
        int[] res =productArrayExceptSelf(nums);
    }

    /*  1 2 3 4
        leftArray =  1 1 2 6
        rightArray = 24 12 4 1
        produc       24 12 8 6
     */

    private static int[] productArrayExceptSelf(int[] nums) {

        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];
        int[] res = new int[nums.length];
        leftProd[0] = 1;
        int leftprod = 1;
        for (int i = 1; i < nums.length; i++) {
            leftprod *= nums[i-1];
            leftProd[i] = leftprod ;
        }
        rightProd[nums.length-1] = 1;
        int rightprod = 1;
        for (int i = nums.length-2; i >=0; i--) {
            rightprod *= nums[i+1];
            rightProd[i] = rightprod ;
        }

        for (int i=0;i<nums.length;i++){
            res[i]=leftProd[i]*rightProd[i];
        }


        return res;

    }


}
