package com.example.farmaciamobile.controller;

import android.util.Log;

import com.example.farmaciamobile.viewModel.InformacoesViewModel;
import com.example.farmaciamobile.viewModel.InformacoesViewModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelDominio.Compra;
import modelDominio.Produto;
import modelDominio.Usuario;

public class ConexaoController {
    InformacoesViewModel informacoesViewModel;

    public ConexaoController(InformacoesViewModel informacoesViewModel) {
        this.informacoesViewModel = informacoesViewModel;
    }

    public boolean criaConexaoServidor(String ip, int porta) {
        boolean resultado;
        try {
            //Criando a conexão com o servidor
            Socket socket = new Socket(ip, porta);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            //Salvando os objetos socket no viewModel
            informacoesViewModel.inicializaObjetoSocket(in, out);
            resultado = true;
        } catch (IOException ioe) {
            Log.e("BikeShop", "Erro" + ioe.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public Usuario efetuarLogin(Usuario usuario) {
        Usuario usuarioLogado;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("UsuarioEfetuarLogin");
            mensagem = (String) this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(usuario);
            usuarioLogado = (Usuario) this.informacoesViewModel.getInputStream().readObject();
        }
        catch (IOException ioe) {
            Log.e("iPharma", "Erro: " + ioe.getMessage());
            usuarioLogado = null;
        }
        catch (ClassNotFoundException classe) {
            Log.e("iPharma", "Erro: " + classe.getMessage());
            usuarioLogado = null;
        }
        return usuarioLogado;
    }

    public boolean usuarioInserir(Usuario usuario) {
        boolean resultado;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("UsuarioInserir");
            mensagem = (String) informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(usuario);
            resultado = (boolean) informacoesViewModel.getInputStream().readObject();
        }
        catch (IOException ioe) {
            Log.e("iPharma", "Erro: " + ioe.getMessage());
            resultado = false;
        } catch (ClassNotFoundException classe) {
            Log.e("iPharma", "Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean usuarioValidar(Usuario usuario) {
        boolean resultado;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("UsuarioValidar");
            mensagem = (String) informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(usuario);
            resultado = (boolean) informacoesViewModel.getInputStream().readObject();
        }
        catch (IOException ioe) {
            Log.e("iPharma", "Erro: " + ioe.getMessage());
            resultado = false;
        } catch (ClassNotFoundException classe) {
            Log.e("iPharma", "Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public ArrayList<Produto> produtoLista() {
        ArrayList<Produto> listaProdutos;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("ProdutoLista");
            listaProdutos = (ArrayList<Produto>) this.informacoesViewModel.getInputStream().readObject();
        }
        catch (IOException ioe) {
            Log.e("iPharma", "Erro: " + ioe.getMessage());
            listaProdutos = null;
        } catch (ClassNotFoundException classe) {
            Log.e("iPharma", "Erro: " + classe.getMessage());
            listaProdutos = null;
        }
        return listaProdutos;
    }

    public ArrayList<Produto> produtoListaNome(String nome) {
        ArrayList<Produto> listaProdutos;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("ProdutoListaNome");
            mensagem = (String) this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(nome);
            listaProdutos = (ArrayList<Produto>) this.informacoesViewModel.getInputStream().readObject();
        }
        catch (IOException ioe) {
            Log.e("iPharma", "Erro: " + ioe.getMessage());
            listaProdutos = null;
        } catch (ClassNotFoundException classe) {
            Log.e("iPharma", "Erro: " + classe.getMessage());
            listaProdutos = null;
        }
        return listaProdutos;
    }

    public boolean compraInserir(Compra compra) {
        boolean resultado;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("CompraInserir");
            mensagem = (String) this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(compra);
            resultado = (boolean) this.informacoesViewModel.getInputStream().readObject();
        }
        catch (IOException ioe) {
            Log.e("iPharma", "Erro: " + ioe.getMessage());
            resultado = false;
        } catch (ClassNotFoundException classe) {
            Log.e("iPharma", "Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public String enviarEmail(String email) {
        String codigo;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("EnviarEmail");
            mensagem = (String) this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(email);
            codigo = (String) this.informacoesViewModel.getInputStream().readObject();
        }
        catch (IOException ioe) {
            Log.e("iPharma", "Erro: " + ioe.getMessage());
            codigo = null;
        } catch (ClassNotFoundException classe) {
            Log.e("iPharma", "Erro: " + classe.getMessage());
            codigo = null;
        }
        return codigo;
    }

    public boolean redefinirSenha(Usuario usuario) {
        boolean resultado;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("RedefinirSenha");
            mensagem = (String) this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(usuario);
            resultado = (boolean) this.informacoesViewModel.getInputStream().readObject();
        }
        catch (IOException ioe) {
            Log.e("iPharma", "Erro: " + ioe.getMessage());
            resultado = false;
        } catch (ClassNotFoundException classe) {
            Log.e("iPharma", "Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }

}
