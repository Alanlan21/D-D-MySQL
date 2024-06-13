package CRUD;

import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePersonagem {

    public static void main(String[] args) {
        String sql = "DELETE FROM personagem WHERE id_personagem = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, 6); // ID do Personagem a ser deletado


                 int rowsDeleted = pstmt.executeUpdate();
                 if (rowsDeleted > 0) {
                     System.out.println("O personagem foi deletado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
