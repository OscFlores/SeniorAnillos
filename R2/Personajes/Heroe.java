package R2.Personajes;

public class Heroe extends Base{
    private static int ataqueMaximo = 100;
    private static int instanciasHeroes;
    public Heroe(int vida, int armadura, String nombre){
        super(vida,armadura,ataqueMaximo,nombre,true);
        Heroe.instanciasHeroes++;
    }
    public static int getInstancias(){
        return Heroe.instanciasHeroes;
    }
}
