public class HomingProjectile extends Projectile{

    public Alive target;

    public HomingProjectile(int dx, int dy, int pic, int dmg, int eff, int dur, int spd, Alive tar){
	super(dx, dy, pic, dmg, eff, dur, spd);
	target = tar;
    }
}
