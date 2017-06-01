public class EnemyCreature extends Enemy{

    public int homeDistance;

    public Buff createBuff(){
	return new Buff(0,0,null,0);
    }
    
    public void regeneration(){
    }

    public EnemyCreature(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int drop, Ally tar){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	homeDistance = 0;
	AllyTarget = tar;
	dropgold = drop;
	visible = true;
    }

}
