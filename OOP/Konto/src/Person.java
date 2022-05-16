public abstract class Person {
    private String vorname;
    private String nachname;
    private Adresse adresse;

    public Person(String vorname,String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return "Person\n" +
                "Vorname: " + vorname + "\n" +
                "Nachname: "+nachname + "\n\n"+
                "Adresse=\n" + adresse;
    }
}