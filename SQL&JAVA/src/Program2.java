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
        Ware ware = new Ware("Holz",100.99);
        ware.setBeschreibung("nass");
        wareDAO.InsertInto(ware);
        ArrayList<Ware> warenListe = new WareDAO().read();
        for (Ware w : warenListe) {
            System.out.println(w);
        }


    }
}
