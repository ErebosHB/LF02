import businessObjects.Computerspiel;
import dao.ComputerspieleDAO;

import java.util.ArrayList;

public class Test2 {
public static void main(String[]args) throws ClassNotFoundException{
        ComputerspieleDAO computerspieleDAO = new ComputerspieleDAO();
    System.out.println(computerspieleDAO.read(5).getSpielNr());
        }




}
