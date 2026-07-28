class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] last = new int[32];

        Arrays.fill(last, -1);

        for (int i = n - 1; i >= 0; i--) {

            // Update last occurrence of set bits
            for (int b = 0; b < 32; b++) {
                if (((nums[i] >> b) & 1) == 1) {
                    last[b] = i;
                }
            }

            int farthest = i;

            // Find farthest required index
            for (int b = 0; b < 32; b++) {
                if (last[b] != -1) {
                    farthest = Math.max(farthest, last[b]);
                }
            }

            ans[i] = farthest - i + 1;
        }

        return ans;
    }
}