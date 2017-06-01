public class AllyInhibitor extends AllyBuilding{

    int lane;

    public AllyInhibitor(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int ln){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	lane = ln;
	switch (ln){
	case 1:
	    x = 0;
	    y = 0;
	case 2:
	    x = 0;
	    y = 0;
	case 3:
	    x = 0;
	    y = 0;
	}
	sprite = 3;
	damage = 0;
	health = 2500;
	armor = 0;
	magicResistance = 0;
	attackSpeed = 0;
	moveSpeed = 0;
	range = 0;
	sight = 0;
	EnemyTarget = null;
	blind = false;
    }

}
