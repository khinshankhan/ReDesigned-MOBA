public class Creature extends Alive{

    public Ally AllyTarget;
    public Enemy EnemyTarget;

    public EnemyCreature mEC(){
	return new EnemyCreature(this.x, this.y, this.sprite, this.damage, this.health, this.armor, this.magicResistance, this.attackSpeed, this.moveSpeed, this.range, 50, AllyTarget);
    }

    public AllyCreature mAC(){
	return new AllyCreature(this.x, this.y, this.sprite, this.damage, this.health, this.armor, this.magicResistance, this.attackSpeed, this.moveSpeed, this.range, EnemyTarget);
    }
    
    public Creature(int dx, int dy, int pic, int dmg, int hp, int arm, int mr, int atkspd, int mvspd, int rnge){
	super(dx, dy, pic, dmg, hp, arm, mr, atkspd, mvspd, rnge);
    }

}
