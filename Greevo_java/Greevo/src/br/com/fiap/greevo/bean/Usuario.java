package br.com.fiap.greevo.bean;

public class Usuario {
    private Long id;
    private Localizacao localizacao;
    private boolean acessibilidade;

    public Usuario() {
    }

    public Usuario(Localizacao localizacao, boolean acessibilidade) {
        this.localizacao = localizacao;
        this.acessibilidade = acessibilidade;
    }

    public Usuario(Long id, Localizacao localizacao, boolean acessibilidade) {
        this.id = id;
        this.localizacao = localizacao;
        this.acessibilidade = acessibilidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(boolean acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public boolean inRisco(Alerta alerta) {
        if (alerta == null) {
            return false;
        }
        return alerta.getZonaRisco().calcularDistancia(this.localizacao) <= alerta.getRaioKm();
    }
}
