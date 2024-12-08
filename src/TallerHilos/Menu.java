package TallerHilos;

public class Menu {
    public static void main(String[] args) {
        Atleta atleta1 = new Atleta("Atleta 1");
        Atleta atleta2 = new Atleta("Atleta 2");
        Atleta atleta3 = new Atleta("Atleta 3");
        Atleta atleta4 = new Atleta("Atleta 4");
        Atleta atleta5 = new Atleta("Atleta 5");

        HiloAtleta hilo1 = new HiloAtleta(atleta1);
        HiloAtleta hilo2 = new HiloAtleta(atleta2);
        HiloAtleta hilo3 = new HiloAtleta(atleta3);
        HiloAtleta hilo4 = new HiloAtleta(atleta4);
        HiloAtleta hilo5 = new HiloAtleta(atleta5);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}

