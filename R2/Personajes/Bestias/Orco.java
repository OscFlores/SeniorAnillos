package R2.Personajes.Bestias;

public class Orco extends Bestia{
    private static int contadorInstancias;
    public Orco(String nombre){
        super(300,45,nombre);
    } 
    public static int getInstancias(){
        return Orco.contadorInstancias;
    }
}
