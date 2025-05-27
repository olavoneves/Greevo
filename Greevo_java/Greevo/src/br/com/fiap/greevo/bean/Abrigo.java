package br.com.fiap.greevo.bean;

public class Abrigo {
    private Long id;
    private String nome;
    private Localizacao localizacao;
    private int capacidadeMaxima;
    private int lotacaoAtual;
    private boolean acessivel;

    public Abrigo() {
    }

    public Abrigo(String nome, Localizacao localizacao, int capacidadeMaxima, boolean acessivel) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.acessivel = acessivel;
    }

    public Abrigo(Long id, String nome, Localizacao localizacao, int capacidadeMaxima, int lotacaoAtual, boolean acessivel) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.lotacaoAtual = lotacaoAtual;
        this.acessivel = acessivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getLotacaoAtual() {
        return lotacaoAtual;
    }

    public void setLotacaoAtual(int lotacaoAtual) {
        this.lotacaoAtual = lotacaoAtual;
    }

    public boolean isAcessivel() {
        return acessivel;
    }

    public void setAcessivel(boolean acessivel) {
        this.acessivel = acessivel;
    }

    public boolean inRaio(Localizacao locUsuario, double raioKm) {
        return this.localizacao.calcularDistancia(locUsuario) <= raioKm;
    }

    public boolean adicionarPessoas(int quantPessoas) {
        if (this.lotacaoAtual + quantPessoas <= this.capacidadeMaxima) {
            this.lotacaoAtual += quantPessoas;
            return true;
        }
        return false;
    }
}
