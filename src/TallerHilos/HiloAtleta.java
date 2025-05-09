package TallerHilos;

public class HiloAtleta extends Thread {
    private Atleta atleta;

    public HiloAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public void run() {
        int distanciaRecorrida = 0;
        while (distanciaRecorrida < 10000) {
            
            distanciaRecorrida += atleta.getVelocidad();
            System.out.println(atleta.getNombre() + " ha recorrido " + distanciaRecorrida + " km.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error en el hilo");
            }
        }
        System.out.println(atleta.getNombre() + " ha llegado a la meta!");
    }
}