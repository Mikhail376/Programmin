import ru.ifmo.se.pokemon.*;
public class StunSpore extends StatusMove {
    public StunSpore(double pow, double acc){
        super(Type.GRASS, pow, acc);
    }
    public String describe(){
        return "does StunSpore";
    }
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);

        if (p.getCondition() == Status.NORMAL) {
            p.addEffect(new Effect().condition(Status.PARALYZE));
        }
    }
}