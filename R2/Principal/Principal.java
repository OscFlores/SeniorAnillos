package R2.Principal;
import R2.Personajes.*;
import R2.Personajes.Heroes.*;
import R2.Personajes.Bestias.*;
import java.util.*;
public class Principal {
        private Heroe[] ejercitoHeroes;
        private Bestia[] ejercitoBestias;
        private final int TAMANIO_EJERCITO =5;
        Scanner teclado = new Scanner(System.in);
        private Dado f = new Dado(); 
        public static void main(String[] args) {
            Principal s = new Principal();
            s.Principals();
        }
        public void Principals(){
            ejercitoHeroes = new Heroe[TAMANIO_EJERCITO];
            ejercitoBestias = new Bestia[TAMANIO_EJERCITO];
            iniciarHeroes();
            iniciarBestias();
            bienvenida();
            iniciarJuego();
            System.out.println("Presione ENTER para SALIR");
        }
        public void iniciarJuego(){
            String ganador ="";
            System.out.println("Bienvenido a un Juego con Tematica del Señor de los Anillos");
            System.out.println("\nVAMOS A EMPEZAR CON LAS PELEAS");
            System.out.println("Quien Ganara?");
            System.out.println("ENTER para continuar");
            teclado.nextLine();
    
            for(int i=0;i<TAMANIO_EJERCITO;i++){
                System.out.println("\n\n"+(i+1)+" PELEA\n\n");
                pelea(ejercitoHeroes[i], ejercitoBestias[i]);
                ganador(ejercitoHeroes[i], ejercitoBestias[i]);
                System.out.println("Ganador" + ganador(ejercitoHeroes[i], ejercitoBestias[i]));
                teclado.nextLine();
    
                ganador= elegirGanador(ejercitoHeroes[i], ejercitoBestias[i]);
                System.out.println("El Ganador es " + ganador);
            }
    
        }
    
        public void bienvenida(){
            System.out.println("Hombres se unen a elfos para combatir contra bestias");
            System.out.println("Presiona ENTER para continuar");
            teclado.nextLine();
            iniciarHeroes();
            iniciarBestias();
            System.out.println("HEROES \n\n");
            presentarHeroes();
            System.out.println("ENTER para continuar");
            teclado.nextLine();
            System.out.println("Bestias\n\n");
            presentarBestias();
        }
        public void iniciarHeroes(){
            int random=0;
            for (int i = 0; i <TAMANIO_EJERCITO; i++) {
                random = f.tirarDado(0,2,1);
    
                switch(random){
                    case 0:
                    ejercitoHeroes[i] = new Elfo("Elfo "+i);
                    break;
    
                    case 1:
                    ejercitoHeroes[i] = new Hobbit("Frodo "+i);
                    break;
    
                    case 2:
                    ejercitoHeroes[i] = new Humano("Humano " +i);
                    break;
    
                    default:
                    ejercitoHeroes[i] = new Humano("El Bicho "+i);
                    break;
                }
    
            }
        }
    
        public void presentarHeroes(){
            for (Heroe heroes : ejercitoHeroes) {
                System.out.println(heroes.toString());
            }
        }
        public void iniciarBestias(){
            int random=0;
            for (int i = 0; i <TAMANIO_EJERCITO; i++) {
                random = f.tirarDado(0,1,1);
    
                switch(random){
                    case 0:
                    ejercitoBestias[i] = new Orco("Orco "+i);
                    break;
                    case 1:
                    ejercitoBestias[i] = new Trasgo("Trasgo "+i);
                    break;
                    default:
                    ejercitoBestias[i] = new Orco("Giamma "+i);
                    break;
                }
            }
        }
        public void presentarBestias(){
            for(Bestia bestias : ejercitoBestias) {
                System.out.println(bestias.toString());
    
            }
        }
        public void pelea(Heroe heroe, Bestia bestia){
            System.out.println("\n");
            boolean hayGanador = false;
            int contador =1;
            int ataquePot = especialidadAtaque(heroe, bestia); 
            System.out.println("\n");
            System.out.println("Heroe: "+ heroe.getNombre()+" vida: " +heroe.getVida());
            System.out.println("Contra \nBestia: " +bestia.getNombre()+ " vida: " +bestia.getVida());
                while(!hayGanador){
                    System.out.println("\n\n");
                    System.out.println("Round: "+contador);
                    int ataqueHeroe = calcularPotenciaOfensiva((heroe.getAtaqueTurno()+ataquePot), bestia.getArmaduraTurno());
                    int ataqueBestia = calcularPotenciaOfensiva(bestia.getAtaqueTurno(),heroe.getArmaduraTurno());
                    System.out.println("Ataque heroe: " +heroe.getNombre()+"= "+ataqueHeroe);
                    System.out.println("Ataque Bestia: "+bestia.getNombre()+"= "+ataqueBestia);
                    System.out.println("\n");
                    heroe.setVida(heroe.getVida()-ataqueBestia);
                    bestia.setVida(bestia.getVida() -ataqueHeroe);
                    System.out.println("Vida Heroe: "+heroe.getNombre()+" es: " +heroe.getVida() );
                    System.out.println("Vida Bestia: "+bestia.getNombre()+ " es: " +bestia.getVida());
                    if(heroe.getVida() <0 || bestia.getVida() <0){
                        hayGanador = true;
                    }
                contador++;
                teclado.nextLine();
                }
        }
        public Base ganador(Heroe heroe, Bestia bestia){
            if(heroe.getVida()>= bestia.getVida()){
                System.out.println("Heroe:" +heroe.getNombre()+ " Ganador!!");
                heroe.setGanados(heroe.getGanados()+1);
                eliminarPersonaje(bestia);
                return heroe;
    
                }else{
                System.out.println("La bestia: "+bestia.getNombre() + "GANO");
                bestia.setGanados(bestia.getGanados()+1);
                eliminarPersonaje(heroe);
                return bestia;
                }
        }  
        public void eliminarPersonaje(Base personaje){
            personaje = null;
        }
        public int calcularPotenciaOfensiva(int ataque, int defensa){
            if(ataque >= defensa){
                ataque = ataque - defensa;
            }else
                ataque =0;
            return ataque;
        }
        public int especialidadAtaque(Heroe heroe, Bestia bestia){
            int disminucion = (int)(heroe.getArmadura()*0.10);
            int ataque =0;
            if(heroe instanceof Elfo && bestia instanceof Orco){
                System.out.println("Elfo odia a Orcos, elfo incrementa su fuerza");
                ataque =10;
            }
            if(heroe instanceof Hobbit && bestia instanceof Trasgo){
                System.out.println("Hobbit teme a trasgos, decremento mi fuerza");
                ataque=-5;
            }
            if(bestia instanceof Orco){
                System.out.println("Peleo contra un orco, mi armadura disminuye");
                heroe.setArmadura(heroe.getArmadura() -disminucion);
            }
            return ataque ;
        }
    
        public String elegirGanador(Heroe heroe, Bestia bestia){
            if(heroe.getGanados() > bestia.getGanados()){
                System.out.println("Ejercito de Heroes ha Ganado");
                return "Puntuacion de " +heroe.getGanados()+ " a: " +bestia.getGanados();
            }else{
                return "Las Bestias han Ganado";
            }
    }
}
