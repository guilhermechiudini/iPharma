package modelDominio;

import java.io.Serializable;

public class Colaborador extends Usuario implements Serializable {
    private static final long serialVersionUID = 123L;

    public Colaborador(int codigo, String nome, String cpf, String email, String telefone, String endereco, String login, String senha) {
        super(codigo, nome, cpf, email, telefone, endereco, login, senha);
    }

    public Colaborador(String nome, String cpf, String email, String telefone, String endereco, String login, String senha) {
        super(nome, cpf, email, telefone, endereco, login, senha);
    }

}
