package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import modelDominio.Cliente;
import modelDominio.Colaborador;
import modelDominio.Compra;
import modelDominio.Cosmetico;
import modelDominio.Medicamento;
import modelDominio.Produto;
import modelDominio.Usuario;

public class CompraDao {
    private Connection connection;

    public CompraDao() {
        this.connection = Conector.getConnection();
    }
    
    public ArrayList<Compra> getListaCompra() {
        ArrayList<Compra> listaCompras = new ArrayList();
        PreparedStatement stmt = null;
        try {
            // Preparando o script SQL
            String sql = "select * from compra " +
                         "inner join produto on (compra.codigo_produto = produto.codigo_produto) " + 
                         "inner join usuario on (compra.codigo_usuario = usuario.codigo_usuario) " +
                         "order by compra.codigo_compra";
            stmt = connection.prepareStatement(sql);
            // Realizando a consulta no banco de dados
            ResultSet res = stmt.executeQuery();
            // Percorrendo o resultado
            while (res.next()) {
                // Obtendo as informações do Produto
                int codigoProduto = res.getInt("codigo_produto");
                String nomeProduto = res.getString("nome_produto");
                int quantidade = res.getInt("quantidade");
                float preco = res.getFloat("preco");
                String principioAtivo = res.getString("principio_ativo");
                String dosagem = res.getString("dosagem");
                String laboratorio = res.getString("laboratorio");
                String marca = res.getString("marca");
                float volume = res.getFloat("volume");
                byte[] imagem = res.getBytes("imagem");
                int tipoProduto = res.getInt("tipo");
                // Criando o objeto da classe Produto
                Produto produto;
                // Verificando o tipo do Produto
                if (tipoProduto == 0) {
                    produto = new Medicamento(principioAtivo, dosagem, laboratorio, codigoProduto, nomeProduto, quantidade, preco, imagem);
                }
                else {
                    produto = new Cosmetico(volume, marca, codigoProduto, nomeProduto, quantidade, preco, imagem);
                }
                // Obtendo as informações do Usuario
                int codigoUsuario = res.getInt("codigo_usuario");
                String nomeUsuario = res.getString("nome_usuario");
                String cpf = res.getString("cpf");
                String email = res.getString("email");
                String telefone = res.getString("telefone");
                String endereco = res.getString("endereco");
                String login = res.getString("login");
                String senha = res.getString("senha");
                int tipoUsuario = res.getInt("tipo");
                // Criando o objeto da classe Usuario
                Usuario usuario;
                // Verificando o tipo do Usuario
                if (tipoUsuario == 0) {
                    usuario = new Cliente(codigoUsuario, nomeUsuario, cpf, email, telefone, endereco, login, senha);
                }
                else {
                    usuario = new Colaborador(codigoUsuario, nomeUsuario, cpf, email, telefone, endereco, login, senha);
                }
                // Obtendo as informações da Compra
                int codigoCompra = res.getInt("codigo_compra");
                Date dataCompra = res.getDate("data_compra");
                int quantidadeCompra = res.getInt("quantidade_compra");
                float precoCompra = res.getFloat("preco_compra");
                // Criando o objeto da classe Compra
                Compra compra = new Compra(codigoCompra, produto, usuario, dataCompra, quantidadeCompra, precoCompra);
                // Adicionando a Compra na listaCompras
                listaCompras.add(compra);
            }
            res.close();
            stmt.close();
            connection.close();
        }
        catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            listaCompras = null;
        }
        return listaCompras;
    }
    
    public boolean inserir(Compra compra) {
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            // Desabilitando o autocommit
            connection.setAutoCommit(false);
            // Preparando o script SQL
            String sql = "insert into compra (codigo_produto, codigo_usuario, data_compra, quantidade_compra, preco_compra) values (?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            // Substituindo os "?" pelos parâmetros
            stmt.setInt(1, compra.getProduto().getCodigo());
            stmt.setInt(2, compra.getUsuario().getCodigo());
            stmt.setDate(3, compra.getDataCompra());
            stmt.setInt(4, compra.getQuantidadeCompra());
            stmt.setFloat(5, compra.getPrecoCompra());
            // Executando o insert
            stmt.execute();
            // Preparando o script SQL
            sql = "update produto set quantidade = ? where codigo_produto = ?";
            stmt = connection.prepareStatement(sql);
            // Substituindo os "?" pelos parâmetros
            stmt.setInt(1, compra.getProduto().getQuantidade() - compra.getQuantidadeCompra());
            stmt.setInt(2, compra.getProduto().getCodigo());
            // Executando o update
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
