class Solution {
    public int maxFrequencyElements(int[] nums) {

        int[] freq = new int[101];

        // 1. Frequency count
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        // 2. Maximum frequency find karo
        int maxFreq = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
            }
        }

        // 3. Maximum frequency wale elements add karo
        int answer = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq) {
                answer += freq[i];
            }
        }

        return answer;
    }
}