package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LinhaOnibus;
import model.PontosOnibus;

public class PontosOnibusDAO {
    private String connection = "jdbc:postgresql://localhost:5432/mp2";
    private String user = "postgres", pass = "123456";

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

    public List<PontosOnibus> getPrevisao(int pontoId) {
        List<PontosOnibus> pontos = new ArrayList<>();
        String querySelect = "SELECT po.*, l.nome FROM pontos_onibus po JOIN linha l on po.linhaId = l.id WHERE po.id = ? ORDER BY po.minPrevisao DESC;";

        try {
            Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(querySelect);
            preparedStatement.setInt(1, pontoId);
            
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PontosOnibus po = new PontosOnibus();
                po.setId(rs.getInt("id"));
                po.setMin_previsao(rs.getInt("minprevisao"));
                
                po.setLinha_id(rs.getInt("linhaid"));
                LinhaOnibus linha = new LinhaOnibus();
                linha.setId(rs.getInt("linhaid"));
                linha.setNome(rs.getString("nome"));
                po.setLinha(linha);

                pontos.add(po);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pontos;
    }
}
