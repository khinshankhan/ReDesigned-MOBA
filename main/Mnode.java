public class Mnode implements Comparable<Mnode>{

    public int x;
    public int y;
    public int z;
    public boolean walkable;
    public int distToStart, distToGoal; //Manhattan distance?
    public Mnode previous; //connect it
    public boolean aStar; //type of algorithm
    public int priority; //smart priority
    
    public Mnode(int dx, int dy, boolean clear){
	x = dx;
	y = dy;
	z = x *-1 -y;
	walkable = clear;
    }

    public Mnode(int r, int c, Mnode previous , int distToStart, int distToGoal){
	y = r;
	x = c;
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
	return "("+x+","+y+")";
    }
}