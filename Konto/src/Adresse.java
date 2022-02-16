public class Adresse {
    private int postleitzahl;
    private int hausnummer;
    private String ort;
    private String strasse;

    public Adresse(String strasse, String ort, int postleitzahl, int hausnummer){
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.postleitzahl = postleitzahl;
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setPostleitzahl(int postleitzahl) {
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
