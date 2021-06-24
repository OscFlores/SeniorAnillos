package R2.Personajes.Heroes;
import R2.Personajes.*;
import R2.Principal.Dado;
public class Heroe extends Base{
    private static int ataqueMinimo =0;
    private static int ataqueMaximo =100;
    private static final int ARMADURA_MINIMA =50;
    private static int armaduraMax = 70;
    private static int cantDados =2;
    private Dado d = new Dado();
    public Heroe(String nombre, int vida) {
        super(nombre, vida, ataqueMaximo,  armaduraMax, cantDados, true);
    }
    public int getAtaqueTurno() {
        ataque = d.tirarDado(Heroe.ataqueMinimo, Heroe.ataqueMaximo, Heroe.cantDados);
        return ataque;
    }
    public int getArmaduraTurno() {
        armadura = d.tirarDado(Heroe.ARMADURA_MINIMA,Heroe.armaduraMax,Heroe.cantDados);
        return armadura;
    }
}
