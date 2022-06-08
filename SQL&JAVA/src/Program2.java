import Computerspiele.businessObjects.Vertragspartner;
import Computerspiele.businessObjects.Ware;
import dao.VertragspartnerDAO;
import dao.WareDAO;

import java.util.ArrayList;

public class Program2 {
    public static void main(String[] args) throws ClassNotFoundException {
        VertragspartnerDAO vertragspartnerDAO = new VertragspartnerDAO();
        ArrayList<Vertragspartner> vertragspartnerListe = new VertragspartnerDAO().read();

        Vertragspartner vertragspartnerNeu = vertragspartnerListe.get(0);
        vertragspartnerNeu.setVorname("Yannick");


        vertragspartnerDAO.update("0123456789",vertragspartnerNeu);

        for (Vertragspartner v : vertragspartnerListe) {
            System.out.println(v);
        }
        WareDAO wareDAO = new WareDAO();
        ArrayList<Ware> warenListe = new WareDAO().read();
        Ware wareNeu = warenListe.get(0);
        wareNeu.getMaengelListe().add("Kaputt");

        for (Ware w : warenListe) {
            System.out.println(w);
        }


    }
}
