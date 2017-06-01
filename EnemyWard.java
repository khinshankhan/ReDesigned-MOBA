public class EnemyWard extends EnemyBuilding implements Temporary{

    public int lifetime;


    public void live(){
	lifetime --;
    }

    public EnemyWard(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	x = dx;
	y = dy;
	sprite = 7;
	health = 3;
	damage = 0;
	armor = 0;
	magicResistance = 0;
	attackSpeed = 0;
	moveSpeed = 0;
	range = 0;
        dropgold = 5;
        AllyTarget = null;
	visible = true;
    }
}
