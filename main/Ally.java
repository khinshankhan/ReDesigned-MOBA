abstract class Ally extends Alive{

    public boolean blind = false;
    public int sight;
    public Enemy EnemyTarget = null;

    public Ally(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
    }
    
}
