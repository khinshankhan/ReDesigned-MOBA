abstract class Zone extends Attack implements Temporary{

    public int counter;

    public void live(){
	counter --;
    }

    public Zone(int dx, int dy, int pic, int dmg, int eff, int dur, int countdown){
	super(dx, dy, pic, dmg, eff, dur);
	counter = countdown;
    }
}
