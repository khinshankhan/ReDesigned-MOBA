import java.util.ArrayDeque;

public class Mnode implements Comparable<Mnode>{

    public int x;
    public int y;
    public int z;
    public int row;
    public int col;
    public boolean walkable;
    public int distToStart, distToGoal; //Manhattan distance?
    public Mnode previous; //connect it
    public boolean aStar; //type of algorithm
    public int priority; //smart priority
    public boolean walk;

    public Mnode(int dx, int dy, boolean clear){
	x = dx;
	y = dy;
	z = x *-1 -y;
	walkable = walk = clear;
    }
    
    public Mnode(int r, int c, int dx, int dy, boolean clear){
	row = r;
	col = c;
	x = dx;
	y = dy;
	z = x *-1 -y;
	walkable = walk = clear;
    }

    public Mnode(int r, int c, Mnode previous , int distToStart, int distToGoal){
	row = r;
	col = c;
        this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	priority = 0;
    }

    public Mnode(int r, int c, Mnode previous , int distToStart, int distToGoal, boolean aStar){
        this(r, c, previous, distToStart, distToGoal);
	this.aStar=aStar;
	priority=(!aStar)? distToGoal: distToStart+distToGoal;
    }

    public int compareTo(Mnode other){
	return priority - other.priority();
    }
    
    public int distToStart(){
	return distToGoal; 
    }
    public int distToGoal(){
	return distToGoal;
    }
    public int priority(){
	return priority;
    }
    public Mnode previous(){
	return previous;
    }

    public String toString(){
	//return "("+x+","+y+")";
	return "("+row+","+col+")";
    }

    public static double max(double x, double y){
	return Math.max(x,y);
    }
    public static ArrayDeque<Mnode> calculate(Mnode s, Mnode e, int spd){
	ArrayDeque<Mnode> moves = new ArrayDeque<Mnode>();
	double dist = Math.sqrt(((e.x - s.x) * (e.x - s.x)) + ((e.y - s.y) * (e.y - s.y)));
	//double dist = max(Math.abs(e.x-s.x), Math.abs(e.y-s.y));
	//System.out.println((double)(dist / spd));
	double times = (double)(dist / spd);
        double incrx = (double)((e.x - s.x) / times);
	double incry = (double)((e.y - s.y) / times);
	boolean overshot = false;
	if (e.x > s.x){
	    overshot = true;
	}
	moves.addFirst(s);
	int t = 0;
	for(double nowx = s.x + incrx, nowy = s.y + incry; (Math.sqrt(((e.x - nowx) * (e.x - nowx)) + ((e.y - nowy) * (e.y - nowy))) > 5) && (t < times); nowx += incrx, nowy += incry, t++){
	    moves.addLast(new Mnode((int)nowx, (int)nowy, true));
	    //System.out.println(incrx + " " + incry);
	    //System.out.println(nowx + " " + nowy);
	}
	System.out.println(moves.size());
	return moves;
    }

    //public static void main(String[] args){
    //	ArrayDeque<Mnode> temp = calculate(new Mnode(0, 0, true), new Mnode (400, 400, true), 10);
    //}
    //RECOVER PLS
}
