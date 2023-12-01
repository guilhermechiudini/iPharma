package modelDominio;

import java.io.Serializable;

public class Cosmetico extends Produto implements Serializable {
    private static final long serialVersionUID = 123L;
    private float volume;
    private String marca;

    // Método Construtor
    public Cosmetico(float volume, String marca, int codigo, String nome, int quantidade, float preco, byte[] imagem) {
        super(codigo, nome, quantidade, preco, imagem);
        this.volume = volume;
        this.marca = marca;
    }

    public Cosmetico(float volume, String marca, String nome, int quantidade, float preco, byte[] imagem) {
        super(nome, quantidade, preco, imagem);
        this.volume = volume;
        this.marca = marca;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
    
}
