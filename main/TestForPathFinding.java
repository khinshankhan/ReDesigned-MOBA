public class TestForPathFinding{
    public static void main (String [] args){
	Map map = new Map(10, 10);
	Mnode e = new Mnode(4,-9,null,0,0,false);
	//int d = Math.abs(e.y -s.y) + Math.abs(s.x - e.x);
	Mnode s = new Mnode(0, 0, null, 0, 13, false);
	Solver gerr = new Solver(map);
	gerr.solve(s,e);
    }
}
