
package modell;

import java.io.File;
import java.time.LocalDate;

public class Festmeny extends KiallitasiTargy{
    File eleres;

    public Festmeny(String keszito, String cim) throws HibasDatumException {
        this(new File("nincs"),keszito,cim);
    }
    
    public Festmeny(File eleres, String keszito, String cim) throws HibasDatumException {
        this(eleres,LocalDate.now(), keszito, cim);
    }

    public Festmeny(LocalDate datum, String keszito, String cim) throws HibasDatumException {
        this(new File("nincs"),datum, keszito, cim);
    }

    public Festmeny(File eleres, LocalDate datum, String keszito, String cim) throws HibasDatumException {
        super(datum, keszito, cim);
        this.eleres = eleres;
    }
    
    public void megjelenit(){
        if(eleres.exists()){
            System.out.println("Megjelenítés folyamatban...");
        }else{
            System.out.println("nem lehet megjeleníteni");
        }
    }

    @Override
    public String toString() {
        String kiir = super.toString();
        return kiir+"Festmeny{" + "eleres=" + eleres + '}';
    }
    
    
}
