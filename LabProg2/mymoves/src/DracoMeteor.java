import ru.ifmo.se.pokemon.*;

public class DracoMeteor extends SpecialMove {
    public DracoMeteor(double pow, double acc){
        super(Type.DRAGON, pow, acc);
    }
    public String describe(){
        return "does DracoMeteor";
    }
    protected void applySelfEffects(Pokemon p){
        super.applySelfEffects(p);
        Effect e = new Effect().stat(Stat.SPECIAL_ATTACK,-2);
        p.addEffect(e);
    }
}
