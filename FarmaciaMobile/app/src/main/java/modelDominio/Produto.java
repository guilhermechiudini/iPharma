package modelDominio;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Produto implements Serializable {
    private static final long serialVersionUID = 123L;
    private int codigo;
    private String nome;
    private int quantidade;
    private float preco;
    private byte[] imagem;

    public Produto(int codigo, String nome, int quantidade, float preco, byte[] imagem) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.imagem = imagem;
    }

    public Produto(String nome, int quantidade, float preco, byte[] imagem) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.imagem = imagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public String getPrecoString(float preco) {
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
        return decimalFormat.format(preco);
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

}
