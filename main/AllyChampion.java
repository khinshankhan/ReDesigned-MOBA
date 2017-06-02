import java.util.ArrayDeque;
public class AllyChampion extends Ally{

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
    ArrayDeque<Mnode> Path;

    public AllyChampion(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge, int hprgn, int mp, int mprgn, int mPow, int pritype){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
	sight = 550;
	hpregen = hprgn;
	mana = mp;
	magicPower = mPow;
	objective = pritype;
	critChance = 0;
	mpregen = mprgn;
        currentDanger = 0;
	cooldowns = new int[4];
	moves = new int[4];
	inventory = new int[6];
	gold = 0;
	canauto = true;
	canskill = true;
	canitem = true;
	Path = new ArrayDeque<Mnode>();
    }
    
}
