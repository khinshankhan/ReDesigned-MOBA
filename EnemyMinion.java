public class EnemyMinion extends Enemy{

    int lane;
    int pathPoint;

    public EnemyMinion(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int ln, int gold){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
        dropgold = gold;
	lane = ln;
	pathPoint = 0;
    }
}
