package megoldás;



public class Étel implements ÉtelInterfész {
    String megnevezés;
    int ár;
    int kalória;
    double súly;
    ÉtelTipus tipus;

    Étel(){};

    Étel(String megnevezés, int ár, int kalória, double súly, ÉtelTipus tipus ) {
        this.megnevezés = megnevezés;
        this.ár = ár;
        this.kalória = kalória;
        this.súly = súly;
        this.tipus = tipus;
    }

    public void növel(int százalék) {
        ár = (int) ( ár * (1  + százalék/100.0) );
    }

    /*
bruttó = nettó * 1.27;
nettó = bruttó / 1.27;
áfa = bruttó - nettó;
áfa = bruttó - bruttó / 1.27;
áfa = ár - ár*1.27
*/
    public int adó() {
        return ár - (int)(ár/1.27);
    }
    /* a súly kg-ban van mérve -- ok, tömeg, fizikusoknak,
    mig a kalóriatatalom 100 grammonként értendő, és 1 kg-ban 10 * 100 g van.
     */
    public int összkalória() {
        return (int) (súly * kalória * 10.0);
    }

    @Override
    public String toString() {
        return "Étel{" +
                "megnevezés='" + megnevezés + '\'' +
                ", ár=" + ár +
                ", kalória=" + kalória +
                ", súly=" + súly +
                ", tipus=" + tipus +
                '}';
    }
}
