package R2.Personajes.Bestias;
import R2.Personajes.*;
import R2.Principal.Dado;
public class Bestia extends Base{
    private static int ataqueMinimo =0;
    private static int ataqueMaximo =90;
    private static final int ARMADURA_MINIMA =50;
    private static int armaduraMax = 70;
    private static int cantDados =1;
    private Dado d = new Dado();
    public Bestia(String nombre, int vida) {
        super(nombre, vida, Bestia.ataqueMaximo, Bestia.armaduraMax, Bestia.cantDados, false);
    }
    public int getArmaduraTurno() {
        armadura = d.tirarDado(Bestia.ARMADURA_MINIMA,Bestia.armaduraMax,Bestia.cantDados);
        return armadura;
    }
    public int getAtaqueTurno() {
        ataque = d.tirarDado(Bestia.ataqueMinimo, Bestia.ataqueMaximo,Bestia.cantDados);
        return ataque;
    }

}
