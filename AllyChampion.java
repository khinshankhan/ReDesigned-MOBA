public class AllyChampion extends Champion implements Ally{

    //Doesn't need anything extra.

    public AllyChampion(int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int dx, int dy, int pic, int hprgn, int mp, int mprgn, int mPow, int pritype, int visrange){
	super(int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int dx, int dy, int pic, int hprgn, int mp, int mprgn, int mPow, int pritype);
	sight = visrange;
	target = null;
	blind = false;
    }
    
}
