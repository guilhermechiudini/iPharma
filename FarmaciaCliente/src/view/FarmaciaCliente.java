package view;

import controller.ConexaoController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class FarmaciaCliente {
    public static ConexaoController ccont;

    public static void main(String[] args) {
        try {
            // Gerando conexão com o servidor
            Socket socket = new Socket("localhost", 12345);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            // Instanciando o controller
            ccont = new ConexaoController(in, out);
            // Chamando a tela inicial
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }
    
}
