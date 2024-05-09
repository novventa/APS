import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
int answer = 0;
        int cnt = 0;

        Arrays.sort(score);
        reverseArray(score);

        for (int i = 0; i < score.length; i++) {
            if (score[i] > k)
                cnt++;
            else
                break;
        }

        int length = score.length / m;

        for (int i = 0; i < length; i++) {
            answer += score[m - 1 + m * i] * m;
        }

        return answer;
    }

    private void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}