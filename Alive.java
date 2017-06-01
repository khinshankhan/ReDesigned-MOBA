abstract class Alive extends OnScreen{

    public int damage;
    public int health;
    public int armor;
    public int magicResistance;
    public int attackSpeed;
    public int moveSpeed;
    public int range;

    public HomingProjectile mHP(int dmg, int eff, int dur, int spd, Alive tar){
	return new HomingProjectile(this.x,this.y,0,dmg,eff,dur,spd,tar);
    }

    public FreeProjectile mFP(int dmg, int eff, int dur, int spd, int max){
	return new FreeProjectile(this.x,this.y,0,dmg,eff,dur,spd,max);
    }

    public Radial mRZ(int dmg, int eff, int dur, int tr, int rd){
	return new Radial(this.x,this.y,0,dmg,eff,dur,tr,rd);
    }

    public Angular mAZ(int dmg, int eff, int dur, int tr, int fullX, int fullY){
	return new Angular(this.x,this.y,0,dmg,eff,dur,tr,fullX,fullY);
    }
    
    public Alive(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge){
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
