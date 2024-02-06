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

    public List<PontosOnibus> getPrevisao(int pontoId) {
        List<PontosOnibus> pontos = new ArrayList<>();
        String querySelect = "SELECT * FROM pontos_onibus po JOIN linhas_onibus lo on po.linhaId = lo.id ORDER BY po.minPrevisao DESC WHERE po.id = ?;";

        try {
            Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(querySelect);
            preparedStatement.setInt(1, pontoId);
            
            ResultSet rs = preparedStatement.executeQuery(querySelect);

            while (rs.next()) {
                PontosOnibus po = new PontosOnibus();
                po.setId(rs.getInt("po.id"));
                po.setMin_previsao(rs.getInt("po.minPrevisao"));
                
                po.setLinha_id(rs.getInt("lo.id"));
                LinhaOnibus linha = new LinhaOnibus();
                linha.setId(rs.getInt("lo.id"));
                linha.setNome(rs.getString("lo.nome"));
                po.setLinha(linha);

                pontos.add(po);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pontos;
    }
}
