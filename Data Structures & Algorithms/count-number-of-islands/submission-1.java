class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    // private void bfs(int ro, int co, int[][] vis, char[][] grid) {
    //     vis[ro][co] = 1;
    //     Queue<Pair> q = new LinkedList<Pair>();
    //     q.add(new Pair(ro, co));
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     while(!q.isEmpty()) {
    //         //see topmost row and col and remove it
    //         int row = q.peek().first;
    //         int col = q.peek().second;
    //         q.remove();
    //         //traverse in the neighbouring rows and cols
    //         //Below traversal will give all the neighbouring rows and cols
    //         for(int deltarow = -1; deltarow <= 1; deltarow++) {
    //             for(int deltacol = -1; deltacol <= 1; deltacol++) {
    //                 if(Math.abs(deltarow) == Math.abs(deltacol)) {
    //                     continue;
    //                 }
    //                 int nrow = row+deltarow;
    //                 int mcol = col+deltacol;
    //                 if(nrow>=0 && nrow<n && mcol>=0 && mcol<m && grid[nrow][mcol]=='1' && vis[nrow][mcol]==0) {
    //                     vis[nrow][mcol] = 1;
    //                     q.add(new Pair(nrow, mcol));
    //                 }
    //             }
    //         }
    //     } 
    // }
    private boolean isVaildCell(int nrow, int mcol, int[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(nrow>=0 && nrow<n && mcol>=0 && mcol<m && grid[nrow][mcol]=='1' && vis[nrow][mcol]==0) {
            return true;
        }
        return false;
    }
    private void dfs(int row, int col, int[][] vis, char[][] grid) {
        if(!isVaildCell(row, col, vis, grid)) {
            return;
        }
        vis[row][col] = 1;

        //up
        dfs(row-1,col,vis, grid);
        //down
        dfs(row+1,col,vis, grid);
        //left
        dfs(row,col-1,vis, grid);
        //right
        dfs(row,col+1,vis, grid);

    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int row=0; row<n; row++) {
            for(int col=0; col<m; col++) {
                if(vis[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    dfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }
}
