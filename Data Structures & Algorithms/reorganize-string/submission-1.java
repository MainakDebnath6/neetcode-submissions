class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> mh =
            new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                mh.offer(new int[]{freq[i], i});
            }
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;

        while (!mh.isEmpty() || prev != null) {

            if (prev != null && mh.isEmpty()) {
                return "";
            }

            int[] curr = mh.poll();

            res.append((char) (curr[1] + 'a'));

            curr[0]--;

            if (prev != null) {
                mh.offer(prev);
                prev = null;
            }

            if (curr[0] > 0) {
                prev = curr;
            }
        }

        return res.toString();
    }
}