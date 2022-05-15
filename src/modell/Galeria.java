package modell;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Galeria implements Iterable<KiallitasiTargy>, Serializable {

    private ArrayList<KiallitasiTargy> targyak;

    public Galeria() {

        targyak = new ArrayList<>();
        try {
            //készítő és cím
            Festmeny f1 = new Festmeny("keszito1", "cim3");
            //készítő és cím a mai dátummal
            Festmeny f2 = new Festmeny(LocalDate.now(), "keszito5", "cim1");
            //készítő és cím a hibás dátummal
            //Festmeny f3 = new Festmeny(LocalDate.parse("2025-02-11"), "keszito2", "cim4");
            //készítő és cím fájl eléréssel
            Festmeny f4 = new Festmeny(new File("kep.txt"), "keszito3", "cim2");
            //készítő és cím fájl eléréssel, mai dátummal
            Festmeny f5 = new Festmeny(new File("kep.txt"), LocalDate.now(), "keszito4", "cim5");
            targyak.add(f1);
            targyak.add(f2);
            //targyak.add(f3);
            targyak.add(f4);
            targyak.add(f5);

        } catch (HibasDatumException ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mentes(KiallitasiTargy targy) {
        targyak.add(targy);
    }

    public List<KiallitasiTargy> rendezCimSzerint() {
        Collections.sort(targyak, KiallitasiTargy.cimRendez());
        return Collections.unmodifiableList(targyak);
    }

    public List<KiallitasiTargy> rendeszKeszitoSzerint() {
        Collections.sort(targyak, KiallitasiTargy.keszitoRendez());
        return Collections.unmodifiableList(targyak);
    }

    @Override
    public Iterator<KiallitasiTargy> iterator() {
        return Collections.unmodifiableList(targyak).iterator();
    }
}
