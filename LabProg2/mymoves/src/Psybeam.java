import ru.ifmo.se.pokemon.*;

public class Psybeam extends SpecialMove {
    public Psybeam(double pow, double acc){
        super(Type.PSYCHIC, pow, acc);
    }
    public String describe(){
        return "does Psybeam";
    }
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        if(Math.random() < 0.1){
            Effect.confuse(p);

        }
    }
}