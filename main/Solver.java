import java.util.ArrayDeque;

public class Solver{
    public Mnode[][] map;
    public int[][] moves = { {1,1}, {-1,-1}, {1,-1}, {-1,1}, {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    public Mnode start;
    public Mnode end;
    public ArrayDeque<Mnode> locations;

    public Solver(){
    }

    public Solver(Mnode s, Mnode e, Mnode[][] map) {
        solve(s, e, map);
    }

    public void solve(Mnode s, Mnode e, Mnode[][] map) {
        this.map = map;
	start = s;
	end = e;
	solve(1);
    }

    public void solve(int i) {
        locations = new ArrayDeque<Mnode>();
        Frontier storage;
	boolean aStar= true;
	storage = new PriorityQueueFrontier(false);
	storage.add(start);
	//System.out.println(start+"\n"+end);
	int sr= start.row;//start row
	int sc= start.col;//start col
	int er= end.row;//end row
	int ec= end.col;//end col
	System.out.println(sr+","+sc+":"+er+","+ec);
	int counter = 0;
	int gao = 0;
	while (storage.hasNext()){
	    counter++;
	    Mnode current = storage.next();
	    int row = current.row;
	    int col = current.col;
	    int dist = Math.abs(er - row)+ Math.abs(ec - col);
	    if(dist == 0){
		System.out.println(gao+"TRACEBACK "+counter);
		while(current.row != start.row && current.col != start.col){
		    locations.addFirst(current);
		    current = current.previous();
		    //System.out.println(this.toString());
		}
		//System.out.println(this.toString());
		return;
	    }
	    int moved = 0;
	    for (int[] move : moves) {
		try{
		    gao++;
		    int r = row + move[0];
		    int c = col + move[1];
		    //System.out.println(map[r][c]);
		    if (map[r][c].walk == true){
			int startDist= Math.abs(sr - r)+ Math.abs(sc - c);
			int endDist= Math.abs(er - r)+ Math.abs(ec - c);
			Mnode temp = new Mnode(r, c, current, startDist, endDist, aStar);
			storage.add(temp);
			//should i have smth here?
                    }
		}catch (IndexOutOfBoundsException | NullPointerException e){}
	    }
	    map[row][col].walk = false;
	    //System.out.println(this.toString());
	}
    }

    public String toString() {
        String s="";
	/*
	  for(int i = 0; i < map.length; i++){
	  for(int j = 0; j < map[0].length; j++){
	  char x = map[i][j];
	  if(map[i][j] == walk)
	  x= 'X';
	  s += x;
	  }
	  s += "\n";
	  }*/
	return s;
    }
}
