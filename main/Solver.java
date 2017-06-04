public class Solver{
    public Map maze;
    public int[][] moves = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {0, 2}, {0, -2} };
    public Mnode start;
    public Mnode end;

    public Solver(Map map) {
        maze = map;
    }

    public void solve(Mnode s, Mnode e) {
	start = s;
	end = e;
	solve(1);
    }

    public void solve(int i) {
        Frontier storage;
	boolean aStar= true;
	    storage = new PriorityQueueFrontier(false); //wasnt sure about 4?
	storage.add(maze.getStart());
	int sr= maze.getStart().row();//start row
	int sc= maze.getStart().col();//start col
	int er= maze.getEnd().row();//end row
	int ec= maze.getEnd().col();//end col
	while (storage.hasNext()){
	    Location current = storage.next();
	    int row= current.row();
	    int col= current.col();
	    int dist= Math.abs(er- row)+ Math.abs(ec- col);
	    if(dist == 0){
		maze.set(er, ec, 'E');
		while(current != maze.getStart()){
		    current= current.previous();
		    maze.set(current.row(), current.col(), '@');
		    System.out.println(this.toString());
		}
		maze.set(sr, sc, 'S');
		System.out.println(this.toString());
		return;
	    }
	    int moved = 0;
	    for (int[] move : moves) {
		try{
		    int r = row + move[0];
		    int c = col + move[1];
		    if (maze.get(r, c) == ' '){
			int startDist= Math.abs(sr- r)+ Math.abs(sc- c);
			int endDist= Math.abs(er- r)+ Math.abs(ec- c);
			storage.add(new Location(r, c, current, startDist, endDist, aStar));
			maze.set(r , c, '?');
                    }
		}catch (IndexOutOfBoundsException e){}
	    }
	    char setter= (moved==0) ? '.' : '@';
	    maze.set(row, col, setter);
	    System.out.println(this.toString());
	}
    }

    public String toString() {
	if (animation) {
	    return maze.toString(100);
	}
	return maze.toString();
    }
}
