package TallerHilos;

import java.util.Random;

public class Atleta {
    private String nombre;
    private int velocidad;

    public Atleta(String nombre) {
        this.nombre = nombre;
        Random random = new Random();
        this.velocidad = random.nextInt(1000) + 1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void correr() {
        System.out.println(nombre + " empieza a correr con velocidad: " + velocidad);
    }
}