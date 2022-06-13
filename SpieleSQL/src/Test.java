import businessObjects.Computerspiel;
import dao.ComputerspieleDAO;

import java.io.IOException;
import java.util.ArrayList;


public class Test {


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ComputerspieleDAO computerspieleDAO = new ComputerspieleDAO();
        ArrayList<Computerspiel> spieleListe = new ComputerspieleDAO().read();

        Boolean suiii = true;

        while (suiii) {

            Boolean ok = true;
            System.out.println("Welche Tabelle möchtest du ausführen?");
            System.out.println("[1] : Computerspiele");
            String tabellenAbfrage = IO.readstring();

            while (ok) {
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
                            Computerspiel computerspiel = new Computerspiel(name, genre, date, fsk, preis);
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

                            if (spaltenAbfrage.equals("1")) {
                                System.out.println("Bitte Namen des Spiels eingeben.");
                                String name = IO.readstring();
                                computerspieleDAO.update(name,computerspieleDAO.read(spielNr).getGenre(),computerspieleDAO.read(spielNr).getReleaseDate(),computerspieleDAO.read(spielNr).getFsk(),computerspieleDAO.read(spielNr).getRating(),computerspieleDAO.read(spielNr).getPrice(),computerspieleDAO.read(spielNr).getCondition(),spielNr);

                            } else {
                                if (spaltenAbfrage.equals("2")) {
                                    System.out.println("Bitte Genre des Spiels eingeben.");
                                    String genre = IO.readstring();
                                    computerspieleDAO.update(computerspieleDAO.read(spielNr).getName(),genre,computerspieleDAO.read(spielNr).getReleaseDate(),computerspieleDAO.read(spielNr).getFsk(),computerspieleDAO.read(spielNr).getRating(),computerspieleDAO.read(spielNr).getPrice(),computerspieleDAO.read(spielNr).getCondition(),spielNr);

                                } else if (spaltenAbfrage.equals("3")) {
                                    System.out.println("Bitte Erscheinungsdatum eingeben.");
                                    String date = IO.readstring();
                                    computerspieleDAO.update(computerspieleDAO.read(spielNr).getName(),computerspieleDAO.read(spielNr).getGenre(),date,computerspieleDAO.read(spielNr).getFsk(),computerspieleDAO.read(spielNr).getRating(),computerspieleDAO.read(spielNr).getPrice(),computerspieleDAO.read(spielNr).getCondition(),spielNr);

                                } else if (spaltenAbfrage.equals("4")) {
                                    System.out.println("Bitte Altersbeschränkung eingeben.");
                                    int fsk = IO.readInteger();
                                    computerspieleDAO.update(computerspieleDAO.read(spielNr).getName(),computerspieleDAO.read(spielNr).getGenre(),computerspieleDAO.read(spielNr).getReleaseDate(),fsk,computerspieleDAO.read(spielNr).getRating(),computerspieleDAO.read(spielNr).getPrice(),computerspieleDAO.read(spielNr).getCondition(),spielNr);

                                } else if (spaltenAbfrage.equals("5")) {
                                    System.out.println("Bitte Bewertung eingeben.");
                                    String bewertung = IO.readstring();
                                    computerspieleDAO.update(computerspieleDAO.read(spielNr).getName(),computerspieleDAO.read(spielNr).getGenre(),computerspieleDAO.read(spielNr).getReleaseDate(),computerspieleDAO.read(spielNr).getFsk(),bewertung,computerspieleDAO.read(spielNr).getPrice(),computerspieleDAO.read(spielNr).getCondition(),spielNr);

                                } else if (spaltenAbfrage.equals("6")) {
                                    System.out.println("Bitte Preis eingeben.");
                                    double preis = IO.readDouble();
                                    computerspieleDAO.update(computerspieleDAO.read(spielNr).getName(),computerspieleDAO.read(spielNr).getGenre(),computerspieleDAO.read(spielNr).getReleaseDate(),computerspieleDAO.read(spielNr).getFsk(),computerspieleDAO.read(spielNr).getRating(),preis,computerspieleDAO.read(spielNr).getCondition(),spielNr);

                                } else if (spaltenAbfrage.equals("7")) {
                                    System.out.println("Bitte Zustand angeben.");
                                    String zustand = IO.readstring();
                                    computerspieleDAO.update(computerspieleDAO.read(spielNr).getName(),computerspieleDAO.read(spielNr).getGenre(),computerspieleDAO.read(spielNr).getReleaseDate(),computerspieleDAO.read(spielNr).getFsk(),computerspieleDAO.read(spielNr).getRating(),computerspieleDAO.read(spielNr).getPrice(),zustand,spielNr);
                                }

                            }


                        } else if (aktionsAbfrage.equals("5")) {
                            System.out.println("Bitte SpielNr des Spiels eingeben, welches gelöscht werden soll.");
                            int nr = IO.readInteger();
                            computerspieleDAO.delete(nr);
                        }
                    }
                }

                System.out.println("Wollen sie weitere Aktionen durchführen?");
                String eingabe = IO.readstring();

                if (eingabe.equalsIgnoreCase("Nein") || eingabe.equalsIgnoreCase("n") || eingabe.equalsIgnoreCase("no")) {
                    ok = false;
                }
            }
            System.out.println("Wollen Sie eine andere Tabelle ausführen?");
            String tab = IO.readstring();
            if (tab.equalsIgnoreCase("Nein") || tab.equalsIgnoreCase("n") || tab.equalsIgnoreCase("no")) {
                suiii = false;
            }

        }
    }
}
