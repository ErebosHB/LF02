
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;


public class KaufvertragPdf {
    public static void main(String[] args) throws FileNotFoundException {
        Ware ware = new Ware("Laptop", 250.0);
        ware.setBeschreibung("Super krasses Gaming-Laptop");
        ware.getBesonderheiten().add("Tasche");
        ware.getBesonderheiten().add("Gaming-Maus");
        ware.getMaengel().add("Ladekabel fehlt");
        ware.getMaengel().add("Touchpad defekt");

        Vertragspartner kaeufer = new Vertragspartner("Klaus", "Brandt");
        kaeufer.setAusweisNr("0123456789");
        kaeufer.setAdresse(new Adresse("Zu Hause", "3a", "28199", "Bremen"));

        Vertragspartner verkaeufer = new Vertragspartner("Joachim", "Bredull");
        verkaeufer.setAusweisNr("9876543210");
        verkaeufer.setAdresse(new Adresse("Auch zu Hause", "7", "28195", "Bremen"));

        Kaufvertrag vertrag = new Kaufvertrag(verkaeufer, kaeufer, ware);
        vertrag.setZahlungsModalitaeten("Privater Barverkauf");


        String datei = "H://Programmieren//Kaufvertrag PDF/Datei.pdf";
        PdfWriter writer = new PdfWriter(datei);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        Paragraph p1 = new Paragraph();

        p1.add(new Cell());

        document.setFontColor(ColorConstants.BLUE);
        p1.add(verkaeufer.getVorname()+" "+verkaeufer.getNachname()+"\n");
        p1.add(verkaeufer.getAdresse().getStrasse()+" "+verkaeufer.getAdresse().getHausNr()+"\n");
        p1.add(verkaeufer.getAdresse().getPlz()+" "+verkaeufer.getAdresse().getOrt()+"\n");



        document.add(p1);
        document.close();


    }
}