class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int maxSum = 0;
        int end = 0;
        int[] res = new int[2];
        int interval = n;

        for (int start = 0; start < n; start++) {
            while (maxSum < k && end < n) {
                maxSum += sequence[end];
                end++;
            }
            if (maxSum == k && end - 1 - start < interval) {
                res[0] = start;
                res[1] = end - 1;
                interval = end - 1 - start;
            }
            maxSum -= sequence[start];
        }

        return res;
    }
}