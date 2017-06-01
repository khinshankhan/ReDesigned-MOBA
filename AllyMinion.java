public class AllyMinion extends Ally{

    int lane;
    int pathPoint;

    public AllyMinion(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int ln){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	sight = 300;
	lane = ln;
	pathPoint = 0;
    }
}
