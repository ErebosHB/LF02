import java.util.ArrayList;

public class Ware {
    private String bezeichnung;
    private String beschreibung;
    private double preis;
    private ArrayList<String> besonderheiten;
    private ArrayList<String> maengel;

    public Ware(String bezeichnung,double preis){
        besonderheiten = new ArrayList<String>();
        maengel = new ArrayList<String>();
        this.bezeichnung = bezeichnung;
        this.preis = preis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public ArrayList<String> getBesonderheiten() {
        return besonderheiten;
    }

    public ArrayList<String> getMaengel() {
        return maengel;
    }



    @Override
    public String toString() {
        return "\nBezeichnung: "+getBezeichnung()+
                "\nBeschreibung: "+getBeschreibung()+
                "\nBesonderheten: "+getBesonderheiten()+
                "\nMängel: "+getMaengel();
    }
}
