public class Kunde extends Person {
    private Mitarbeiter mitarbeiter;
    public Kunde(String vorname,String nachname, Mitarbeiter mitarbeiter,Adresse adresse){
        super(vorname,nachname);
        this.mitarbeiter = mitarbeiter;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    @Override
    public String toString() {
        return super.toString()+ mitarbeiter;
    }
}