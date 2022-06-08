package dao;

import businessObjects.Computerspiel;

import java.sql.*;
import java.util.ArrayList;

public class ComputerspieleDAO {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:SpieleSQL/src/data/Spiele.db";
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public ComputerspieleDAO() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
    }

    public Computerspiel read(int spielNr) {
        Computerspiel computerspiel = null;
        connection = null;
        preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT * FROM Computerspiele where spielNr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, spielNr);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            computerspiel = createObject(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return computerspiel;
    }

    public ArrayList read() {
        ArrayList<Computerspiel> computerspieleListe = null;
        connection = null;
        preparedStatement = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT * FROM Computerspiele";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            computerspieleListe = new ArrayList<>();
            Computerspiel computerspiel = null;
            while (resultSet.next()) {
                computerspiel = createObject(resultSet);
                computerspieleListe.add(computerspiel);
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
        return computerspieleListe;
    }

    private Computerspiel createObject(ResultSet resultSet){
        Computerspiel computerspiel = null;
        try {
            int nr = resultSet.getInt("spielNr");
            String name = resultSet.getString("name");
            String genre = resultSet.getString("genre");
            String releaseDate = resultSet.getString("releaseDate");
            int fsk = resultSet.getInt("fsk");
            String rating = resultSet.getString("rating");
            double price = resultSet.getDouble("price");
            String condition = resultSet.getString("condition");
            computerspiel = new Computerspiel(name,genre,releaseDate,fsk,price);
            computerspiel.setRating(rating);
            computerspiel.setCondition(condition);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return computerspiel;
    }

    private void delete(int spielNr){
        connection = null;
        preparedStatement = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE FROM Computerspiele WHERE spielNr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,spielNr);

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

    private void insertInto(Computerspiel computerspiel){
        connection = null;
        preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "INSERT INTO Computerspiele (spielNr,name,genre,releaseDate,fsk,rating,price,condition)"+
                    "VALUES (?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,computerspiel.getSpielNr());
            preparedStatement.setString(2,computerspiel.getName());
            preparedStatement.setString(3,computerspiel.getGenre());
            preparedStatement.setString(4,computerspiel.getReleaseDate());
            preparedStatement.setInt(5,computerspiel.getFsk());
            preparedStatement.setString(6,computerspiel.getRating());
            preparedStatement.setDouble(7,computerspiel.getPrice());
            preparedStatement.setString(8,computerspiel.getCondition());
            preparedStatement.close();
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

