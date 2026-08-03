class Solution {
    private boolean isValidCell(int nrow, int mcol, int[][] vis, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //valid condition
        if(nrow>=0 && nrow<n && mcol>=0 && mcol<m && vis[nrow][mcol] == 0 && grid[nrow][mcol] == 1) {
            return true; 
        }
        return false;
    }
    private int dfs(int nrow, int mcol, int[][] vis, int[][] grid) {
        if(!isValidCell(nrow, mcol, vis, grid)) {
            return 0;
        }
        vis[nrow][mcol] = 1;
       return 1
                + dfs(nrow - 1, mcol, vis, grid)
                + dfs(nrow + 1, mcol, vis, grid)
                + dfs(nrow, mcol - 1, vis, grid)
                + dfs(nrow, mcol + 1, vis, grid);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int maxArea = 0;
        for(int row = 0; row<n; row++) {
            for(int col = 0; col<m; col++) {
                if(vis[row][col] == 0 && grid[row][col] == 1) {
                    int area = dfs(row, col, vis, grid);
                    maxArea = Math.max(maxArea, area);

                }
            }
        }
        return maxArea;
    }
}
