package modelDominio;

import java.io.Serializable;

public class Medicamento extends Produto implements Serializable {
    private static final long serialVersionUID = 123L;
    private String principioAtivo;
    private String dosagem;
    private String laboratorio;
    
    // Método Construtor
    public Medicamento(String principioAtivo, String dosagem, String laboratorio, int codigo, String nome, int quantidade, float preco, byte[] imagem) {
        super(codigo, nome, quantidade, preco, imagem);
        this.principioAtivo = principioAtivo;
        this.dosagem = dosagem;
        this.laboratorio = laboratorio;
    }

    public Medicamento(String principioAtivo, String dosagem, String laboratorio, String nome, int quantidade, float preco, byte[] imagem) {
        super(nome, quantidade, preco, imagem);
        this.principioAtivo = principioAtivo;
        this.dosagem = dosagem;
        this.laboratorio = laboratorio;
    }

    // Getters e Setters
    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }
    
}
