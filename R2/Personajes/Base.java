package R2.Personajes;

public class Base {
    protected int vida;
    protected int armadura;
    protected int ataque;
    protected String nombre;
    protected int ganados;
    protected int dados;
    protected boolean esHeroe;

    private static int instanciasPersonajes;

    public Base(String nombre, int vida, int ataque, int armadura, int dados, boolean esHeroe) {
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
        this.nombre = nombre;
        this.dados = dados;
        this.esHeroe = esHeroe;
        instanciasPersonajes++;
    }

    public int obtenerArmadura(Base atacante){
        return this.getArmadura();
    }

    public int obtenerAtaque(Base defensor){
        return this.getAtaque();
    }

    public void recibirAtaque(Base atacante){
        System.out.println(" " + atacante.getNombre() + " atacará a "+ this.getNombre());

        int danyoRecibido = this.obtenerArmadura(atacante) - atacante.obtenerAtaque(this);
        if (danyoRecibido <= 0){
            this.vida += danyoRecibido;
        }
        else{
            danyoRecibido = 0;
        }
        System.out.println(" "+atacante.getNombre()+  " ataco a  " + this.getNombre() + " hizo daño: " + danyoRecibido  + " le queda vida: "+this.getVida());
    }
    public int getVida() {
        return this.vida;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getArmadura() {
        return this.armadura;
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean get() {
        return this.esHeroe;
    }

    public static int getInstancias(){
        return Base.instanciasPersonajes;
    }
    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
}
