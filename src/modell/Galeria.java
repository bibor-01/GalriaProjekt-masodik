package modell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Galeria implements Iterable<KiallitasiTargy>{

    private ArrayList<KiallitasiTargy> targyak;

    public Galeria() {
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
