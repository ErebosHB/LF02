package schritt1;

import schritt2.Torwart;

public class Programm {
    public static void main(String[] args) {
        Trainer trainer = new Trainer("Xavi",43,7);

        Spieler spieler = new Spieler("Messi",34,6,10,7,678);

        Torwart torwart = new Torwart("Ter Stegen",29,7,7,9);







        System.out.println(trainer);
        System.out.println();
        System.out.println(spieler);
        System.out.println();
        System.out.println(torwart);
        System.out.println();
    }
}
