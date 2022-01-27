

public class schroot {
//    private static final int spielzeit = 90;
//    private static final int nachspielzeit = 5;
//    private static final int pause = 10;
//
//    private static int ermittelMannschaftsWert(Mannschaft mannschaft) {
//        Trainer trainer = mannschaft.getTrainer();
//        int mannschaftsWert =  mannschaft.getMotivation() * mannschaft.getStaerke() * trainer.getErfahrung();
//        if (mannschaftsWert == 0){
//            mannschaftsWert = 1;
//        }
//        return mannschaftsWert;
//    }
//
//
//    private static boolean erzieltTor(Spieler schuetze, Torwart torwart) {
//        boolean erzielttor;
//        Random r = new Random();
//        int wert1 = r.nextInt(5) - 2;
//        int wert2 = r.nextInt(5) - 2;
//
//        int torschuss = schuetze.getTorschuss() + wert1;
//        if (torschuss <= 0) {
//            torschuss = 1;
//
//        }
//        int reaktion = torwart.getReaktion() + wert2;
//        if (reaktion <= 0) {
//            reaktion = 1;
//        }
//        erzielttor = torschuss > reaktion;
//        return erzielttor;
//    }
//
//    public static void spielen(Spiel spiel) {
//        Random ran = new Random();
//
//        int zahl = ran.nextInt(nachspielzeit);
//        int spieldauer = spielzeit + zahl;
//
//        Mannschaft heim = spiel.getHeim();
//        int mannschaftsWertHeim = ermittelMannschaftsWert(heim);
//        Mannschaft gast = spiel.getGast();
//        int mannschaftsWertGast = ermittelMannschaftsWert(gast);
//
//        int summewert = mannschaftsWertHeim + mannschaftsWertGast;
//
//        Random ra = new Random();
//        int zahl3 = ra.nextInt(summewert);
//
//        if (zahl3 > mannschaftsWertHeim) {
//            ArrayList<Spieler> arrayListGast = gast.getSpielerListe();
//            Random random = new Random();
//            int index = random.nextInt(arrayListGast.size());
//            Spieler schuetze = arrayListGast.get(index);
//            Torwart torwart = heim.getTorwart();
//            boolean erzieltTor = erzieltTor(schuetze,torwart);
//            if (erzieltTor) {
//                Ergebnis ergebnis = new Ergebnis();
//                ergebnis.setTrefferGast();
//            }
//
//        } else {
//            ArrayList<Spieler> arrayListHeim = heim.getSpielerListe();
//            Random random1 = new Random();
//            int index1 = random1.nextInt(arrayListHeim.size());
//            Spieler schuetze = arrayListHeim.get(index1);
//            Torwart torwart = gast.getTorwart();
//            boolean erzieltTor = erzieltTor(schuetze, torwart);
//            if (erzieltTor){
//                Ergebnis ergebnis = new Ergebnis();
//                ergebnis.setTrefferHeim();
//            }
//        }
//
//    }
}
//
//