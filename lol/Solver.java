import java.util.ArrayDeque;
import java.util.Iterator;

public class Solver {
    public Mnode[][] map;
    public Mnode[][] map2;
    public int[][] moves = { {1, 1}, {-1, -1}, {1, -1}, {-1, 1}, {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    public Mnode start;
    public Mnode end;
    public ArrayDeque<Mnode> locations;
    public ArrayDeque<Mnode> tempLoc;

    public Solver() {
	locations = new ArrayDeque<Mnode>();
    }

    public Solver(Mnode s, Mnode e, Mnode[][] map) {
	solve(s, e, map);
    }

    public void solve(Mnode s, Mnode e, Mnode[][] map) {
	this.map = map2 = map;
  tempLoc = new ArrayDeque<Mnode>();
	start = s;
	end = e;
	start.distToStart = 0;
	start.distToGoal = Math.abs(s.row - e.row) + Math.abs(s.col - e.col);
	solve(1);
	for(Iterator itr = tempLoc.iterator(); itr.hasNext(); ) {
	    Mnode find = (Mnode)itr.next();
	    locations.add(map[find.row][find.col]);
	}
	//debug
	//
	  System.out.println("REAL Begin:");
	  for (Iterator itr = locations.iterator(); itr.hasNext(); ) {
	  Mnode temp = (Mnode)itr.next();
	  System.out.println(temp+":"+temp.x+","+temp.y);
	  }
	  System.out.println("REAL End!");
    System.out.println("SIZE: "+locations.size());
	//
    }

    public void solve(int i) {
	locations = new ArrayDeque<Mnode>();
	tempLoc = new ArrayDeque<Mnode>();
	Frontier storage;
	boolean aStar= true;
	storage = new PriorityQueueFrontier(false);
	storage.add(start);
	//System.out.println(start+"\n"+end);
	int sr= start.row;//start row
	int sc= start.col;//start col
	int er= end.row;//end row
	int ec= end.col;//end col
	//debug
	//System.out.println(sr+","+sc+":"+er+","+ec);
	//int counter = 0;
	//int gao = 0;
	while (storage.hasNext()) {
	    //counter++;
	    Mnode current = storage.next();
	    int row = current.row;
	    int col = current.col;
	    int dist = Math.abs(er - row)+ Math.abs(ec - col);
	    if (dist == 0) {
		//System.out.println(gao+"TRACEBACK "+counter);
		tempLoc.addFirst(current);
		while (current.row != start.row && current.col != start.col) {
		    current = current.previous();
		    tempLoc.addFirst(current);
		    //System.out.println(this.toString());
		}
		//System.out.println(this.toString());
		return;
	    }
	    int moved = 0;
	    for (int[] move : moves) {
		try {
		    //gao++;
		    int r = row + move[0];
		    int c = col + move[1];
		    //System.out.println(map[r][c]);
		    if (map[r][c].walkable == true && map2[r][c].mazeVar  == ' ') {
			//weight debate
			/*
			  int startDist = (int)Mnode.max(Math.abs(sr - r), Math.abs(sc - c));
			  int endDist = (int)Mnode.max(Math.abs(er - r), Math.abs(ec - c));
			*/
            
			int startDist= Math.abs(sr - r)+ Math.abs(sc - c);
			int endDist= Math.abs(er - r)+ Math.abs(ec - c);
			//created a 'mask' to resolve this
			/*
			  Mnode temp = map[r][c];
			  temp.previous = current;
			  temp.distToStart = startDist;
			  temp.distToGoal = endDist;
			  temp.aStar = aStar;
			*/
			Mnode temp = new Mnode(r, c, current, startDist, endDist, aStar);
			//map[r][c].walk = false;
			storage.add(temp);
			map2[r][c].mazeVar = '?';
		    }
		}
		catch (IndexOutOfBoundsException | NullPointerException e) {
		}
	    }
	    //map[row][col].walk = false;
	    char setter= (moved == 0) ? '.' : '@';
	    map2[row][col].mazeVar = setter;
	    //System.out.println(this.toString());
	}
    }

    public String toString() {
	String s="";
	/*
	  for(int i = 0; i < map.length; i++){
     	  for(int j = 0; j < map[0].length; j++){
     	  char x = map[i][j];
     	  if(map[i][j] == walkable)
     	  x= 'X';
     	  s += x;
     	  }
     	  s += "\n";
     	  }*/
	return s;
    }
}