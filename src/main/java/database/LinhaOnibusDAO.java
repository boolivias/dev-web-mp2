package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LinhaOnibus;

public class LinhaOnibusDAO {
    private String connection = "jdbc:postgresql://localhost:5432/mp2";
    private String user = "postgres", pass = "";

    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(connection, user, pass);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public List<LinhaOnibus> getLinhas() {
        String querySelect = "SELECT * FROM linhas_onibus;";
        List<LinhaOnibus> linhas = new ArrayList<>();

        try {
            Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(querySelect);
            
            ResultSet rs = preparedStatement.executeQuery(querySelect);

            while (rs.next()) {
                LinhaOnibus linha = new LinhaOnibus();
                linha.setId(rs.getInt("id"));
                linha.setNome(rs.getString("nome"));
                linha.setGastoPorKm(rs.getDouble("gastoPorKm"));
                linha.setLotacao(rs.getInt("lotacao"));

                linhas.add(linha);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return linhas;
    }
}
