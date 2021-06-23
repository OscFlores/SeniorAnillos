package R2.Personajes.Bestias;
import R2.Personajes.*;
public class Bestia extends Base{
    private static int ataqueMaximo = 90;
    public Bestia(int vida, int armadura, String nombre){
        super(vida,armadura,ataqueMaximo,nombre,true);
    }
}
