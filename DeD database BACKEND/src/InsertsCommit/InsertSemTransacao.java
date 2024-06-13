package InsertsCommit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class InsertSemTransacao {

    public static void main(String[] args) {
        inserirSemTransacao();
    }

    public static void inserirSemTransacao() {
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Início da inserção sem transação: " + startTime);

        String sql = "INSERT INTO teste (valor) VALUES (?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/ded", "root", "root")) {

            for (int i = 0; i < 10000; i++) {
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, "Valor " + i);
                    pstmt.executeUpdate();
                    System.out.println( i );
                } catch (SQLException e) {

                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe informações sobre a exceção
        }

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Término da inserção sem transação: " + endTime);
    }
}
