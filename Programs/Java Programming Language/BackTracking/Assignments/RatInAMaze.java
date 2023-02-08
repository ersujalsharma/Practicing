package BackTracking.Assignments;

/**
 * RatInAMaze
 */
public class RatInAMaze {

    //0 maze block location
    //1 maze's open / available location
    // starting 0,0 end n-1,n-1
    public static void main(String[] args) {
        int maze[][] ={
                { 1, 0, 0, 0 },
                    { 1, 1, 0, 1 },
                    { 0, 1, 0, 0 },
                    { 1, 1, 1, 1 } 
                };
        helperfunction(maze,0,0,"");
    }

    private static void helperfunction(int[][] maze, int i, int j, String string) {
        if(i==maze.length-1 && j==maze[0].length-1){
            System.out.println(string);
        }
        maze[i][j] = 0;
        // Up --- minimum value of row is 1 because it will subtract 1 and then place 
        if(i>0 && maze[i-1][j]==1){
            helperfunction(maze, i-1, j, string+"U");
        }
        // Right
        if(j<maze[0].length-1 && maze[i][j+1]==1){
            helperfunction(maze, i, j+1, string+"R");
        }
        //Left
        if(j>0 && maze[i][j-1]==1){
            helperfunction(maze, i, j-1, string+"L");
        }
        //Down
        if(i<maze.length-1 && maze[i+1][j]==1){
            helperfunction(maze, i+1, j, string+"D");
        }
        maze[i][j]= 1;
    }
}