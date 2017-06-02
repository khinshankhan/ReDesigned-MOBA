public class EnemyNexus extends EnemyBuilding{

    public EnemyNexus(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	x = 1366;
        y = 768;
	sprite = 2;
	damage = 0;
	health = 3000;
	armor = 0;
	magicResistance = 0;
	attackSpeed = 0;
	moveSpeed = 0;
	range = 0;
        AllyTarget = null;
        visible = true;
	dropgold = 0;
    }

}
