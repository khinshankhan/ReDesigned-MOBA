import java.util.*;

public class MazeSolver {
  public Mnode [][] map;
  public int[][] moves = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
  public Location start;
  public Location end;
  public Mnode next;
  public char[][] maze;

  public MazeSolver(Mnode [][] map) {
    this.map = map;
    maze = new char[map.length][map[0].length];
  }

  public Mnode nodes(Mnode start, Mnode end) {
    for (char[] i : maze) {
      for (char j : i) {
        j = ' ';
      }
    }
    this.end = new Location( end.row, end.col, null, 0, 0, false);
    int d = Math.abs(end.row - start.row) + Math.abs(start.col - end.col);
    this.start = new Location( start.row, start.col, null, 0, d, false);
    return next;
  }

  public void solve(int i) {
    try {
      printer();
      PriorityQueueFrontier storage;
      boolean aStar= true;
      storage = new PriorityQueueFrontier(false);
      aStar = true;
      storage.add(start);
      int sr= start.row();//start row
      int sc= start.col();//start col
      int er= end.row();//end row
      int ec= end.col();//end col
      while (storage.hasNext()) {
        Location current = storage.next();
        int row= current.row();
        int col= current.col();
        int dist= Math.abs(er - row)+ Math.abs(ec - col);
        if (dist == 0) {
          maze[er][ec] = 'E';
          while (current != start) {
            current= current.previous();
            maze[current.row()][current.col()]= '@';
            next = map[current.row()][current.col()];
            printer();
          }
          maze[sr][sc] = 'S';
          printer();
          return;
        }
        int moved = 0;
        for (int[] move : moves) {
          try {
            int r = row + move[0];
            int c = col + move[1];
            if (maze[r][c] == ' ' && map[r][c].walkable == true) {
              int startDist= Math.abs(sr - r)+ Math.abs(sc - c);
              int endDist= Math.abs(er - r)+ Math.abs(ec - c);
              storage.add(new Location(r, c, current, startDist, endDist, aStar));
              maze[r][c] = '?';
            }
          }
          catch (IndexOutOfBoundsException e) {
          }
        }
        char setter= (moved==0) ? '.' : '@';
        maze[row][col] = setter;
        printer();
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public String toString() {
    return Arrays.toString(maze);
  }
  public void printer() {
    System.out.println(this.toString());
  }
}