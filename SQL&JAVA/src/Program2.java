import businessObjects.Vertragspartner;
import businessObjects.Ware;
import dao.VertragspartnerDAO;
import dao.WareDAO;

import java.util.ArrayList;

public class Program2 {
    public static void main(String[] args) throws ClassNotFoundException {
        VertragspartnerDAO vertragspartnerDAO = new VertragspartnerDAO();
        ArrayList<Vertragspartner> vertragspartnerListe = new VertragspartnerDAO().read();

        vertragspartnerDAO.update("0123456789");

        for (Vertragspartner v : vertragspartnerListe) {
            System.out.println(v);
        }
        WareDAO wareDAO = new WareDAO();
        ArrayList<Ware> warenListe = new WareDAO().read();
        for (Ware w : warenListe) {
            System.out.println(w);
        }


    }
}
