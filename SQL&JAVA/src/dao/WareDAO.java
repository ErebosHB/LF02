package dao;

import businessObjects.Ware;

import java.sql.*;
import java.util.ArrayList;

public class WareDAO {
        private final String CLASSNAME = "org.sqlite.JDBC";
        private final String CONNECTIONSTRING = "jdbc:sqlite:KaufvertragMitDAO/src/data/Kaufvertrag.db";
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
            ResultSet resultSet;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return warenListe;
    }

        private Ware createObject(ResultSet resultSet){
            Ware ware = null;
            connection = null;
            try {
                String bezeichnung = resultSet.getString("bezeichnung");
                String beschreibung = resultSet.getString("beschreibung");
                Double preis = resultSet.getDouble("preis");
                String besonderheiten = resultSet.getString("besonderheiten");
                String maengel = resultSet.getString("maengel");
                ware = new Ware(bezeichnung, preis);
                ware.setBeschreibung(beschreibung);

                if (besonderheiten != null) {
                    String[] besonderheitenArray = besonderheiten.split(";");
                    for (String b : besonderheitenArray) {
                        ware.getBesonderheitenListe().add(b.trim());
                    }
                }
                if (maengel != null) {
                    String[] maengelArray = maengel.split(";");
                    for (String m : maengelArray) {
                        ware.getMaengelListe().add(m.trim());
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return ware;
        }

        public
    }

