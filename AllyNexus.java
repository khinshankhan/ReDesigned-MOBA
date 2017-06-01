public class AllyNexus extends AllyBuilding{

    public AllyNexus(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	x = 683;
        y = 384;
	sprite = 1;
	damage = 0;
	health = 3000;
	armor = 0;
	magicResistance = 0;
	attackSpeed = 0;
	moveSpeed = 0;
	range = 0;
	sight = 3000;
	EnemyTarget = null;
	blind = false;
    }

}
