import ru.ifmo.se.pokemon.*;
public class FocusBlast extends SpecialMove {
    public FocusBlast(double pow, double acc){
        super(Type.FIGHTING, pow, acc);
    }
    public String describe(){
        return "does FocusBlast";
    }
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        if(Math.random() < 0.1){;
            Effect e = new Effect().stat(Stat.SPECIAL_DEFENSE, -1);
            p.addEffect(e);
        }
    }
}