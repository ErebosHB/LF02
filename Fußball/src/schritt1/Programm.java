package schritt1;

import schritt2.Torwart;
import schritt4.Ergebnis;
import schritt4.Mannschaft;
import schritt4.Spiel;

import java.util.ArrayList;

public class Programm {
    public static void main(String[] args) {
        Trainer trainer1 = new Trainer("Xavi", 43, 7);
        Spieler spieler1 = new Spieler("Messi", 34, 6, 10, 7, 678);
        Spieler spieler2 = new Spieler("De Jong", 24, 7, 4, 7, 10);
        Spieler spieler3 = new Spieler("Dest", 21, 5, 3, 4, 3);
        Torwart torwart1 = new Torwart("Ter Stegen", 29, 7, 7, 9);

        ArrayList spielerlisteheim = new ArrayList();
        spielerlisteheim.add(spieler1);
        spielerlisteheim.add(spieler2);
        spielerlisteheim.add(spieler3);

        Mannschaft mannschaft1 = new Mannschaft("Heim", trainer1, torwart1, spielerlisteheim);

        Trainer trainer2 = new Trainer("Ancelotti", 63, 9);
        Spieler spieler4 = new Spieler("Kroos", 33, 8, 6, 7, 30);
        Spieler spieler5 = new Spieler("Mendy", 24, 6, 2, 6, 2);
        Spieler spieler6 = new Spieler("Mariano", 26, 4, 5, 3, 15);
        Torwart torwart2 = new Torwart("Courtois", 30, 7, 7, 8);

        ArrayList spielerlistegast = new ArrayList();
        spielerlistegast.add(spieler4);
        spielerlistegast.add(spieler5);
        spielerlistegast.add(spieler6);

        Mannschaft mannschaft2 = new Mannschaft("Gast", trainer2, torwart2, spielerlistegast);

        Ergebnis ergebnis = new Ergebnis();
        ergebnis.setTrefferGast();

        Spiel spiel = new Spiel(mannschaft1,mannschaft2,ergebnis);




        System.out.println(trainer1);
        System.out.println();
        System.out.println(spielerlisteheim);
        System.out.println(torwart1);
        System.out.println();
        System.out.println(mannschaft1);
        System.out.println("=====================================================");
        System.out.println(trainer2);
        System.out.println();
        System.out.println(spielerlistegast);
        System.out.println(torwart2);
        System.out.println();
        System.out.println(mannschaft2);
        System.out.println("=====================================================");
        System.out.println(ergebnis);
        System.out.println(spiel);
    }
}
