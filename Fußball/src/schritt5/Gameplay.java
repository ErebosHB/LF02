package schritt5;

import schritt1.Spieler;
import schritt1.Trainer;
import schritt2.Torwart;
import schritt4.Ergebnis;
import schritt4.Mannschaft;
import schritt4.Spiel;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay {
    private static final int spielzeit = 90;
    private static final int nachspielzeit = 5;
    private static final int pause = 10;

    private static int ermittelMannschaftsWert(Mannschaft mannschaft) {
        int mannschaftsWert = mannschaft.getMotivation() * mannschaft.getStaerke() * mannschaft.getTrainer().getErfahrung();
        Math.max(mannschaftsWert,1);
        return mannschaftsWert;
    }

    private static boolean erzieltTor(Spieler schuetze, Torwart torwart) {
        boolean erzielttor;
        Random r = new Random();
        int wert1 = r.nextInt(5) - 2;
        int wert2 = r.nextInt(5) - 2;
        int torschuss = schuetze.getTorschuss() + wert1;
        Math.max(torschuss,1);
        int reaktion = torwart.getReaktion() + wert2;
        Math.max(reaktion,1);
        erzielttor = torschuss > reaktion;
        return erzielttor;
    }

    public static void spielen(Spiel spiel) {
        Random r = new Random();
        int zahl = r.nextInt(nachspielzeit + 1);
        int spieldauer = spielzeit + zahl;
        int naechsteAktionZufall = r.nextInt(pause);
        Mannschaft heim = spiel.getHeim();
        int mannschaftsWertHeim = ermittelMannschaftsWert(heim);
        Mannschaft gast = spiel.getGast();
        int mannschaftsWertGast = ermittelMannschaftsWert(gast);
        int j = naechsteAktionZufall;
        do {
            int summewert = mannschaftsWertHeim + mannschaftsWertGast;
            int abgleich = r.nextInt(summewert);
            if (abgleich > mannschaftsWertHeim) {
                System.out.println("\nTorschuss für " + gast.getName() + ": " + (j) + "min");
                int index = r.nextInt(spiel.getGast().getSpielerListe().size());
                Spieler schuetze = spiel.getGast().getSpielerListe().get(index);
                Torwart torwart = heim.getTorwart();
                boolean erzieltTor = erzieltTor(schuetze, torwart);
                if (erzieltTor) {
                    spiel.getErgebnis().setTrefferGast();
                    schuetze.setTore();
                    System.out.println("Tor von " + schuetze.getName() + " für " + gast.getName() + "!");
                } else {
                    System.out.println("Schuss parriert! ");
                }
            } else {
                System.out.println("\nTorschuss für " + heim.getName() + ": " + (j) + "min");
                int index1 = r.nextInt(spiel.getHeim().getSpielerListe().size());
                Spieler schuetze = spiel.getHeim().getSpielerListe().get(index1);
                Torwart torwart = gast.getTorwart();
                boolean erzieltTor = erzieltTor(schuetze, torwart);
                if (erzieltTor) {
                    spiel.getErgebnis().setTrefferHeim();
                    schuetze.setTore();
                    System.out.println("Tor " + schuetze.getName() + " für " + heim.getName() + "!");
                } else {
                    System.out.println("Schuss parriert! ");
                }
            }
            j += naechsteAktionZufall;
            naechsteAktionZufall = r.nextInt(pause);
            j++;
        } while (j + naechsteAktionZufall <= spieldauer);
    }
}


