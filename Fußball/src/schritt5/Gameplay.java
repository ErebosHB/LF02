package schritt5;

import schritt1.Spieler;
import schritt1.Trainer;
import schritt2.Torwart;
import schritt4.Mannschaft;
import schritt4.Spiel;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay {
    private static final int spielzeit = 90;
    private static final int nachspielzeit = 5;
    private static final int pause = 10;





    private static int ermittelMannschaftsWert(Mannschaft mannschaft, Trainer trainer) {
         int mannschaftswert = mannschaft.getMotivation() * mannschaft.getStaerke() * trainer.getErfahrung();
        return mannschaftswert;
    }
    private static boolean erzieltTor(Spieler schuetze, Torwart torwart){
        boolean erzielttor;
        if(schuetze.getTorschuss() >= torwart.getReaktion()){
               erzielttor= true;
        }
        else {
             erzielttor = false;
        }
        return erzielttor;
    }

    public static void spielen(Spiel spiel){
        Random ran = new Random();
        int zahl = ran.nextInt(nachspielzeit);
        int spieldauer = spielzeit + zahl;
    }
}

