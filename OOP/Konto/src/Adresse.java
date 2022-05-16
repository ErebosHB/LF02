public class Adresse {
    private String postleitzahl;
    private String hausnummer;
    private String ort;
    private String strasse;

    public Adresse(String strasse, String ort, String postleitzahl, String hausnummer){
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.postleitzahl = postleitzahl;
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    @Override
    public String toString() {
        return "postleitzahl: " + postleitzahl +
                "\nhausnummer: " + hausnummer +
                "\nort: " + ort +
                "\nstrasse: " + strasse + "\n";
    }
}
