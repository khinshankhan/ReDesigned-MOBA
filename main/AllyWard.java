public class AllyWard extends AllyBuilding implements Temporary{

    public int lifetime;


    public void live(){
	lifetime --;
    }

    public AllyWard(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int life){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	sprite = 7;
	health = 3;
	damage = 0;
	armor = 0;
	magicResistance = 0;
	attackSpeed = 0;
	moveSpeed = 0;
	range = 0;
	sight = 550;
	EnemyTarget = null;
	blind = false;
	lifetime = life;
    }
}
