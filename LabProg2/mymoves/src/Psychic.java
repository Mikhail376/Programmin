import ru.ifmo.se.pokemon.*;
public class Psychic extends SpecialMove {
    public Psychic(double pow, double acc){
        super(Type.NORMAL, pow, acc);
    }
    public String describe(){
        return "does Psychic";
    }
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        if(Math.random() < 0.1){;
        Effect e = new Effect().stat(Stat.SPECIAL_DEFENSE, -1);
        p.addEffect(e);
        }
    }
}