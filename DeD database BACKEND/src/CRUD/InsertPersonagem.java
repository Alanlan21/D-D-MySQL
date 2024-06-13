package CRUD;

import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPersonagem {

    public static void main(String[] args) {
        String sql = "INSERT INTO personagem (nome, nivel, pontos_vida, raca, alinhamento, id_jogador, id_classe) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Jorge");
            pstmt.setInt(2, 1); // Nível
            pstmt.setInt(3, 80); //                      Pontos de Vida
            pstmt.setString(4, "Hafling"); // Raça
            pstmt.setString(5, "Caotic neutral"); // Alinhamento
            pstmt.setInt(6, 2); // ID do Jogador
            pstmt.setInt(7, 7); // ID da Classe ---> 1 Bárbaro 2 Bardo 3 Bruxo 4 Clérigo 5 Druida 6 Guerreiro 7 Ladino 8 Mago 9 Paladino 10 Ranger


               // Executar a declaração SQL de inserção
               int rowsInserted = pstmt.executeUpdate();


               if (rowsInserted > 0) {
                   System.out.println("Um novo personagem foi inserido com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}