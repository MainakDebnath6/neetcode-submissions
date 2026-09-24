class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] t : times) {
            adj.computeIfAbsent(t[0], key -> new ArrayList<>()).add(new int[] {t[1], t[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<Integer> visited = new HashSet<>();
        pq.offer(new int[] {0, k});
        int t = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int w1 = p[0];
            int n1 = p[1];
            if (visited.contains(n1))
                continue;
            t = w1;
            visited.add(n1);
            if (adj.containsKey(n1)) {
                for (int[] nei : adj.get(n1)) {
                    int n2 = nei[0];
                    int w2 = nei[1];
                    if (visited.contains(nei))
                        continue;
                    pq.offer(new int[] {w1 + w2, n2});
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
