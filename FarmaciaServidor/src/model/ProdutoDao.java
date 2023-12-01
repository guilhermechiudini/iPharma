package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelDominio.Cosmetico;
import modelDominio.Medicamento;
import modelDominio.Produto;

public class ProdutoDao {
    private Connection connection;

    public ProdutoDao() {
        this.connection = Conector.getConnection();
    }
    
    public ArrayList<Produto> getListaProdutos(String nomeProduto) {
        ArrayList<Produto> listaProdutos = new ArrayList();
        PreparedStatement stmt = null;
        try {
            // Verificação do estilo de consulta
            if (nomeProduto == null) {
                // Preparando o script SQL
                String sql = "select * from produto";
                stmt = connection.prepareStatement(sql);
            }
            else {
                // Preparando o script SQL
                String sql = "select * from produto where nome_produto like ?";
                stmt = connection.prepareStatement(sql);
                // Substituindo o "?" pelo parâmetro
                stmt.setString(1, "%" + nomeProduto + "%");
            }
            // Realizando a consulta no banco de dados
            ResultSet res = stmt.executeQuery();
            // Percorrendo o resultado
            while (res.next()) {
                // Obtendo as informações do banco de dados
                int codigo = res.getInt("codigo_produto");
                String nome = res.getString("nome_produto");
                int quantidade = res.getInt("quantidade");
                float preco = res.getFloat("preco");
                String principioAtivo = res.getString("principio_ativo");
                String dosagem = res.getString("dosagem");
                String laboratorio = res.getString("laboratorio");
                String marca = res.getString("marca");
                float volume = res.getFloat("volume");
                byte[] imagem = res.getBytes("imagem");
                int tipo = res.getInt("tipo");
                // Verificando o tipo do Produto
                if (tipo == 0) {
                    Produto produto = new Medicamento(principioAtivo, dosagem, laboratorio, codigo, nome, quantidade, preco, imagem);
                    // Adicionando o objeto na listaProdutos
                    listaProdutos.add(produto);
                }
                else {
                    Produto produto = new Cosmetico(volume, marca, codigo, nome, quantidade, preco, imagem);
                    // Adicionando o objeto na listaProdutos
                    listaProdutos.add(produto);
                }
            }
            res.close();
            stmt.close();
            connection.close();
        }
        catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            listaProdutos = null;
        }
        return listaProdutos;
    }
    
    public boolean inserir(Produto produto) {
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            // Desabilitando o autocommit
            connection.setAutoCommit(false);
            // Verificando o tipo do Produto
            if (produto instanceof Medicamento) {
                // Preparando o script
                String sql = "insert into produto (nome_produto, preco, quantidade, principio_ativo, laboratorio, dosagem, imagem, tipo) values (?, ?, ?, ?, ?, ?, ?, 0)";
                stmt = connection.prepareStatement(sql);
                // Substituindo os "?" pelos parâmetros
                stmt.setString(1, produto.getNome());
                stmt.setFloat(2, produto.getPreco());
                stmt.setInt(3, produto.getQuantidade());
                stmt.setString(4, ((Medicamento) produto).getPrincipioAtivo());
                stmt.setString(5, ((Medicamento) produto).getLaboratorio());
                stmt.setString(6, ((Medicamento) produto).getDosagem());
                stmt.setBytes(7, produto.getImagem());
                // Executando o insert
                stmt.execute();
                // Efetivando a transação no banco de dados
                connection.commit();
                // Definindo o resultado
                resultado = true;
            }
            else {
                // Preparando o script
                String sql = "insert into produto (nome_produto, preco, quantidade, marca, volume, imagem, tipo) values (?, ?, ?, ?, ?, ?, 1)";
                stmt = connection.prepareStatement(sql);
                // Substituindo os "?" pelos parâmetros
                stmt.setString(1, produto.getNome());
                stmt.setFloat(2, produto.getPreco());
                stmt.setInt(3, produto.getQuantidade());
                stmt.setString(4, ((Cosmetico) produto).getMarca());
                stmt.setFloat(5, ((Cosmetico) produto).getVolume());
                stmt.setBytes(6, produto.getImagem());
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
    
    public boolean alterar(Produto produto) {
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            // Desabilitando o autocommit
            connection.setAutoCommit(false);
            // Verificando o tipo do Produto
            if (produto instanceof Medicamento) {
                // Preparando o script SQl
                String sql = "update produto set nome_produto = ?, preco = ?, quantidade = ?, principio_ativo = ?, laboratorio = ?, dosagem = ?, imagem = ? where codigo_produto = ?";
                stmt = connection.prepareStatement(sql);
                // Substituindo os "?" pelos parâmetros
                stmt.setString(1, produto.getNome());
                stmt.setFloat(2, produto.getPreco());
                stmt.setInt(3, produto.getQuantidade());
                stmt.setString(4, ((Medicamento) produto).getPrincipioAtivo());
                stmt.setString(5, ((Medicamento) produto).getLaboratorio());
                stmt.setString(6, ((Medicamento) produto).getDosagem());
                stmt.setBytes(7, produto.getImagem());
                stmt.setInt(8, produto.getCodigo());
                // Executando o alterar
                stmt.execute();
                // Efetivando a transação no banco de dados
                connection.commit();
                // Definindo o resultado
                resultado = true;
            }
            else {
                // Preparando o script SQl
                String sql = "update produto set nome_produto = ?, preco = ?, quantidade = ?, marca = ?, volume = ?, imagem = ? where codigo_produto = ?";
                stmt = connection.prepareStatement(sql);
                // Substituindo os "?" pelos parâmetros
                stmt.setString(1, produto.getNome());
                stmt.setFloat(2, produto.getPreco());
                stmt.setInt(3, produto.getQuantidade());
                stmt.setString(4, ((Cosmetico) produto).getMarca());
                stmt.setFloat(5, ((Cosmetico) produto).getVolume());
                stmt.setBytes(6, produto.getImagem());
                stmt.setInt(7, produto.getCodigo());
                // Executando o alterar
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
    
    public boolean excluir(Produto produto) {
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            // Desabilitando o autocommit
            connection.setAutoCommit(false);
            // Preparando o script SQL
            String sql = "delete from produto where codigo_produto = ?";
            stmt = connection.prepareStatement(sql);
            // Substituindo os "?" pelos parâmetros
            stmt.setInt(1, produto.getCodigo());
            // Executando o delete
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
