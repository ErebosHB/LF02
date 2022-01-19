public class Programm {
    public static void main(String[] args) {
        Trainer trainer = new Trainer("Hans");

        trainer.setAlter(65);
        trainer.setErfahrung(9);

        Spieler spieler = new Spieler("Messi");

        spieler.setAlter(34);
        spieler.setStaerke(6);
        spieler.setTorschuss(10);
        spieler.setMotivation(7);
        spieler.setTore(678);

        System.out.println(trainer);
        System.out.println();
        System.out.println(spieler);
    }
}
