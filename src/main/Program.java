package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

        //kiírás:
        try {
            FileOutputStream fileOut = new FileOutputStream("galeria.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(galeria);
            out.close();
            fileOut.close();
            System.out.printf("sikeres kiírás!");
        } catch (IOException i) {
            i.printStackTrace();
        }
        galeria = null;

        //Visszaolvasás
        try {
            ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("galeria.bin"));
            galeria = (Galeria) objBe.readObject();
            objBe.close();
            System.out.println("Visszaállítás:");
            for (KiallitasiTargy targy : galeria) {
                System.out.println(targy);
            }
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Sikertelen beolvasás!");
            c.printStackTrace();
            return;
        }
    }
}
