class Solution {
    private boolean isValidCell(int nrow, int mcol, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Corrected condition: using && instead of ;
        if (nrow >= 0 && nrow < n && mcol >= 0 && mcol < m && grid[nrow][mcol] == Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }
    
    private void bfs(Queue<int[]> q, int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // If the neighboring cell is valid unvisited land
                if (isValidCell(nr, nc, grid)) {
                    grid[nr][nc] = grid[r][c] + 1; // Update distance
                    q.add(new int[]{nr, nc});      // Add to queue
                }
            }
        }
    }
    
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        // Create a queue to store all the starting treasure locations (0s)
        Queue<int[]> q = new LinkedList<>();
        
        // Find all treasures (0s) and add them to the queue
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 0) {
                    q.add(new int[]{row, col});
                }
            }
        }
        
        // Run Multi-Source BFS on the queue
        bfs(q, grid);
    }
}