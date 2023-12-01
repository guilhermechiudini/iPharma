package modelDominio;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 123L;
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String login;
    private String senha;

    // Método Construtor
    public Usuario(int codigo, String nome, String cpf, String email, String telefone, String endereco, String login, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String cpf, String email, String telefone, String endereco, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(String login, String email, String senha) {
        this.login = login;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
