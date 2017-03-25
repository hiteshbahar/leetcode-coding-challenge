import java.util.LinkedList;
import java.util.Queue;

public class Solution490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(start);
        
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            if (row == destination[0] && col == destination[1]) {
                return true;
            }
            
            for (int[] dir : dirs) {
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                }
                
                row -= dir[0];
                col -= dir[1];
                
                if (visited[row][col] == true) {
                    continue;
                }
                visited[row][col] = true;
                if (row == destination[0] && col == destination[1]) {
                    return true;
                }
                queue.offer(new int[]{row, col});
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] maze = new int[][]{{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{4, 4};
        Solution490 s = new Solution490();
        System.out.println(s.hasPath(maze, start, destination));
    }

}
