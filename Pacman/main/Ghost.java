import java.util.ArrayDeque;
public class Ghost{

    public int x, y;
    public ArrayDeque<Mnode> moves;
    public boolean edible;
    public String which;

    public Ghost(Mnode start, String name){
	x = start.dx;
	y = start.dy;
	moves = new ArrayDeque<Mnode>();
	moves.addFirst(start);
	which = name;
    }

    public Mnode nextSpot(){
	//decide where to go for the next spot, so that in the main.pde file, you can be like if [ghost].moves.size() == 1, [ghost].moves = calculate([ghost].moves.peek(), [ghost].next(), 6)
    }

}
