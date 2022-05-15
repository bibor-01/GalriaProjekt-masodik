package modell;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;

class keszitoComparator implements Comparator<KiallitasiTargy> {

    @Override
    public int compare(KiallitasiTargy egyik, KiallitasiTargy masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getKeszito(), masik.getKeszito());
    }

}

class cimComparator implements Comparator<KiallitasiTargy> {

    @Override
    public int compare(KiallitasiTargy egyik, KiallitasiTargy masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getCim(), masik.getCim());
    }

}

public abstract class KiallitasiTargy {

    private LocalDate datum;
    private String keszito, cim;

    public KiallitasiTargy(String keszito, String cim) throws HibasDatumException {
        this(LocalDate.now(), keszito, cim);
    }

    public KiallitasiTargy(LocalDate datum, String keszito, String cim) throws HibasDatumException {
        if (datum.isAfter(LocalDate.now())) {
            throw new HibasDatumException(keszito);
        }
        this.datum = datum;
        this.keszito = keszito;
        this.cim = cim;
    }

    public static cimComparator cimRendez() {
        return new cimComparator();
    }

    public static keszitoComparator keszitoRendez() {
        return new keszitoComparator();
    }

    public String getKeszito() {
        return keszito;
    }

    public String getCim() {
        return cim;
    }

    @Override
    public String toString() {
        return "KiallitasiTargy{" + "datum=" + datum + ", keszito=" + keszito + ", cim=" + cim + '}';
    }

}
