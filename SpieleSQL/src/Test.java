import businessObjects.Computerspiel;
import dao.ComputerspieleDAO;

import java.io.IOException;
import java.util.ArrayList;


public class Test {


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ComputerspieleDAO computerspieleDAO = new ComputerspieleDAO();
        ArrayList<Computerspiel> spieleListe = new ComputerspieleDAO().read();

        System.out.println("Welche Tabelle möchtest du ausführen?");
        System.out.println("[1] : Computerspiele");
        String tabellenAbfrage = IO.readstring();


        if (tabellenAbfrage.equals("1")) {
            System.out.println("Welche Aktion wollen Sie ausführen?");
            System.out.println("[1] : Anzeigen einer bestimmten Zeile");
            System.out.println("[2] : Anzeige aller gespeicherten Computerspiele");
            System.out.println("[3] : Erstelle Werte in Leere Cellen");
            System.out.println("[4] : Veränderung bestimmter Inhalte");
            System.out.println("[5] : Löschen von bestimmten Inhalten");
            String aktionsAbfrage = IO.readstring();
            if (aktionsAbfrage.equals("1")) {
                System.out.println("Bitte spielNr eingeben.");
                int spielNr = IO.readInteger();

                System.out.println(computerspieleDAO.read(spielNr));
            } else {
                if (aktionsAbfrage.equals("2")) {
                    spieleListe = new ComputerspieleDAO().read();
                    System.out.println(spieleListe);
                } else if (aktionsAbfrage.equals("3")) {
                    System.out.println("Bitte Namen des Spiels eingeben.");
                    String name = IO.readstring();
                    System.out.println("Bitte Genre des Spiels eingeben.");
                    String genre = IO.readstring();
                    System.out.println("Bitte Erscheinungsdatum eingeben.");
                    String date = IO.readstring();
                    System.out.println("Bitte Altersbeschränkung eingeben.");
                    int fsk = IO.readInteger();
                    System.out.println("Bitte Bewertung eingeben.");
                    String bewertung = IO.readstring();
                    System.out.println("Bitte Preis eingeben.");
                    double preis = IO.readDouble();
                    System.out.println("Bitte Zustand angeben.");
                    String zustand = IO.readstring();
                    Computerspiel computerspiel = new Computerspiel(name,genre,date,fsk,preis);
                    computerspiel.setRating(bewertung);
                    computerspiel.setCondition(zustand);
                    computerspieleDAO.InsertInto(computerspiel);

                } else if (aktionsAbfrage.equals("4")) {
                    System.out.println("Bitte spielNr eingeben.");
                    int spielNr = IO.readInteger();
                    System.out.println("Bitte Spalte angeben, die geändert werden soll.");
                    System.out.println("[1] : Name");
                    System.out.println("[2] : Genre");
                    System.out.println("[3] : Erscheinungsdatum");
                    System.out.println("[4] : FSK");
                    System.out.println("[5] : Bewertung");
                    System.out.println("[6] : Preis");
                    System.out.println("[7] : Zustand");
                    String spaltenAbfrage = IO.readstring();

                    if (spaltenAbfrage.equals("1")){
                        System.out.println("Bitte Namen des Spiels eingeben.");
                        String name = IO.readstring();
                        for (Computerspiel c:spieleListe) {
                            if (c.getSpielNr() == spielNr){
                                c.setName(name);
                                computerspieleDAO.update(spielNr,c);
                            }
                        }
                    }
                    else {
                        if (spaltenAbfrage.equals("2")){
                            System.out.println("Bitte Genre des Spiels eingeben.");
                            String genre = IO.readstring();
                            for (Computerspiel c:spieleListe) {
                                if (c.getSpielNr() == spielNr){
                                    c.setGenre(genre);
                                    computerspieleDAO.update(spielNr,c);
                                }
                            }
                        }
                        else if (spaltenAbfrage.equals("3")){
                            System.out.println("Bitte Erscheinungsdatum eingeben.");
                            String date = IO.readstring();
                            for (Computerspiel c:spieleListe) {
                                if (c.getSpielNr() == spielNr){
                                    c.setReleaseDate(date);
                                    computerspieleDAO.update(spielNr,c);
                                }
                            }
                        }
                        else if (spaltenAbfrage.equals("4")){
                            System.out.println("Bitte Altersbeschränkung eingeben.");
                            int fsk = IO.readInteger();
                            for (Computerspiel c:spieleListe) {
                                if (c.getSpielNr() == spielNr){
                                    c.setFsk(fsk);
                                    computerspieleDAO.update(spielNr,c);
                                }
                            }
                        }
                        else if (spaltenAbfrage.equals("5")){
                            System.out.println("Bitte Bewertung eingeben.");
                            String bewertung = IO.readstring();
                            for (Computerspiel c:spieleListe) {
                                if (c.getSpielNr() == spielNr){
                                    c.setRating(bewertung);
                                    computerspieleDAO.update(spielNr,c);
                                }
                            }
                        }
                        else if (spaltenAbfrage.equals("6")){
                            System.out.println("Bitte Preis eingeben.");
                            double preis = IO.readDouble();
                            for (Computerspiel c:spieleListe) {
                                if (c.getSpielNr() == spielNr){
                                    c.setPrice(preis);
                                    computerspieleDAO.update(spielNr,c);
                                }
                            }
                        }
                        else if (spaltenAbfrage.equals("7")){
                            System.out.println("Bitte Zustand angeben.");
                            String zustand = IO.readstring();
                            for (Computerspiel c:spieleListe) {
                                if (c.getSpielNr() == spielNr){
                                    c.setCondition(zustand);
                                    computerspieleDAO.update(spielNr,c);
                                }
                            }
                        }

                    }


                } else if (aktionsAbfrage.equals("5")) {

                }
            }
        }

    }
}
