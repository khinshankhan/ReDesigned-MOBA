import java.util.Queue;

abstract class Champion extends Alive{
    
    int hpregen;
    int mana;
    int mpregen;
    int magicPower;
    int critChance;
    int currentDanger;
    int objective;
    int[] cooldowns;
    int[] moves;
    int[] inventory;
    int gold;
    boolean canauto;
    boolean canskill;
    boolean canitem;
    Queue Path;
    
    FreeProjectile shoot(int traveled = 0, int maximum, int speed){
    }
    
    Rectangular zoner(int counter, int FullX, int FullY){
    }
    
    Circular zonec(int counter, int radius){
    }

    public Champion(int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int dx, int dy, int pic, int hprgn, int mp, int mprgn, int mPow, int pritype){
        super(dmg, hp, arm, mr, atkspd, mvspd, rnge, dx, dy, pic);
	hpregen = hprg;
	mana = mp;
	magicPower = mPow;
	objective = pritype;
	critChance = 0;
	mpregen = mprgn;
        currentDanger = 0;
	cooldowns = int[4];
	moves = new int[4];
	inventory = new int[6];
	gold = 0;
	canauto = true;
	canskill = true;
	canitem = true;
	Path = new Queue();
    }

}
