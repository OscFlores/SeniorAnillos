package R2.Personajes.Bestias;

public class Trasgo extends Bestia{
    private static int contadorInstancias;
    public Trasgo(String nombre){
        super(325,46,nombre);
    }
    public static int getInstancias(){
        return Trasgo.contadorInstancias;
    }
}
