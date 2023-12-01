package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.CompraDao;
import model.JavaEmail;
import model.ProdutoDao;
import model.UsuarioDao;
import modelDominio.Compra;
import modelDominio.Produto;
import modelDominio.Usuario;

public class TrataClienteController extends Thread {
    private Socket socket;
    private int codigoUnico;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public TrataClienteController(Socket socket, int codigoUnico) {
        this.socket = socket;
        this.codigoUnico = codigoUnico;
        try {
            // Gerando canais de comunicação
            this.in = new ObjectInputStream(this.socket.getInputStream());
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
            this.start();
        }
        catch (IOException ioe) {
            System.out.println("\nErro: " + ioe.getMessage());
        }
    }
    
    @Override
    public void run() {
        String comando;
        System.out.println("\nEsperando comando.\nCliente: " + codigoUnico);
        try {
            // Aguardando comandos do cliente
            comando = (String) in.readObject();
            // Laço de repetição
            while (!comando.equalsIgnoreCase("fim")) {
                System.out.println("\nComando enviado: " + comando + "\nCliente: " + codigoUnico + ".");
                // Tratamento do comando enviado pelo cliente
                if (comando.equalsIgnoreCase("UsuarioEfetuarLogin")) {
                    // Enviando a confiramação
                    out.writeObject("ok");
                    // Recebendo o usuario que está autenticando
                    Usuario usuario = (Usuario) in.readObject();
                    // Consultando no banco se o login e senha estão corretos
                    UsuarioDao usuarioDao = new UsuarioDao();
                    Usuario usuarioLogado = usuarioDao.efetuarLogin(usuario);
                    // Enviando ao cliente o usuarioLogado;
                    out.writeObject(usuarioLogado);
                }
                else if (comando.equalsIgnoreCase("UsuarioLista")) {
                    // Recebendo a lista
                    UsuarioDao usuarioDao = new UsuarioDao();
                    ArrayList<Usuario> listaUsuarios = usuarioDao.getListaUsuario();
                    // Enviando a lista
                    out.writeObject(listaUsuarios);
                }
                else if (comando.equalsIgnoreCase("UsuarioInserir")) {
                    // Enviando a confirmação
                    out.writeObject("ok");
                    // Recebendo o Produto
                    Usuario usuario = (Usuario) in.readObject();
                    // Inserindo o Produto no banco de dados
                    UsuarioDao usuarioDao = new UsuarioDao();
                    boolean resultado = usuarioDao.inserir(usuario);
                    // Enviando ao cliente o resultado
                    out.writeObject(resultado);
                }
                else if (comando.equalsIgnoreCase("UsuarioValidar")) {
                    // Enviando a confirmação
                    out.writeObject("ok");
                    // Recebendo o Produto
                    Usuario usuario = (Usuario) in.readObject();
                    // Inserindo o Produto no banco de dados
                    UsuarioDao usuarioDao = new UsuarioDao();
                    boolean resultado = usuarioDao.validar(usuario);
                    // Enviando ao cliente o resultado
                    out.writeObject(resultado);
                }
                else if (comando.equalsIgnoreCase("ProdutoLista")) {
                    // Recebendo a lista
                    ProdutoDao produtoDao = new ProdutoDao();
                    ArrayList<Produto> listaProdutos = produtoDao.getListaProdutos(null);
                    // Enviando a lista
                    out.writeObject(listaProdutos);
                }
                else if (comando.equalsIgnoreCase("ProdutoListaNome")) {
                    // Enviando a confirmação
                    out.writeObject("ok");
                    // Recebendo o filtro
                    String nome = (String) in.readObject();
                    // Consultando o banco de dados para obtenção da lista filtrada
                    ProdutoDao produtoDao = new ProdutoDao();
                    ArrayList<Produto> listaProdutos = produtoDao.getListaProdutos(nome);
                    // Enviando ao cliente a listaProdutos
                    out.writeObject(listaProdutos);
                }
                else if (comando.equalsIgnoreCase("ProdutoInserir")) {
                    // Enviando a confirmação
                    out.writeObject("ok");
                    // Recebendo o Produto
                    Produto produto = (Produto) in.readObject();
                    // Inserindo o Produto no banco de dados
                    ProdutoDao produtoDao = new ProdutoDao();
                    boolean resultado = produtoDao.inserir(produto);
                    // Enviando ao cliente o resultado
                    out.writeObject(resultado);
                }
                else if (comando.equalsIgnoreCase("ProdutoAlterar")) {
                    // Enviando a confirmação
                    out.writeObject("ok");
                    // Recebendo o Produto
                    Produto produto = (Produto) in.readObject();
                    // Alterando o Produto no banco de dados
                    ProdutoDao produtoDao = new ProdutoDao();
                    boolean resultado = produtoDao.alterar(produto);
                    // Enviando o resultado ao cliente
                    out.writeObject(resultado);
                }
                else if (comando.equalsIgnoreCase("ProdutoExcluir")) {
                    // Enviando a confirmação
                    out.writeObject("ok");
                    // Recebendo o Produto
                    Produto produto = (Produto) in.readObject();
                    // Excluindo o Produto no banco de dados
                    ProdutoDao produtoDao = new ProdutoDao();
                    boolean resultado = produtoDao.excluir(produto);
                    // Enviando o resultado ao cliente
                    out.writeObject(resultado);
                }
                else if (comando.equalsIgnoreCase("CompraLista")) {
                    // Recebendo a lista
                    CompraDao compraDao = new CompraDao();
                    ArrayList<Compra> listaCompras = compraDao.getListaCompra();
                    // Enviando a lista
                    out.writeObject(listaCompras);
                }
                else if (comando.equalsIgnoreCase("CompraInserir")) {
                    // Enviando a confirmação
                    out.writeObject("ok");
                    // Recebendo a Compra
                    Compra compra = (Compra) in.readObject();
                    // Inserindo a Compra no banco de dados
                    CompraDao compraDao = new CompraDao();
                    boolean resultado = compraDao.inserir(compra);
                    // Enviando o resultado ao cliente
                    out.writeObject(resultado);
                }
                else if (comando.equalsIgnoreCase("EnviarEmail")) {
                    // Enviando a confirmação
                    out.writeObject("ok");
                    // Recebendo o e-mail
                    String email = (String) in.readObject();
                    // Enviando o e-mail com codigo para o destinatário
                    JavaEmail javaEmail = new JavaEmail();
                    String codigo = javaEmail.enviarEmail(email);
                    // Enviando o código ao cliente
                    out.writeObject(codigo);
                }
                else if (comando.equalsIgnoreCase("RedefinirSenha")) {
                    // Enviando a confirmação
                    out.writeObject("ok");
                    // Recebendo o Usuario
                    Usuario usuario = (Usuario) in.readObject();
                    // Alterando o Usuario no banco de dados
                    UsuarioDao usuarioDao = new UsuarioDao();
                    boolean resultado = usuarioDao.redefinirSenha(usuario);
                    // Enviando o resultado ao cliente
                    out.writeObject(resultado);
                }
                // Aguardando o próximo comando
                comando = (String) in.readObject();
            }
        }
        catch (IOException ioe) {
            System.out.println("\nErro: " + ioe.getMessage());
        }
        catch (ClassNotFoundException classe) {
            System.out.println("\nErro: " + classe.getMessage());
        }
        //Fechando os recursos utilizados pelo cliente
        try {
            System.out.println("\nConexao finalizada.\nCliente: " + codigoUnico);
            in.close();
            out.close();
            socket.close();
        }
        catch (IOException ioe) {
            System.out.println("\nErro: " + ioe.getMessage());
        }
    }
    
}
