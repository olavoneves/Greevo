package br.com.fiap.greevo.bean;

import javax.swing.*;

public class ChatTurista implements Chatbot{
    private String idioma;

    public ChatTurista() {
    }

    public ChatTurista(String idioma) {
        this.idioma = idioma.toLowerCase();
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma.toLowerCase();
    }

    /**
     * @param mensagem - texto de entrada do usuário
     */
    public void responder(String mensagem) {
        mensagem = mensagem.toLowerCase();
        if (this.idioma.equals("en")) {
            if (mensagem.contains("shelter")) {
                JOptionPane.showMessageDialog(null, "Use the command: FIND [YOUR_LOCATION] to see nearby shelters.", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            } else if (mensagem.contains("language") || mensagem.contains("idioma")) {
                JOptionPane.showMessageDialog(null, "I can speak: English(en), Spanish(es), French(fr). Type change language to switch.", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            } else if (mensagem.contains("help") || mensagem.contains("ajuda")) {
                JOptionPane.showMessageDialog(null, "Available commands: FIND, LANGUAGE, EXIT.", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (this.idioma.equals("es")) {
            if (mensagem.contains("refugio") || mensagem.contains("albergue")) {
                JOptionPane.showMessageDialog(null, "Use el comando: BUSCAR [SU_UBICACIÓN] para ver refugios cercanos.", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (mensagem.contains("idioma")) {
                JOptionPane.showMessageDialog(null, "Puedo hablar: Inglés (en), Español (es), Francés (fr). Escribe cambiar idioma para cambiar.", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (this.idioma.equals("fr")) {
            if (mensagem.contains("abri") || mensagem.contains("auberge")) {
                JOptionPane.showMessageDialog(null, "Utilisez la commande : RECHERCHER [VOTRE_EMPLACEMENT] pour voir les abris à proximité.", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            } else if (mensagem.contains("langue")) {
                JOptionPane.showMessageDialog(null, "Je peux parler : anglais (en), espagnol (es), français (fr). Tapez changer la langue pour changer.", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, " didn't understand. Type 'help' for options. / No entendí. Escribe 'ayuda' para opciones. / Je n'ai pas compris. Tapez aide pour les options.", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mudarIdioma(String idioma) {
        this.idioma = idioma.toLowerCase();
    }
}
