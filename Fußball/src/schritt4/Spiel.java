package schritt4;

public class Spiel {
    private Mannschaft heim;
    private Mannschaft gast;
    private Ergebnis ergebnis;
    private StringBuilder spielverlauf;

    public Spiel(Mannschaft heim, Mannschaft gast, Ergebnis ergebnis){
        this.heim = heim;
        this.gast = gast;
        this.ergebnis = ergebnis;
        spielverlauf = new StringBuilder();

    }

    public Mannschaft getHeim() {
        return heim;
    }

    public Mannschaft getGast() {
        return gast;
    }

    public Ergebnis getErgebnis() {
        return ergebnis;
    }

    public StringBuilder getSpielverlauf() {
        return spielverlauf;
    }

    @Override
    public String toString() {
        return "\nSpielverlauf:\n" +getSpielverlauf();
    }
}
