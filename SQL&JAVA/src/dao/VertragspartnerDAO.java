package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import java.sql.*;

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

            //resultset auswerten

            String nr = resultSet.getString("ausweisNr");
            String vorname = resultSet.getString("vorname");
            String nachname = resultSet.getString("nachname");
            String strasse = resultSet.getString("strasse");
            String hausNr = resultSet.getString("hausNr");
            String plz = resultSet.getString("plz");
            String ort = resultSet.getString("ort");

            //Vertragspartner erstellen
            vertragspartner = new Vertragspartner(vorname, nachname);
            vertragspartner.setAusweisNr(nr);
            Adresse adresse = new Adresse(strasse, hausNr, plz, ort);
            vertragspartner.setAdresse(adresse);
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