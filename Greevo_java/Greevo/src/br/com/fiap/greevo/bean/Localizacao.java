package br.com.fiap.greevo.bean;

import javax.swing.*;

public class Localizacao {
    private Long id;
    private String nome;
    private double latitude;
    private double longitude;

    public Localizacao() {
    }

    public Localizacao(String nome) {
        switch (nome.toLowerCase()) {
            // Brasil (Região Serrana - RJ)
            case "teresópolis, rj":
                this.nome = nome;
                this.latitude = -22.4167;
                this.longitude = -42.9782;
                break;
            case "nova friburgo, rj":
                this.nome = nome;
                this.latitude = -22.2819;
                this.longitude = -42.5306;
                break;
            case "petrópolis, rj":
                this.nome = nome;
                this.latitude = -22.5050;
                this.longitude = -43.1789;
                break;

            // Bangladesh (Dhaka)
            case "centro, dhaka":
                this.nome = nome;
                this.latitude = 23.8103;
                this.longitude = 90.4125;
                break;
            case "uttara, dhaka":
                this.nome = nome;
                this.latitude = 23.8759;
                this.longitude = 90.3795;
                break;
            case "mirpur, dhaka":
                this.nome = nome;
                this.latitude = 23.8067;
                this.longitude = 90.3683;
                break;

            // Haiti (Porto Príncipe)
            case "porto príncipe":
                this.nome = nome;
                this.latitude = 18.5944;
                this.longitude = -72.3074;
                break;
            case "carrefour, porto príncipe":
                this.nome = nome;
                this.latitude = 18.5410;
                this.longitude = -72.3360;
                break;
            case "delmas, porto príncipe":
                this.nome = nome;
                this.latitude = 18.5500;
                this.longitude = -72.3000;
                break;

            default:
                JOptionPane.showMessageDialog(null, String.format("Local não cadastrado: " + nome), "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Localizacao(Long id, String nome, double latitude, double longitude) {
        this.id = id;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double calcularDistancia(Localizacao loc) {
        if (loc == null) {
            return 0;
        }
        return Math.sqrt(Math.pow(loc.latitude - this.latitude, 2) + Math.pow(loc.longitude - this.longitude, 2));
    }
}
