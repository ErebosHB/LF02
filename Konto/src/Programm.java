public class Programm {
    public static void main(String[] args) {
        Adresse adresse = new Adresse("lehrer-lämpel-weg","bremen",28329,2);
        Mitarbeiter mitarbeiter = new Mitarbeiter("Phil","Jones");

        Kunde kunde = new Kunde("lucas","jones", mitarbeiter);
        kunde.setAdresse(adresse);
        Girokonto girokonto = new Girokonto(2, 10, kunde);
        girokonto.setKontostand(2000);
        Girokonto girokonto1 = new Girokonto(2, 2000, kunde);
        System.out.println(kunde);

        girokonto.ueberweisen(girokonto1, 200);
        System.out.println("neuer kotostand: "+girokonto1.getKontostand());
        if (girokonto.auszahlen(2000)){
            System.out.println(girokonto.getKontostand());
        }else{
            System.out.println("zu wenig geld zum auszahlen :(");
        }

    }
}
