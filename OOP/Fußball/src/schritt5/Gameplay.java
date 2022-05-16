package schritt5;

import Schritt6.SpielAbbruchException;
import schritt1.Spieler;
import schritt2.Torwart;
import schritt4.Mannschaft;
import schritt4.Spiel;

import java.util.Random;

public class Gameplay {
    private static final int SPIELZEIT = 90;
    private static final int MAX_NACHSPIELZEIT = 5;
    private static final int MAX_DAUER_BIS_AKTION = 10;

    private static int ermittelMannschaftsWert(Mannschaft mannschaft) {
        int mannschaftsWert = mannschaft.getMotivation() * mannschaft.getStaerke() * mannschaft.getTrainer().getErfahrung();
        Math.max(mannschaftsWert, 1);
        return mannschaftsWert;
    }

    private static boolean erzieltTor(Spieler schuetze, Torwart torwart) {
        boolean erzielttor;
        Random r = new Random();
        int wert1 = r.nextInt(5) - 2;
        int wert2 = r.nextInt(5) - 2;
        int torschuss = schuetze.getTorschuss() + wert1;
        Math.max(torschuss, 1);
        int reaktion = torwart.getReaktion() + wert2;
        Math.max(reaktion, 1);
        erzielttor = torschuss > reaktion;
        return erzielttor;
    }

    public static void spielen(Spiel spiel) throws SpielAbbruchException{
        Random r = new Random();
        int spieldauer = SPIELZEIT + r.nextInt(MAX_NACHSPIELZEIT + 1);
        int naechsteAktionZufall = 1 + r.nextInt(MAX_DAUER_BIS_AKTION + 1);
        int mannschaftsWertHeim = ermittelMannschaftsWert(spiel.getHeim());
        int mannschaftsWertGast = ermittelMannschaftsWert(spiel.getGast());
        Mannschaft offensiv;
        Mannschaft defensiv;
        do {
            if (brecheSpielAb()) {
                throw new SpielAbbruchException(naechsteAktionZufall);
            }
            int summewert = mannschaftsWertHeim + mannschaftsWertGast;
            int abgleich = r.nextInt(summewert);
            if (abgleich <= mannschaftsWertHeim) {
                offensiv = spiel.getHeim();
                defensiv = spiel.getGast();
            } else {
                offensiv = spiel.getGast();
                defensiv = spiel.getHeim();
            }

            int index = r.nextInt(offensiv.getSpielerListe().size());
            Spieler schuetze = offensiv.getSpielerListe().get(index);
            boolean erzieltTor = erzieltTor(schuetze, defensiv.getTorwart());
            if (erzieltTor) {
                schuetze.setTore();
                if (offensiv == spiel.getHeim()) {
                    spiel.getErgebnis().setTrefferHeim();
                    System.out.println();
                } else {
                    spiel.getErgebnis().setTrefferGast();
                }
                spiel.getSpielverlauf().append(naechsteAktionZufall + ": Tor von " + schuetze.getName() + " für " + offensiv.getName() + "!\n");
            } else {
                spiel.getSpielverlauf().append(naechsteAktionZufall + ": Schuss parriert!\n");
            }
            naechsteAktionZufall = naechsteAktionZufall + r.nextInt(MAX_DAUER_BIS_AKTION + 1);
        } while (naechsteAktionZufall <= spieldauer);
        spiel.getSpielverlauf().append(spiel.getErgebnis());

    }

    public static boolean brecheSpielAb() {
        boolean abbruch;
        Random r = new Random();
        int index = r.nextInt(1000);
        if (index == 0) {
            abbruch = true;
        } else {
            abbruch = false;
        }
        return abbruch;

    }
}



