class Solution {

    private int[][] dp;

    public int lastStoneWeightII(int[] stones) {

        int sum = Arrays.stream(stones).sum();

        int target = sum / 2;

        dp = new int[stones.length + 1][target + 1];

        for (int i = 1; i <= stones.length; i++) {

            int stone = stones[i - 1];

            for (int j = 0; j <= target; j++) {

                // Don't take the stone
                dp[i][j] = dp[i - 1][j];

                // Take the stone
                if (stone <= j) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        stone + dp[i - 1][j - stone]
                    );
                }
            }
        }

        int best = dp[stones.length][target];

        return sum - 2 * best;
    }
}