
import Conexao.Conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = Conexao.getConexao();
            if (conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
            Conexao.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}