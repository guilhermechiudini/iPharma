package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelDominio.Cliente;
import modelDominio.Colaborador;
import modelDominio.Usuario;

public class UsuarioDao {
    private Connection connection;

    public UsuarioDao() {
        this.connection = Conector.getConnection();
    }
    
    public Usuario efetuarLogin(Usuario usuario) {
        Usuario usuarioLogado = null;
        PreparedStatement stmt = null;
        try {
            // Preparando o script SQL
            String sql = "select * from usuario where login = ? and senha = ?";
            stmt = connection.prepareStatement(sql);
            // Substituindo os "?" pelos parâmetros
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            // Executando o select e obtendo o retorno
            ResultSet res = stmt.executeQuery();
            // Percorrendo o resultado (retorno)
            while(res.next()){
                // Obtendo as informações resultantes do banco (*select)
                int codigo = res.getInt("codigo_usuario");
                String nome = res.getString("nome_usuario");
                String cpf = res.getString("cpf");
                String email = res.getString("email");
                String telefone = res.getString("telefone");
                String endereco = res.getString("endereco");
                String login = res.getString("login");
                String senha = res.getString("senha");
                int tipo = res.getInt("tipo");
                // Verificando o tipo do usuario
                if (tipo == 0) {
                    usuarioLogado = new Cliente(codigo, nome, cpf, email, telefone, endereco, login, senha);
                }
                else {
                    usuarioLogado = new Colaborador(codigo, nome, cpf, email, telefone, endereco, login, senha);
                }
            }
            res.close();
            stmt.close();
            connection.close();
        }
        catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            usuarioLogado = null;
        }
        return usuarioLogado;
    }
    
    public ArrayList<Usuario> getListaUsuario() {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        Usuario usuario = null;
        PreparedStatement stmt = null;
        try {
            // Preparando o script SQL
            String sql = "select * from usuario";
            stmt = connection.prepareStatement(sql);
            // Realizando a consulta no banco de dados
            ResultSet res = stmt.executeQuery();
            // Percorrendo o resultado
            while (res.next()) {
                // Obtendo as informações do banco de dados
                int codigo = res.getInt("codigo_usuario");
                String nome = res.getString("nome_usuario");
                String cpf = res.getString("cpf");
                String email = res.getString("email");
                String telefone = res.getString("telefone");
                String endereco = res.getString("endereco");
                String login = res.getString("login");
                String senha = res.getString("senha");
                int tipo = res.getInt("tipo");
                // Verificando o tipo do Usuario
                if (tipo == 0) {
                    usuario = new Cliente(codigo, nome, cpf, email, telefone, endereco, login, senha);
                }
                else {
                    usuario = new Colaborador(codigo, nome, cpf, email, telefone, endereco, login, senha);
                }
                // Adicionando o Usuario na listaUsuarios
                listaUsuarios.add(usuario);
            }
            res.close();
            stmt.close();
            connection.close();
        }
        catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            listaUsuarios = null;
        }
        return listaUsuarios;
    }
    
    public boolean inserir(Usuario usuario) {
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            // Desabilitando o autocommit
            connection.setAutoCommit(false);
            // Verificando o tipo do Usuario
            if (usuario instanceof Cliente) {
                // Preparando o script SQL
                String sql = "insert into usuario (nome_usuario, cpf, email, telefone, endereco, login, senha, tipo) values (?, ?, ?, ?, ?, ?, ?, 0)";
                stmt = connection.prepareStatement(sql);
                // Substituindo os "?" pelos parâmetros
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getCpf());
                stmt.setString(3, usuario.getEmail());
                stmt.setString(4, usuario.getTelefone());
                stmt.setString(5, usuario.getEndereco());
                stmt.setString(6, usuario.getLogin());
                stmt.setString(7, usuario.getSenha());
                // Executando o insert
                stmt.execute();
                // Efetivando a transação no banco de dados
                connection.commit();
                // Definindo o resultado
                resultado = true;
            }
            else {
                // Preparando o script SQL
                String sql = "insert into usuario (nome_usuario, cpf, email, telefone, endereco, login, senha, tipo) values (?, ?, ?, ?, ?, ?, ?, 1)";
                stmt = connection.prepareStatement(sql);
                // Substituindo os "?" pelos parâmetros
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getCpf());
                stmt.setString(3, usuario.getEmail());
                stmt.setString(4, usuario.getTelefone());
                stmt.setString(5, usuario.getEndereco());
                stmt.setString(6, usuario.getLogin());
                stmt.setString(7, usuario.getSenha());
                // Executando o insert
                stmt.execute();
                // Efetivando a transação no banco de dados
                connection.commit();
                // Definindo o resultado
                resultado = true;
            }
        }
        catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
            try {
                connection.rollback();
            }
            catch (SQLException exc2) {
                System.out.println("Erro: " + exc2.getMessage());
            }
        }
        finally {
            try {
                stmt.close();
                connection.setAutoCommit(true);
                connection.close();
            }
            catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
                resultado = false;
            }
        }
        return resultado;
    }
    
    public boolean validar(Usuario usuario) {
        boolean resultado = false;
        PreparedStatement stmt = null;
        try {
            // Desabilitando o autocommit
            connection.setAutoCommit(false);
            // Preparando o script SQl
            String sql = "select * from usuario where login = ? and email = ?";
            stmt = connection.prepareStatement(sql);
            // Substituindo os "?" pelos parâmetros
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getEmail());
            // Executando o select e obtendo o retorno
            ResultSet res = stmt.executeQuery();
            // Percorrendo o resultado (retorno)
            while(res.next()){
                // Obtendo as informações resultantes do banco (*select)
                String login = res.getString("login");
                String email = res.getString("email");
                // Validação das informações
                if (login != null && email != null) {
                    // Definindo o resultado
                    resultado = true;
                }
                else {
                    // Definindo o resultado
                    resultado = false;
                }
            }
            res.close();
            stmt.close();
            connection.close();
        }
        catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean redefinirSenha(Usuario usuario) {
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            // Desabilitando o autocommit
            connection.setAutoCommit(false);
            // Preparando o script SQl
            String sql = "update usuario set senha = ? where login = ? and email = ?";
            stmt = connection.prepareStatement(sql);
            // Substituindo os "?" pelos parâmetros
            stmt.setString(1, usuario.getSenha());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getEmail());
            // Executando o redefinirSenha
            stmt.execute();
            // Efetivando a transação no banco de dados
            connection.commit();
            // Definindo o resultado
            resultado = true;
        }
        catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
            try {
                connection.rollback();
            }
            catch (SQLException exc2) {
                System.out.println("Erro: " + exc2.getMessage());
            }
        }
        finally {
            try {
                stmt.close();
                connection.setAutoCommit(true);
                connection.close();
            }
            catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
                resultado = false;
            }
        }
        return resultado;
    }
    
}
