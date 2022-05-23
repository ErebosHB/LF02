package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import java.sql.*;
import java.util.ArrayList;

public class VertragspartnerDAO {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:KaufvertragMitDAO/src/data/Kaufvertrag.db";

    public VertragspartnerDAO() throws ClassNotFoundException {
        Class.forName(CLASSNAME);

    }


    /**
     * liest einen vertragspartner auf basis seiner ausweisnumer
     *
     * @param ausweisNr die ausweisNr
     * @return der gewünschte vertragspartner
     */


    public Vertragspartner read(String ausweisNr) {
        Vertragspartner vertragspartner = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //  Verbindung zu Datenbank herstellen

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);

            //SQL Abfrage erstellen
            String sql = "SELECT * FROM vertragspartner where ausweisNr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ausweisNr);


            //SQL abfrage ausführen
           ResultSet resultSet = preparedStatement.executeQuery();

            //zeiger auf den ersten datensatz setzen
            resultSet.next();


            vertragspartner = createObject(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vertragspartner;
    }
    public ArrayList read() {

        ArrayList<Vertragspartner> vertragspartnerliste = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Verbindung zu Datenbank herstellen


        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            //SQL-Abfrage erstellen
            String sql = "SELECT * FROM Vertragspartner";
            preparedStatement = connection.prepareStatement(sql);
            // SQL Abfrage auführen
            ResultSet resultSet = preparedStatement.executeQuery();
            vertragspartnerliste = new ArrayList<>();
            // Zeiger auf den ersten Datensatz setzen
            Vertragspartner vertragspartner = null;
            while (resultSet.next()) {
                vertragspartner = createObject(resultSet);
                vertragspartnerliste.add(vertragspartner);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return vertragspartnerliste;

    }
    private Vertragspartner createObject(ResultSet resultSet){
        Vertragspartner vertragspartner = null;
        try {
            String nr = resultSet.getString("ausweisNr");
            String vorname = resultSet.getString("vorname");
            String nachname = resultSet.getString("nachname");
            String strasse = resultSet.getString("strasse");
            String hausNr = resultSet.getString("hausNr");
            String plz = resultSet.getString("plz");
            String ort = resultSet.getString("ort");vertragspartner = new Vertragspartner(vorname, nachname);
            vertragspartner.setAusweisNr(nr);
            Adresse adresse = new Adresse(strasse, hausNr, plz, ort);
            vertragspartner.setAdresse(adresse);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return vertragspartner;
    }
}