package R2.Personajes.Bestias;

public class Orco extends Bestia{
    private static int contadorInstancias;
    public Orco(String nombre){
        super(nombre, 300);
    }
    public static int getInstancias(){
        return Orco.contadorInstancias;
    }
}
