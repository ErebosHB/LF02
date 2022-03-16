import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Programm {
    public static void main(String[] args) throws FileNotFoundException {
        Vertragspartner kaeufer = new Vertragspartner("Theo","maximus");
        Adresse adresseKaeufer = new Adresse("Marx Straße","30","28279","Bremen");
        kaeufer.setAusweisNr("27777778");
        kaeufer.setAdresse(adresseKaeufer);

        Vertragspartner verkaeufer = new Vertragspartner("Markus","Söder");
        Adresse adresseVerkaeufer = new Adresse("Bayern Straße","3","12020","Nürnberg");
        verkaeufer.setAdresse(adresseVerkaeufer);
        verkaeufer.setAusweisNr("278980089 ");


        Ware ware = new Ware("Eisen",299.99);
        ware.getBesonderheiten().add("hochwertig");
        ware.getBesonderheiten().add("sauber");
        ware.getMaengel().add("stinkt");
        ware.getMaengel().add("alt");

        ware.setBeschreibung("Ist sehr Cool und hatte schon sehr viele Interessenten");

        Kaufvertrag kaufvertrag = new Kaufvertrag(verkaeufer,kaeufer,ware);
        kaufvertrag.setZahlungsModalitaeten("Visa");

        System.out.println(kaufvertrag);

        String datei = "H://Programmieren/Text/Kaufvertrag2.txt";
        PrintWriter writer = new PrintWriter(datei);
        writer.println(kaufvertrag);
        writer.close();
    }



}
