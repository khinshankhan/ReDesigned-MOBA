abstract class Projectile extends Attack{

    int speed;

    public Projectile(int dx, int dy, int pic, int dmg, int eff, int dur, int spd){
	super(dx, dy, pic, dmg, eff, dur);
	speed = spd;
    }

    public void next(){
    }
    
}
