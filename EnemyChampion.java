public class EnemyChampion extends Champion implements Enemy{

    public EnemyChampion(int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int dx, int dy, int pic, int hprgn, int mp, int mprgn, int mPow, int pritype){
	super(int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int dx, int dy, int pic, int hprgn, int mp, int mprgn, int mPow, int pritype);
        dropgold = 300;
	target = null;
        visible = false;
    }

}
