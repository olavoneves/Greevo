package br.com.fiap.greevo.bean;

public class Administrador {
    private Long id;
    private String login;
    private String senha;

    public Administrador() {
    }

    public Administrador(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Administrador(Long id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Abrigo cadastrarAbrigo(String nome, Localizacao local, int capacidade, boolean acessivel) {
        return new Abrigo(nome, local, capacidade, acessivel);
    }

    public boolean autenticar(String inputLogin, String inputSenha) {
        return this.login.equals(inputLogin) && this.senha.equals(inputSenha);
    }
}
