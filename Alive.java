abstract class Alive extends OnScreen{

    public int damage;
    public int health;
    public int armor;
    public int magicResistance;
    public int attackSpeed;
    public int moveSpeed;
    public int range;

    public HomingProjectile makeHomingProjectile(){
    }
    public HomingProjectile auto(int projectileSpeed, Alive target){
    }
    
    public Alive(int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int dx, int dy, int pic){
	super(dx, dy, pic);
	damage = dmg;
	health = hp;
	armor = arm;
	magicResistance = mr;
	attackSpeed = atkspd;
	moveSpeed = mvspd;
	range = rnge;
    }
}
