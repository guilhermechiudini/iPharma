package modelDominio;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {
    private static final long serialVersionUID = 123L;

    public Cliente(int codigo, String nome, String cpf, String email, String telefone, String endereco, String login, String senha) {
        super(codigo, nome, cpf, email, telefone, endereco, login, senha);
    }

    public Cliente(String nome, String cpf, String email, String telefone, String endereco, String login, String senha) {
        super(nome, cpf, email, telefone, endereco, login, senha);
    }

}
