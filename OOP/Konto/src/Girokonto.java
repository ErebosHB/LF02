public class Girokonto extends Konto{

    public Girokonto(double zinssatz,int kreditlimit, Kunde kunde){
        super(zinssatz, kreditlimit, kunde);
    }
    public void ueberweisen(Girokonto zuUeberweisendes, double betrag) {
        if (auszahlen(betrag)) {
            zuUeberweisendes.einzahlen(betrag);
        }
    }
}



