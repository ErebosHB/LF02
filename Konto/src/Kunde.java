public class Kunde extends Person {
    private Mitarbeiter mitarbeiter;
    public Kunde(String vorname,String nachname, Mitarbeiter mitarbeiter){
        super(vorname,nachname);
        this.mitarbeiter = mitarbeiter;
    }

    @Override
    public String toString() {
        return super.toString()+ mitarbeiter;
    }
}