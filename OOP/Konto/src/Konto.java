public abstract class Konto {
    private double kontostand;
    private double zinssatz;
    private int kreditlimit;
    private Kunde kunde;

    public Konto(double zinssatz, int kreditlimit, Kunde kunde) {
        this.kontostand = 0;
        this.zinssatz = zinssatz;
        this.kreditlimit = kreditlimit;
        this.kunde = kunde;
    }

    public double getKontostand() {
        return kontostand;
    }

    public double getZinssatz() {
        return zinssatz;
    }

    public int getKreditlimit() {
        return kreditlimit;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public void setKreditlimit(int kreditlimit) {
        this.kreditlimit = kreditlimit;
    }

    public void setZinssatz(double zinssatz) {
        this.zinssatz = zinssatz;
    }

    public boolean auszahlen(double betrag) {
        if (kontostand - betrag >= -kreditlimit) {
            kontostand -= betrag;
            return true;
        } else {
            return false;
        }
    }

    public void einzahlen(double betrag) {
        kontostand += betrag;
    }

    public void verzinsen() {
        kontostand += kontostand * zinssatz;
    }

    @Override
    public String toString() {
        return "Konto{" +
                "kontostand=" + kontostand +
                ", zinssatz=" + zinssatz +
                ", kreditlimit=" + kreditlimit +
                ", kunde=" + kunde +
                '}';
    }
}

