package R2.Personajes.Heroes;

public class Hobbit extends Heroe{
    private static int contadorInstancias;
    public Hobbit(String nombre){
        super(200, 40, nombre);
        Hobbit.contadorInstancias++;
    } 
    public static int getInstancias(){
        return Hobbit.contadorInstancias;
    }
}

