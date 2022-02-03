package schritt1;

import schritt2.Torwart;
import schritt4.Ergebnis;
import schritt4.Mannschaft;
import schritt4.Spiel;
import schritt5.Gameplay;

import java.util.ArrayList;

public class Programm {
    public static void main(String[] args) {
        Trainer trainer1 = new Trainer("Xavi", 43, 7);
        Spieler spieler1 = new Spieler("Messi", 34, 10, 10, 10, 678);
        Spieler spieler2 = new Spieler("De Jong", 24, 10, 10, 10, 10);
        Spieler spieler3 = new Spieler("Dest", 21, 10, 10, 10, 3);
        Torwart torwart1 = new Torwart("Ter Stegen", 29, 10, 10, 10);

        ArrayList<Spieler> spielerlisteheim = new ArrayList<>();
        spielerlisteheim.add(spieler1);
        spielerlisteheim.add(spieler2);
        spielerlisteheim.add(spieler3);

        Mannschaft mannschaft1 = new Mannschaft("Fc Barcelona", trainer1, torwart1, spielerlisteheim);

        Trainer trainer2 = new Trainer("Ancelotti", 63, 7);
        Spieler spieler4 = new Spieler("Kroos", 33, 10, 10, 10, 30);
        Spieler spieler5 = new Spieler("Mendy", 24, 10, 10, 10, 2);
        Spieler spieler6 = new Spieler("Mariano", 26, 10, 10, 10, 15);
        Torwart torwart2 = new Torwart("Courtois", 30, 10, 10, 10);

        ArrayList<Spieler> spielerlistegast = new ArrayList<>();
        spielerlistegast.add(spieler4);
        spielerlistegast.add(spieler5);
        spielerlistegast.add(spieler6);

        Mannschaft mannschaft2 = new Mannschaft("Real Madrid", trainer2, torwart2, spielerlistegast);
        Ergebnis ergebnis = new Ergebnis();

        Spiel spiel = new Spiel(mannschaft1,mannschaft2,ergebnis);
        Gameplay gameplay = new Gameplay();

        gameplay.spielen(spiel);






        System.out.println(mannschaft1);
        System.out.println("=====================================================");
        System.out.println(mannschaft2);
        System.out.println("=====================================================");
        System.out.println(spiel);
    }
}
