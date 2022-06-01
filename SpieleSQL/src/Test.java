import businessObjects.Computerspiel;
import dao.ComputerspieleDAO;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        ComputerspieleDAO computerspieleDAO = new ComputerspieleDAO();
        ArrayList<Computerspiel> computerspielListe = new ComputerspieleDAO().read();

        for (Computerspiel c:computerspielListe) {
            System.out.println(c);

        }
    }
}
