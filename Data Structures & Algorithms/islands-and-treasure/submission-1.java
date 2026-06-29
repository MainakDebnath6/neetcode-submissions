class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
        if (q.size() == 0)
            return;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr >= grid.length || nc >= grid[0].length || nr < 0 || nc < 0
                    || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[]{nr,nc});
                grid[nr][nc]=grid[row][col]+1;
            }
        }
    }
}
