public class Radial extends Zone{

    public int radius;

    public Radial(int dx, int dy, int pic, int dmg, int eff, int dur, int countdown, int rd){
	super(dx, dy, pic, dmg, eff, dur, countdown);
	radius = rd;
    }
}
