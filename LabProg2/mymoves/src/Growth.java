import ru.ifmo.se.pokemon.*;
public class Growth extends StatusMove {
    public Growth(double pow, double acc){
        super(Type.NORMAL, pow, acc);
    }
    public String describe(){
        return "does Growth";
    }
    protected void applySelfEffects(Pokemon p){
        super.applySelfEffects(p);
        Effect e = new Effect().stat(Stat.SPECIAL_ATTACK,1);
        p.addEffect(e);
        Effect a = new Effect().stat(Stat.ATTACK,1);
        p.addEffect(a);
    }
}