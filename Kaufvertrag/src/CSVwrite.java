
import java.io.*;

public class CSVwrite {
    public static void main(String[] args) throws FileNotFoundException {


        Vertragspartner kaeufer = new Vertragspartner("Klaus", "Brandt");

        kaeufer.setAusweisNr("0123456789");
        kaeufer.setAdresse(new Adresse("Zu Hause", "3a", "28199", "Bremen"));

        Vertragspartner verkaeufer = new Vertragspartner("Joachim", "Bredull");
        verkaeufer.setAusweisNr("9876543210");
        verkaeufer.setAdresse(new Adresse("Auch zu Hause", "7", "28195", "Bremen"));


        String datei = "H://Programmieren/CSV/Kaufvertrag.csv";
        PrintWriter writer = new PrintWriter(datei);
        writer.println("Vertragspartner;Name;Straße;PLZ;Ort;");
        writer.println("Käufer;"+kaeufer.getNachname()+", "+ kaeufer.getVorname()+";"+ kaeufer.getAdresse().getStrasse()+" "+ kaeufer.getAdresse().getHausNr()+";"+kaeufer.getAdresse().getPlz()+";"+kaeufer.getAdresse().getOrt());
        writer.println("Verkäufer;"+verkaeufer.getNachname()+", "+ verkaeufer.getVorname()+";"+ verkaeufer.getAdresse().getStrasse()+" "+ verkaeufer.getAdresse().getHausNr()+";"+verkaeufer.getAdresse().getPlz()+";"+verkaeufer.getAdresse().getOrt());
        writer.close();
    }
}
