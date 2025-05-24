package megoldás;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Étterem {
    Vector<Étel> étlap;
    static int pizzákSzáma;
    
    Étterem(String fájlnév) {
        étlap = new Vector<>();
        pizzákSzáma = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(fájlnév))) {
            String sor;
            while ((sor = br.readLine()) != null) {
                String[] adatok = sor.split("#");
                String osztály = adatok[0];
                String megnevezés = adatok[1];
                int ár = Integer.parseInt(adatok[2]);
                int kalória = Integer.parseInt(adatok[3]);
                double súly = Double.parseDouble(adatok[4]);
                ÉtelTipus tipus = ÉtelTipus.valueOf(adatok[5].toUpperCase());
                
                if (osztály.equals("PIZZA")) {
                    int átmérő = Integer.parseInt(adatok[6]);
                    étlap.add(new Pizza(megnevezés, ár, kalória, súly, tipus, átmérő));
                    pizzákSzáma++;
                } else {
                    étlap.add(new Étel(megnevezés, ár, kalória, súly, tipus));
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba történt a fájl olvasása közben: " + e.getMessage());
        }
    }
    double átlagÁr() {
        double árÖsszeg = 0.0;
        for (Étel étel: étlap) {
            árÖsszeg += étel.ár;
        }
        return árÖsszeg/étlap.size();
    }

    public List<String> maxKalóriaÉrtékűÉtelekNeveinekListája() {
        ArrayList<String> névLista = new ArrayList<String>();
        int maxKal = 0;
        for (Étel étel: étlap) {
            maxKal = Math.max(maxKal, étel.kalória);
        }

        for (Étel étel: étlap) {
            if (étel.kalória == maxKal) névLista.add(étel.megnevezés);
        }
        return névLista;
    }

    public int legolcsóbbPizzaára() {
        int minPizzaÁr = Integer.MAX_VALUE;
        for (Étel étel: étlap) {
            if (étel instanceof Pizza) minPizzaÁr = Math.min(minPizzaÁr, étel.ár);
        }
        return minPizzaÁr;
    }

    public String legdrágábbLevesNeve() {
        int maxLevesÁr = Integer.MIN_VALUE;
        Étel eddigiLegdrágábbLeves = null;
        for (Étel étel: étlap) {
            if (étel.tipus == ÉtelTipus.LEVES )  {
                maxLevesÁr = Math.max(maxLevesÁr, étel.ár);
                eddigiLegdrágábbLeves = étel;
            }
        }
        if (eddigiLegdrágábbLeves == null ) return "nincs is leves"; else return eddigiLegdrágábbLeves.megnevezés;

   }

    public String létezikHawaiiPizzávalEgyezőÖsszKalóriájúMásikÉtel() {
        Étel eddigiHawaiiPizza = null;
        int hawaiPizzaÖsszKalória = Integer.MIN_VALUE;
        for (Étel étel : étlap) {
            if (étel instanceof Pizza && étel.megnevezés.equals("Hawai pizza")) {
                hawaiPizzaÖsszKalória = étel.összkalória();
                eddigiHawaiiPizza = étel;
            }
        }
        if (hawaiPizzaÖsszKalória == Integer.MIN_VALUE) {
            return "nincs is hawai pizza";
        } else {
            for (Étel étel : étlap) {
                if (étel.összkalória() == hawaiPizzaÖsszKalória && étel != eddigiHawaiiPizza) return "létezik";
            }
        }
        return "nem létezik";

    }
}