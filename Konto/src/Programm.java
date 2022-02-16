public class Programm {

    public static void main(String[] args) {
        Adresse adresseMitarbeiter = new Adresse("Schlossallee", "2", "04711", "Entenhausen");
        Adresse adresseKunde = new Adresse("ParkstraÃŸe", "36a", "12345", "Buxtehude");

        Mitarbeiter mitarbeiter = new Mitarbeiter("Holger", "Geldfuchs");

        Kunde kunde1 = new Kunde("Klaus", "Sparbier", mitarbeiter, adresseKunde);
        Kunde kunde2 = new Kunde("Volker", "Vielgeld", mitarbeiter, adresseKunde);
        kunde1.setMitarbeiter(mitarbeiter);

        Girokonto girokonto1 = new Girokonto(15.0,10000,kunde1);
        Girokonto girokonto2 = new Girokonto(15.0,10000,kunde2);
        Sparkonto sparkonto1 = new Sparkonto(10,kunde1);

        System.out.println(mitarbeiter);
        System.out.println(kunde1);
        System.out.println(kunde2);
        System.out.println(girokonto1);
        System.out.println(girokonto2);
        System.out.println(sparkonto1);
        System.out.println("--------------------");

        if (girokonto1.einzahlen(2000.0)) {
            System.out.println(girokonto1);
        } else {
            System.out.println("Fehler beim Einzahlen: Einzahlbetrag ist kleiner 0");
        }

        if (girokonto1.auszahlen(20.0)) {
            System.out.println(girokonto1);
        } else {
            System.out.println("Fehler beim Auszahlen: Guthaben und Kreditlimit kleiner als Auszahlbetrag");
        }

        if (girokonto1.ueberweisen(girokonto2,10.0)) {
            System.out.println(girokonto2);
            System.out.println(girokonto1);
        } else {
            System.out.println("Fehler beim Ãœberweisen");
        }

        System.out.println("--------------------");
        System.out.println("---- Ãœberweisung ---");
        if (girokonto2.auszahlen(200.0)) {
            System.out.println(girokonto2);
        } else {
            System.out.println("Fehler beim Auszahlen: Guthaben und Kreditlimit kleiner als Auszahlbetrag");
        }
        System.out.println("--------------------");

        if (girokonto1.ueberweisen(girokonto2,1.0)) {
            System.out.println(girokonto1);
        } else {
            System.out.println("Fehler beim Ãœberweisen");
        }

    }

}

