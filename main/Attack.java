abstract class Attack extends OnScreen{

    public int damage;
    public int effect;
    public int effectDuration;

    public Attack(int dx, int dy, int pic, int dmg, int eff, int dur){
        super(dx, dy, pic);
	damage = dmg;
	effect = eff;
	effectDuration = dur;
    }

    public void trigger(){
    }
    
}
