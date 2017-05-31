public class TemporaryBuff implements Temporary{

    //or interface
    public int effect;
    public int effectDuration;
    Alive target;

    public void addEffect(){
    }

    public void removeEffect(){
    }

    public TemporaryBuff(int eff, int dur, Alive tar, int lifetime){
	target = tar;
	effect = eff;
	effectDuration = dur;
	counter = lifetime;
    }
    
}
