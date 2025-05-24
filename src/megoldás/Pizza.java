package megoldás;

public class Pizza extends Étel implements PizzaInterfész {
    int átmérő;

    Pizza(){super();};

    public Pizza(String megnevezés, int ár, int kalória, double súly, ÉtelTipus tipus, int átmérő) {
        super(megnevezés, ár, kalória, súly, tipus);
        this.átmérő = átmérő;
    }

    @Override
    /* – igazat ad vissza, ha az Etel osztálybeli bemenő paraméterének
    ugyanakkora az osszkaloria értéke */
    public boolean ugyanannyikaloria(Étel masiketel) {
        return masiketel.összkalória() == this.összkalória();
    }

    @Override
    /*
    visszaadja egész számként, hogy mennyivel többet kell fizetni az
    alapárhoz képest, ha 25, vagy 30 cm-es a pizza. 25 cm-es pizza 15%-al, a 30 cm-es
    pizza 25%-al drágább
     */
    public int meretar() {
        switch (átmérő) {
            case 25: return (int)(ár*1.15);
            case 30: return (int)(ár*1.25);
            default: return ár;
        }

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "megnevezés='" + megnevezés + '\'' +
                ", ár=" + ár +
                ", kalória=" + kalória +
                ", súly=" + súly +
                ", tipus=" + tipus +
                ", átmérő=" + átmérő +
                '}';
    }
}
