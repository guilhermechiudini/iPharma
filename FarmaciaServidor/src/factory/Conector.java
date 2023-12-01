package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    
    public static Connection getConnection() {
        Connection connection;
        try {
            // Definindo os parâmetros para a conexão com o banco
            String url = "jdbc:mysql://localhost:3306/";
            String banco = "ipharma";
            String usuario = "root";
            String senha = "";
            // Gerando a conexão com o banco
            connection = DriverManager.getConnection(url + banco, usuario, senha);
        }
        catch (SQLException sql) {
            System.out.println("Erro: "+sql.getMessage());
            connection = null;
        }
        return connection;
    }
}
