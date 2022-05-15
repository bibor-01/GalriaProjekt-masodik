package main;

import modell.Festmeny;
import modell.Galeria;
import modell.KiallitasiTargy;

public class Program {

    public static void main(String[] args) {
        Galeria galeria = new Galeria();

        System.out.println("cím szerinti rendezést");
        for (KiallitasiTargy kiallitasiTargy : galeria) {
            System.out.println(kiallitasiTargy);
        }

        System.out.println("készítő szerinti rendezést");
        for (KiallitasiTargy kiallitasiTargy : galeria) {
            System.out.println(kiallitasiTargy);
        }

        for (KiallitasiTargy targy : galeria) {
            if (targy instanceof Festmeny) {
                ((Festmeny) targy).megjelenit();
            }
        }
    }

}
