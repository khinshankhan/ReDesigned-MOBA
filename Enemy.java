abstract class Enemy extends Alive{

    public int dropgold;
    public Ally AllyTarget = null;
    public boolean visible = true;

    public Enemy(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
    }
}
