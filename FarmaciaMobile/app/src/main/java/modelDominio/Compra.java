package modelDominio;

import java.io.Serializable;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Compra implements Serializable {
    private static final long serialVersionUID = 123L;
    private int codigo;
    private Produto produto;
    private Usuario usuario;
    private Date dataCompra;
    private int quantidadeCompra;
    private float precoCompra;

    public Compra(int codigo, Produto produto, Usuario usuario, Date dataCompra, int quantidadeCompra, float precoCompra) {
        this.codigo = codigo;
        this.produto = produto;
        this.usuario = usuario;
        this.dataCompra = dataCompra;
        this.quantidadeCompra = quantidadeCompra;
        this.precoCompra = precoCompra;
    }

    public Compra(Produto produto, Usuario usuario, Date dataCompra, int quantidadeCompra, float precoCompra) {
        this.produto = produto;
        this.usuario = usuario;
        this.dataCompra = dataCompra;
        this.quantidadeCompra = quantidadeCompra;
        this.precoCompra = precoCompra;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public String getPrecoCompraString(float precoCompra) {
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
        return decimalFormat.format(precoCompra);
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public String getDataCompraString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(dataCompra);
    }

    public void setData(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public void setQuantidadeCompra(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

}
