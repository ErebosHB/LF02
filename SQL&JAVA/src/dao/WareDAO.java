package dao;

import businessObjects.Vertragspartner;
import businessObjects.Ware;

import java.sql.*;
import java.util.ArrayList;

public class WareDAO {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:SQL&JAVA/src/data/Kaufvertrag.db";
    private Connection connection;

    public WareDAO() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
    }

    public Ware read(int warenNr) {
        Ware ware = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT * FROM ware where warenNr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, warenNr);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            ware = createObject(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ware;
    }

    public ArrayList<Ware> read() {
        ArrayList<Ware> warenListe = null;
        connection = null;
        PreparedStatement preparedStatement1 = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "Select * From Ware";
            preparedStatement1 = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement1.executeQuery();
            warenListe = new ArrayList<>();
            Ware ware = null;
            while (resultSet.next()) {
                ware = createObject(resultSet);
                warenListe.add(ware);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return warenListe;
    }

    public Ware createObject(ResultSet resultSet) throws SQLException {
        String bezeichnung = resultSet.getString("bezeichnung");
        String beschreibung = resultSet.getString("beschreibung");
        double preis = resultSet.getDouble("preis");
        String besonderheiten = resultSet.getString("besonderheiten");
        String maengel = resultSet.getString("maengel");

        Ware ware = new Ware(bezeichnung, preis);
        ware.setBeschreibung(beschreibung);

        if (maengel != null) {
            String[] maengelListe = maengel.split(";");

            for (String s : maengelListe) {
                ware.getMaengelListe().add(s.trim());

            }
        }

        if (besonderheiten != null) {
            String[] besonderheitenListe = besonderheiten.split(";");

            for (String s : besonderheitenListe) {
                ware.getBesonderheitenListe().add(s.trim());
            }
        }
        return ware;
    }

    public void delete(int warenNr) {
        connection = null;
        PreparedStatement preparedStatement2 = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE FROM Ware WHERE warenNr =?";
            preparedStatement2 = connection.prepareStatement(sql);
            preparedStatement2.setInt(1, warenNr);
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
    private String mapListToString(ArrayList<String> arrayList){
        String semicolonSeparetedString = "";
        for (String s : arrayList) {
            if (semicolonSeparetedString.isEmpty()){
                semicolonSeparetedString = s;
            }
            else {
                semicolonSeparetedString += "; "+s;
            }
        }
        return semicolonSeparetedString;
    }

    public void InsertInto(Ware ware){
        connection = null;
        PreparedStatement preparedStatement3 = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "INSERT INTO WAREN(bezeichnung,beschreibung,preis,besonderheiten,maengel)"+
                    "VALUES(?,?,?,?,?)";
            preparedStatement3 = connection.prepareStatement(sql);
            preparedStatement3.setString(1,ware.getBezeichnung());
            preparedStatement3.setString(2,ware.getBeschreibung());
            preparedStatement3.setDouble(3,ware.getPreis());
            preparedStatement3.setString(4,mapListToString(ware.getBesonderheitenListe()));
            preparedStatement3.setString(5,mapListToString(ware.getMaengelListe()));
            preparedStatement3.executeUpdate();

            ResultSet resultSet = preparedStatement3.getGeneratedKeys();
            resultSet.next();

            ware.setWarenNr(resultSet.getInt("last_insert_rowid()"));
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

