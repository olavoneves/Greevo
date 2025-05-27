package br.com.fiap.greevo.bean;

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
     * @return Resposta contextual do chatbot
     */
    public String responder(String mensagem) {
        mensagem = mensagem.toLowerCase();
        if (this.idioma.equals("en")) {
            if (mensagem.contains("shelter")) {
                return "Use the command: FIND [YOUR_LOCATION] to see nearby shelters.";
            } else if (mensagem.contains("language") || mensagem.contains("idioma")) {
                return "I can speak: English(en), Spanish(es), French(fr). Type change language to switch";
            } else if (mensagem.contains("help") || mensagem.contains("ajuda")) {
                return "Available commands: FIND, LANGUAGE, EXIT.";
            }
        } else if (this.idioma.equals("es")) {
            if (mensagem.contains("refugio") || mensagem.contains("albergue")) {
                return "Use el comando: BUSCAR [SU_UBICACIÓN] para ver refugios cercanos.";
            }
            else if (mensagem.contains("idioma")) {
                return "Puedo hablar: Inglés (en), Español (es), Francés (fr). Escribe cambiar idioma para cambiar.";
            }
        } else if (this.idioma.equals("fr")) {
            if (mensagem.contains("abri") || mensagem.contains("auberge")) {
                return "Utilisez la commande : RECHERCHER [VOTRE_EMPLACEMENT] pour voir les abris à proximité.";
            } else if (mensagem.contains("langue")) {
                return "Je peux parler : anglais (en), espagnol (es), français (fr). Tapez changer la langue pour changer.";
            }
        }
        return "I didn't understand. Type 'help' for options. / No entendí. Escribe 'ayuda' para opciones. / Je n'ai pas compris. Tapez aide pour les options.";
    }

    public void mudarIdioma(String idioma) {
        this.idioma = idioma.toLowerCase();
    }
}
