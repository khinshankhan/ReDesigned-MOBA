public class Solver{
    public Map map;
    public int[][] moves = { {0, 1}, {0, -1}, {1, -1}, {-1, -1}, {1, 1}, {-1, 1} };
    public Mnode start;
    public Mnode end;
    public char[][] maze;

    public Solver(Map map) {
        this.map = map;
    }

    public void solve(Mnode s, Mnode e) {
	maze = new char [map.map.length][map.map[0].length];
	start = s;
	end = e;
	solve(1);
    }

    public void solve(int i) {
        Frontier storage;
	boolean aStar= true;
	storage = new PriorityQueueFrontier(false);
	storage.add(start);
	int sr= start.y *-1;//start row
	int sc= start.x;//start col
	int er= end.y *-1;//end row
	int ec= end.x;//end col
	while (storage.hasNext()){
	    Mnode current = storage.next();
	    int row = current.y *-1;
	    int col = current.x;
	    int dist = Math.abs(er - row)+ Math.abs(ec - col);
	    if(dist == 0){
		maze[er][ec] = 'E';
		while(current.x != start.x && current.y != start.y){
		    current = current.previous();
		    maze[current.y * -1][current.x] = '@';
		    System.out.println(this.toString());
		}
		maze[sr][sc] = 'S';
		System.out.println(this.toString());
		return;
	    }
	    int moved = 0;
	    for (int[] move : moves) {
		try{
		    int r = row + move[0];
		    int c = col + move[1];
		    if (map.map[r][c].walkable == true && maze[r][c] == ' '){
			int startDist= Math.abs(sr - r)+ Math.abs(sc - c);
			int endDist= Math.abs(er - r)+ Math.abs(ec - c);
			storage.add(new Mnode(r, c, current, startDist, endDist, aStar));
			maze[r][c] = '?';
                    }
		}catch (IndexOutOfBoundsException | NullPointerException e){}
	    }
	    char setter= (moved==0) ? '.' : '@';
	    maze[row][col] = setter;
	    System.out.println(this.toString());
	}
    }

    public String toString() {
        String s="";
	for(int i = 0; i < maze.length; i++){
	    for(int j = 0; j < maze[0].length; j++){
		char x = maze[i][j];
		if(maze[i][j] == '.')
		    x= 'X';
		s += x;
	    }
	    s += "\n";
	}
	return s;
    }
}
