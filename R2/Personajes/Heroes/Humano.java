package R2.Personajes.Heroes;

public class Humano extends Heroe{
    private static int contadorInstancias;
    public Humano(String nombre){
        super(180,75,nombre);
        Humano.contadorInstancias++;
    }
    public static int getInstancias(){
        return contadorInstancias;
    }
    
}
