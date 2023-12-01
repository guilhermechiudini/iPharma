package modelDominio;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Cosmetico extends Produto implements Serializable {
    private static final long serialVersionUID = 123L;
    private float volume;
    private String marca;

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

    public float getVolume() {
        return volume;
    }

    public String getVolumeString() {
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.##");
        return decimalFormat.format(volume);
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
