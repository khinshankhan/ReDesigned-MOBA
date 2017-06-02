public class AllyTurret extends AllyBuilding{

    public int lane;
    public int number;
    public boolean cba;

    public AllyTurret(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int ln, int num){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	switch (ln){
	case 1:
	    switch (num){
	    case 1:
		x = 0;
		y = 0;
		cba = false;
	    case 2:
		x = 0;
		y = 0;
		cba = false;
	    case 3:
		x = 0;
		y = 0;
		cba = true;
	    }
	case 2:
	    switch (num){
	    case 1:
		x = 0;
		y = 0;
		cba = false;
	    case 2:
		x = 0;
		y = 0;
		cba = false;
	    case 3:
		x = 0;
		y = 0;
		cba = true;
	    }
	case 3:
	    switch (num){
	    case 1:
		x = 0;
		y = 0;
		cba = false;
	    case 2:
		x = 0;
		y = 0;
		cba = false;
	    case 3:
		x = 0;
		y = 0;
		cba = true;
	    }
	}
	range = 600;
	sight = 600;
	sprite = 5;
	health = 2500;
	armor = 0;
	magicResistance = 0;
	attackSpeed = 2;
	moveSpeed = 0;
	lane = ln;
	number = num;
        EnemyTarget = null;
	blind = false;
    }

}
