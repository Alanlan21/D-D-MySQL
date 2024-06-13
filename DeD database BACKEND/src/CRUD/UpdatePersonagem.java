package CRUD;

import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePersonagem {

    public static void main(String[] args) {
        String sql = "UPDATE personagem SET nivel = ?, pontos_vida = ? WHERE id_personagem = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, 20); // Novo Nível
            pstmt.setInt(2, 4350); // Novos Pontos de Vida
            pstmt.setInt(3, 7); // ID do Personagem



            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("O personagem foi atualizado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
