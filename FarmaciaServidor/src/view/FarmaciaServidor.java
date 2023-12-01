package view;

import controller.TrataClienteController;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FarmaciaServidor {

    public static void main(String[] args) {
        try {
            // Abrindo a porta de comunicação
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor inicializado.\nAguardando conexao...");
            int codigoUnico = 0;
            // Laço de repetição
            while (true) {                
                // Aguardando a conexão dos clientes
                Socket cliente = servidor.accept();
                System.out.println("\nNovo cliente conectado: " + cliente);
                codigoUnico++;
                // Gerando nova Thread
                System.out.println("\nIniciando nova Thread.\nCliente: " + codigoUnico);
                TrataClienteController trataClienteController = new TrataClienteController(cliente, codigoUnico);
            }
        }
        catch (IOException ioe) {
            System.out.println("\nErro: " + ioe.getMessage());
        }
    }
    
}
