public class Player extends Champion implements Ally{

    //this class is here to distinguish the player from teammates.
    //Players do function the same as other AllyChampion though, and won't require extra code within the actual class.

    public Player(int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int dx, int dy, int pic, int hprgn, int mp, int mprgn, int mPow, int pritype, int visrange){
	super(int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int dx, int dy, int pic, int hprgn, int mp, int mprgn, int mPow, int pritype);
	sight = visrange;
	target = null;
	blind = false;
    }
    
}
