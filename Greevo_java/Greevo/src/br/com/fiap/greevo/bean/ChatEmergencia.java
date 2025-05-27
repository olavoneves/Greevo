package br.com.fiap.greevo.bean;

public class ChatEmergencia implements Chatbot{

    /**
     * @param mensagem - texto de entrada do usuário
     * @return Resposta contextual do chatbot
     */
    public String responder(String mensagem) {
        mensagem = mensagem.toLowerCase();
        if (mensagem.matches(".*(abrigo|refúgio|abrigar|albergue|abrigos).*")) {
            return """
               🆘 ABRIGOS PRÓXIMOS:
               1. Digite BUSCAR seguido de sua localização.
                  Ex: BUSCAR Teresópolis, RJ
               2. Para abrigos acessíveis, adicione ACESSIVEL.
                  Ex: BUSCAR ACESSIVEL Porto Príncipe
               """;
        } else if (mensagem.matches(".*(perigo|risco|emergência|alerta|chuv|enchent|deslizamento).*")) {
            return """
               ⚠️ EMERGÊNCIA:
               - Entre em contato com a Defesa Civil local.
               - Siga para áreas elevadas imediatamente.
               - Use o comando BUSCAR para abrigos próximos.
               """;
        } else if (mensagem.matches(".*(ajuda|socorro|help|comandos|opções).*")) {
            return """
               ℹ️ COMANDOS DISPONÍVEIS:
               - BUSCAR [localização]: Encontra abrigos
               - ALERTA: Verifica riscos na sua área
               - SAIR: Encerra o chat
               """;
        } else if (mensagem.matches(".*(obrigad|obrigado|valeu|grato|agradeço|thanks).*")) {
            return "Fico feliz em ajudar! ❤️ Digite AJUDA se precisar de mais orientações.";
        }
        return """
           Não entendi completamente. 😕
           Você pode perguntar sobre:
           - Abrigos próximos
           - Alertas de risco
           - Comandos disponíveis
           """;
    }
}
