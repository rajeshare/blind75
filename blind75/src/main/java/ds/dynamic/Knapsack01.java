package ds.dynamic;

public class Knapsack01 {

    public static int knapsack(
            int[] weights, int[] values, int capacity) {

        // Step 1: Create a DP array
        int[] dp = new int[capacity + 1];

        // Step 2: Process each item
        for (int i = 0; i < weights.length; i++) {

            // Step 3: Check capacities in reverse order
            for (int w = capacity; w >= weights[i]; w--) {

                // Option 1: Do not select the item
                int exclude = dp[w];

                // Option 2: Select the item
                int include = values[i]
                        + dp[w - weights[i]];

                // Step 4: Save the better result
                dp[w] = Math.max(include, exclude);
            }
        }

        // Step 5: Return the maximum value
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 5;

        int result = knapsack(weights, values, capacity);

        System.out.println("Maximum value: " + result);
    }
}
