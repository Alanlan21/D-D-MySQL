package InsertsCommit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class InsertComTransacao {

    public static void main(String[] args) {
        inserirComTransacao();
    }

    public static void inserirComTransacao() {
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Início da inserção com transação: " + startTime);

        String sql = "INSERT INTO teste (valor) VALUES (?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/ded", "root", "root");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            for (int i = 0; i < 10000; i++) {
                pstmt.setString(1, "Valor " + i);
                pstmt.executeUpdate();
                System.out.println( i );
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Término da inserção com transação: " + endTime);
    }
}
