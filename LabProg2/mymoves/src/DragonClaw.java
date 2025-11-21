import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class DragonClaw extends PhysicalMove{
    public DragonClaw(double pow, double acc){
            super(Type.DRAGON, pow, acc);
    }

    public String describe(){
        return "does DragonClaw";
    }
}