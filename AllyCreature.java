public class AllyCreature extends Ally{

    public int homeDistance;

    public Buff createBuff(){
	return new Buff(0,0,null,0);
    }
    
    public void regeneration(){
    }

    public AllyCreature(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, Enemy tar){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	homeDistance = 0;
	EnemyTarget = tar;
	sight = 0;
	blind = true;
    }

}
