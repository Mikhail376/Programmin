import ru.ifmo.se.pokemon.*;
public class TeeterDance extends SpecialMove {
    public TeeterDance(double pow, double acc){
        super(Type.NORMAL, pow, acc);
    }
    public String describe(){
        return "does TeeterDance";
    }
}