public class Mnode{

    public int x;
    public int y;
    public int z;
    public boolean walkable;

    public Mnode(int dx, int dy, boolean clear){
	x = dx;
	y = dy;
	z = x *-1 -y;
	walkable = clear;
    }
}
