package dao;

import businessObjects.Computerspiel;

import java.sql.*;
import java.util.ArrayList;

public class ComputerspieleDAO {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:SpieleSQL/src/data/SpieleNeu.db";
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

    private Computerspiel createObject(ResultSet resultSet) throws SQLException {
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
            computerspiel = new Computerspiel(name, genre, releaseDate, fsk, price);
            computerspiel.setRating(rating);
            computerspiel.setCondition(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computerspiel;
    }

    public void delete(int spielNr) {
        connection = null;
        preparedStatement = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE FROM Computerspiele WHERE spielNr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, spielNr);
            preparedStatement.executeUpdate();

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

    public void InsertInto(Computerspiel computerspiel) {
        connection = null;
        preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "INSERT INTO Computerspiele(name,genre,releaseDate,fsk,rating,price,condition)" +
                    "VALUES (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, computerspiel.getName());
            preparedStatement.setString(2, computerspiel.getGenre());
            preparedStatement.setString(3, computerspiel.getReleaseDate());
            preparedStatement.setInt(4, computerspiel.getFsk());
            preparedStatement.setString(5, computerspiel.getRating());
            preparedStatement.setDouble(6, computerspiel.getPrice());
            preparedStatement.setString(7, computerspiel.getCondition());
            preparedStatement.executeUpdate();
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

    public void update(int spielNr, Computerspiel computerspiel) {
        connection = null;
        preparedStatement = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "UPDATE Computerspiele SET name = ?,genre = ?,releaseDate = ?,fsk = ?,rating = ?, price = ?,condition = ? WHERE spielNr = ?" +
                    "VALUES (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, computerspiel.getName());
            preparedStatement.setString(2, computerspiel.getGenre());
            preparedStatement.setString(3, computerspiel.getReleaseDate());
            preparedStatement.setInt(4, computerspiel.getFsk());
            preparedStatement.setString(5, computerspiel.getRating());
            preparedStatement.setDouble(6, computerspiel.getPrice());
            preparedStatement.setString(7, computerspiel.getCondition());
            preparedStatement.setInt(8, spielNr);
            preparedStatement.executeUpdate();
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
}


