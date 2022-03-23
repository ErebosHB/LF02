
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;

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
        Cell header1 = new Cell();
        header1.add(new Paragraph("Kaufvertrag"));

        header1.setFontColor(ColorConstants.BLUE);
        header1.setBackgroundColor(ColorConstants.GRAY);
        header1.setTextAlignment(TextAlignment.CENTER);



        ListItem item1 = new ListItem("\n\n\nKäufer:\n");
        item1.setFontColor(ColorConstants.GREEN);
        item1.setFontSize(12);
        item1.setUnderline();
        List sublist1 = new List().setListSymbol("-");
        sublist1.add("Name: " + kaeufer.getVorname() + " " + kaeufer.getNachname() + "\n");
        sublist1.add("Ausweisnummer: " + kaeufer.getAusweisNr() + "\n");
        sublist1.add("Adresse: " + kaeufer.getAdresse().getStrasse() + " " + kaeufer.getAdresse().getHausNr() + ", " + kaeufer.getAdresse().getPlz() + " " + kaeufer.getAdresse().getOrt() + "\n");
        sublist1.setFontColor(ColorConstants.BLACK);
        sublist1.setFontSize(9);
        item1.add(sublist1);
        ListItem item2 = new ListItem("\n\nVerkäufer:\n");
        item2.setFontColor(ColorConstants.RED);
        item2.setFontSize(12);
        item2.setUnderline();
        List sublist2 = new List().setListSymbol("-");
        sublist2.add("Name: " + verkaeufer.getVorname() + " " + verkaeufer.getNachname() + "\n");
        sublist2.add("Ausweisnummer: " + verkaeufer.getAusweisNr() + "\n");
        sublist2.add("Adresse: "+ verkaeufer.getAdresse().getStrasse() + " " + verkaeufer.getAdresse().getHausNr() + ", " + verkaeufer.getAdresse().getPlz() + " " + verkaeufer.getAdresse().getOrt() + "\n");
        sublist2.setFontColor(ColorConstants.BLACK);
        sublist2.setFontSize(9);
        item2.add(sublist2);
        ListItem item3 = new ListItem("\n\nVerkaufte Ware:\n");
        item3.setFontColor(ColorConstants.BLUE);
        item3.setFontSize(12);
        item3.setUnderline();
        Table table = new Table(2);
        table.setTextAlignment(TextAlignment.LEFT);
        table.addCell("Text");
        table.addCell("Wert");
        table.addCell("Bezeichnung");
        table.addCell(ware.getBezeichnung());
        table.addCell("Beschreibung");
        table.addCell(ware.getBeschreibung());
        table.addCell("Preis");
        table.addCell(""+ware.getPreis());
        table.addCell("Besonderheiten");
        table.addCell(""+ware.getBesonderheiten());
        table.addCell("Mängel");
        table.addCell(""+ware.getMaengel());
        table.setFontSize(9);
        table.setFontColor(ColorConstants.BLACK);
        item3.add(table);
        Paragraph p1 = new Paragraph("\n\nZahlungsmodalitäten:");
        p1.setUnderline();
        p1.setFontSize(12);
        Paragraph p2 = new Paragraph(vertrag.getZahlungsModalitaeten());
        p2.setFontSize(9);

        document.add(header1);
        document.add(item1);
        document.add(item2);
        document.add(item3);
        document.add(p1);
        document.add(p2);
        document.close();


    }
}