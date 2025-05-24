package megoldás;

public class Main {
    public static void main2(String[] args) {
        Étel e = new Étel("liszt",210,337,1.0,ÉtelTipus.ELŐÉTEL);
        System.out.println("e ára: "+e.ár + ", tipusa: " + e.tipus);
        System.out.println(" e áfája:" + e.adó());
        e.növel(10);
        System.out.println("e ára: "+e.ár + ", tipusa: " + e.tipus);
        System.out.println("e összes kalóriája: "+ e.összkalória() + ", tipusa: " + e.tipus);
        System.out.println(e);
        Pizza p = new Pizza("Margarita",6000,674,0.50,ÉtelTipus.FŐÉTEL,25);
        System.out.println(p);
        System.out.println(p.ugyanannyikaloria(e));

    }

    public static void main(String[] args) {
        Étterem étterem = new Étterem("3etel.txt");
        System.out.println("1. feladat, ételek átlagára: " + étterem.átlagÁr());
        System.out.println("2. feladat, Azon ételek megnevezése, amelyeknek a legnagyobb az egységnyi kalória értéke: " + "\n"
                + étterem.maxKalóriaÉrtékűÉtelekNeveinekListája());
        System.out.println("3. feladat, A legolcsóbb pizza ára: " +
                ( étterem.legolcsóbbPizzaára()==Integer.MAX_VALUE ? "nincs is pizza" :étterem.legolcsóbbPizzaára()));
        System.out.println("4. feladat, A legdrágább leves neve: " +
                étterem.legdrágábbLevesNeve());
        System.out.println("5. feladat, Az ételek összesített kalória értéke : " +
                500000); //TODO
        System.out.println("6. feladat, A 'Létezik' szót, ha a kollekcióban létezik egy 25 cm-es Hawai pizza\n" +
                "összakalóriájával megegyező másik étel. Ellenkező esetben a 'Nem létezik' jelenjen\n" +
                "meg: \n" +
                étterem.létezikHawaiiPizzávalEgyezőÖsszKalóriájúMásikÉtel());



    }

}
