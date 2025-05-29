package br.com.fiap.greevo.bean;

public class AbrigoEmergencial extends Abrigo {
    private boolean equipeMedica;
    private boolean kitMedico;
    private String responsavel;

    public AbrigoEmergencial() {
    }

    public AbrigoEmergencial(String nome, Localizacao localizacao, int capacidadeMaxima, boolean acessivel, boolean equipeMedica, boolean kitMedico, String responsavel) {
        super(nome, localizacao, capacidadeMaxima, acessivel);
        this.equipeMedica = equipeMedica;
        this.kitMedico = kitMedico;
        this.responsavel = responsavel;
    }

    public boolean isEquipeMedica() {
        return equipeMedica;
    }

    public void setEquipeMedica(boolean equipeMedica) {
        this.equipeMedica = equipeMedica;
    }

    public boolean isKitMedico() {
        return kitMedico;
    }

    public void setKitMedico(boolean kitMedico) {
        this.kitMedico = kitMedico;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public boolean podeAtenderEmergencias() {
        return equipeMedica && kitMedico;
    }
}
