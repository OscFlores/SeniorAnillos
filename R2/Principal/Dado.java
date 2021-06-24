package R2.Principal;
public class Dado {
 public Dado(){
      
}   
    public int tirarDado(int valorMenor, int valorMayor, int cantidadDados){
        int dado = valorMenor;
        int resultado = valorMenor;
        for (int i = 1; i <= cantidadDados; i++) {
            dado =(int) (Math.random()*(valorMayor-valorMenor+1)+valorMenor);
        if (resultado < dado)
            resultado = dado;
        }
        return resultado;
    }
}