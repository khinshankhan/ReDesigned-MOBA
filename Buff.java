public class Buff implements Temporary{

    public int counter;
    public int effect;
    public int effectDuration;
    Alive target;

    public void live(){
	counter --;
    }
    
    public void addEffect(){
    }

    public void removeEffect(){
    }

    public Buff(int eff, int dur, Alive tar, int lifetime){
	target = tar;
	effect = eff;
	effectDuration = dur;
	counter = lifetime;
    }
    
}
