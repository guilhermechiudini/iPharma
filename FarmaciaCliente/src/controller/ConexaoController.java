package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Compra;
import modelDominio.Produto;
import modelDominio.Usuario;

public class ConexaoController {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    public Usuario usuarioLogado;

    public ConexaoController(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    public Usuario efetuarLogin(Usuario usuario) {
        Usuario usuarioLogado;
        String mensagem;
        try {
            out.writeObject("UsuarioEfetuarLogin");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            usuarioLogado = (Usuario) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            usuarioLogado = null;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            usuarioLogado = null;
        }
        return usuarioLogado;
    }
    
    public ArrayList<Usuario> usuarioLista() {
        ArrayList<Usuario> listaUsuarios;
        try {
            out.writeObject("UsuarioLista");
            listaUsuarios = (ArrayList<Usuario>) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            listaUsuarios = null;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            listaUsuarios = null;
        }
        return listaUsuarios;
    }
    
    public boolean usuarioInserir(Usuario usuario) {
        String mensagem;
        boolean resultado;
        try {
            out.writeObject("UsuarioInserir");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            resultado = (Boolean) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean usuarioValidar(Usuario usuario) {
        String mensagem;
        boolean resultado;
        try {
            out.writeObject("UsuarioValidar");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            resultado = (Boolean) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public ArrayList<Produto> produtoLista() {
        ArrayList<Produto> listaProdutos;
        try {
            out.writeObject("ProdutoLista");
            listaProdutos = (ArrayList<Produto>) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            listaProdutos = null;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            listaProdutos = null;
        }
        return listaProdutos;
    }
    
    public boolean produtoInserir(Produto produto) {
        String mensagem;
        boolean resultado;
        try {
            out.writeObject("ProdutoInserir");
            mensagem = (String) in.readObject();
            out.writeObject(produto);
            resultado = (Boolean) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean produtoAlterar(Produto produto) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("ProdutoAlterar");
            mensagem = (String) in.readObject();
            out.writeObject(produto);
            resultado = (Boolean) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean produtoExcluir(Produto produto) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("ProdutoExcluir");
            mensagem = (String) in.readObject();
            out.writeObject(produto);
            resultado = (Boolean) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public ArrayList<Compra> compraLista() {
        ArrayList<Compra> listaCompras;
        try {
            out.writeObject("CompraLista");
            listaCompras = (ArrayList<Compra>) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            listaCompras = null;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            listaCompras = null;
        }
        return listaCompras;
    }
    
    public boolean compraInserir(Compra compra) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("CompraInserir");
            mensagem = (String) in.readObject();
            out.writeObject(compra);
            resultado = (Boolean) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        }
        catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public String enviarEmail(String email) {
        String codigo;
        String mensagem;
        try {
            out.writeObject("EnviarEmail");
            mensagem = (String) in.readObject();
            out.writeObject(email);
            codigo = (String) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            codigo = null;
        } catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            codigo = null;
        }
        return codigo;
    }
    
    public boolean redefinirSenha(Usuario usuario) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("RedefinirSenha");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            resultado = (boolean) in.readObject();
        }
        catch (IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        } catch (ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public void fim() {
        try {
            out.writeObject("fim");
            in.close();
            out.close();
        }
        catch (IOException ioe) {
            System.out.println("Erro: "+ioe.getMessage());
        }
    }
    
}
