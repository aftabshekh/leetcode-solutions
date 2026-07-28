class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];

        // Calculate edge score of every node
        for (int i = 0; i < n; i++) {
            score[edges[i]] += i;
        }

        long maxScore = -1;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                ans = i;
            }
        }

        return ans;
    }
}