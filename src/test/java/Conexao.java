import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    public static void main(String[] args) throws SQLException {
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/world", System.getenv("USERBD"), System.getenv("PASS_MYSQL"));
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM city limit 20");
            while (rsCliente.next())
            {
                System.out.println("Nome: " + rsCliente.getString("Name"));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (conexao != null)
            {
                conexao.close();
            }

        }
    }
}
