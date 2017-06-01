public class FreeProjectile extends Projectile{

    public int traveled;
    public int maximum;

    public FreeProjectile(int dx, int dy, int pic, int dmg, int eff, int dur, int spd, int max){
	super(dx, dy, pic, dmg, eff, dur, spd);
	maximum = max;
    }

}
