package dao;

import businessObjects.Ware;

import java.sql.*;

public class WareDAO {
        private final String CLASSNAME = "org.sqlite.JDBC";
        private final String CONNECTIONSTRING = "jdbc:sqlite:KaufvertragMitDAO/src/data/Kaufvertrag.db";

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
    }

