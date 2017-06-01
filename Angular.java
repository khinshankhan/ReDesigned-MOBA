public class Angular extends Zone{

    public int fullX;
    public int fullY;

    public Angular(int dx, int dy, int pic, int dmg, int eff, int dur, int countdown, int fX, int fY){
	super(dx, dy, pic, dmg, eff, dur, countdown);
        fullX = fX;
	fullY = fY;
    }
}
