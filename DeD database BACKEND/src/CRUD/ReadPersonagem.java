package CRUD;

import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadPersonagem {

    public static void main(String[] args) {
        String sql = "SELECT * FROM personagem";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_personagem");
                String nome = rs.getString("nome");
                int nivel = rs.getInt("nivel");
                int pontosVida = rs.getInt("pontos_vida");
                String raca = rs.getString("raca");
                String alinhamento = rs.getString("alinhamento");
                int idJogador = rs.getInt("id_jogador");
                int idClasse = rs.getInt("id_classe");

                System.out.printf("ID: %d, Nome: %s, Nível: %d, Pontos de Vida: %d, Raça: %s, Alinhamento: %s, ID do Jogador: %d, ID da Classe: %d%n",
                        id, nome, nivel, pontosVida, raca, alinhamento, idJogador, idClasse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
