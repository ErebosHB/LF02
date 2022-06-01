package dao;

import Computerspiele.businessObjects.Adresse;
import Computerspiele.businessObjects.Vertragspartner;


import java.sql.*;
import java.util.ArrayList;

public class VertragspartnerDAO {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:SQL&JAVA/src/data/Kaufvertrag.db";
    Connection connection = null;

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
            String sql = "SELECT * FROM Vertragspartner where ausweisNr = ?";
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


        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT * FROM Vertragspartner";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            vertragspartnerliste = new ArrayList<>();
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

    private Vertragspartner createObject(ResultSet resultSet) {
        Vertragspartner vertragspartner = null;
        try {
            String nr = resultSet.getString("ausweisNr");
            String vorname = resultSet.getString("vorname");
            String nachname = resultSet.getString("nachname");
            String strasse = resultSet.getString("strasse");
            String hausNr = resultSet.getString("hausNr");
            String plz = resultSet.getString("plz");
            String ort = resultSet.getString("ort");
            vertragspartner = new Vertragspartner(vorname, nachname);
            vertragspartner.setAusweisNr(nr);
            Adresse adresse = new Adresse(strasse, hausNr, plz, ort);
            vertragspartner.setAdresse(adresse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vertragspartner;
    }

    public void delete(String ausweisNr) {
        connection = null;
        PreparedStatement preparedStatement2 = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE FROM Vertragspartner WHERE ausweisNr =?";
            preparedStatement2 = connection.prepareStatement(sql);
            preparedStatement2.setString(1, ausweisNr);
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void InsertInto(Vertragspartner vertragspartner){
        connection = null;
        PreparedStatement preparedStatement3 = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "INSERT INTO Vertragspartner(ausweisNr,vorname,nachname,strasse,hausNr,plz,ort)"+
                    "VALUES(?,?,?,?,?,?,?)";
            preparedStatement3 = connection.prepareStatement(sql);
            preparedStatement3.setString(1,vertragspartner.getAusweisNr());
            preparedStatement3.setString(2,vertragspartner.getVorname());
            preparedStatement3.setString(3,vertragspartner.getNachname());
            preparedStatement3.setString(4,vertragspartner.getAdresse().getStrasse());
            preparedStatement3.setString(5,vertragspartner.getAdresse().getHausNr());
            preparedStatement3.setString(6,vertragspartner.getAdresse().getPlz());
            preparedStatement3.setString(7,vertragspartner.getAdresse().getOrt());
            preparedStatement3.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(String ausweisNr,Vertragspartner vertragspartner){
        connection = null;
        PreparedStatement preparedStatement4 = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "UPDATE Vertragspartner SET vorname = ?, nachname = ?, strasse = ?, hausNr = ?, plz = ?, ort = ? WHERE ausweisNr = ?";
            preparedStatement4 = connection.prepareStatement(sql);
            preparedStatement4.setString(1,vertragspartner.getVorname());
            preparedStatement4.setString(2,vertragspartner.getNachname());
            preparedStatement4.setString(3,vertragspartner.getAdresse().getStrasse());
            preparedStatement4.setString(4,vertragspartner.getAdresse().getHausNr());
            preparedStatement4.setString(5,vertragspartner.getAdresse().getPlz());
            preparedStatement4.setString(6,vertragspartner.getAdresse().getOrt());
            preparedStatement4.setString(7,ausweisNr);
            preparedStatement4.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}