package br.com.fiap.greevo.bean;

public class Alerta {
    private String tipo; // "Enchente", "Ciclone"...
    private Localizacao zonaRisco;
    private double raioKm;

    public Alerta() {
    }

    public Alerta(String tipo, Localizacao zonaRisco, double raioKm) {
        this.tipo = tipo;
        this.zonaRisco = zonaRisco;
        this.raioKm = raioKm;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Localizacao getZonaRisco() {
        return zonaRisco;
    }

    public void setZonaRisco(Localizacao zonaRisco) {
        this.zonaRisco = zonaRisco;
    }

    public double getRaioKm() {
        return raioKm;
    }

    public void setRaioKm(double raioKm) {
        this.raioKm = raioKm;
    }

    public String dispararAviso() {
        return "ALERTA DE " + tipo.toUpperCase() + "! \nEvacuar área de " + raioKm + " km.";
    }
}
