package br.com.fiap.greevo.bean;

import javax.swing.*;

public class ChatEmergencia implements Chatbot{

    /**
     * @param mensagem - texto de entrada do usuário
     */
    public void responder(String mensagem) {
        mensagem = mensagem.toLowerCase();
        if (mensagem.matches(".*(abrigo|refúgio|abrigar|albergue|abrigos).*")) {
            JOptionPane.showMessageDialog(null, "1. Digite BUSCAR seguido de sua localização \n   Ex: BUSCAR 'Teresópolis, RJ' \n2. Para abrigos acessíveis, adicione ACESSIVEL \n   Ex: BUSCAR ACESSIVEL 'Porto Príncipe' ", "ABRIGOS PRÓXIMOS", JOptionPane.WARNING_MESSAGE);
        } else if (mensagem.matches(".*(perigo|risco|emergência|alerta|chuv|enchent|deslizamento).*")) {
            JOptionPane.showMessageDialog(null, " - Entre em contato com a Defesa Civil local. \n - Siga para áreas elevadas imediatamente. \n - Use o comando BUSCAR para abrigos próximos.", "EMERGÊNCIA", JOptionPane.WARNING_MESSAGE);
        } else if (mensagem.matches(".*(ajuda|socorro|help|comandos|opções).*")) {
            JOptionPane.showMessageDialog(null, " - BUSCAR [localização]: Encontra abrigos \n - ALERTA: Verifica riscos na sua área \n - SAIR: Encerra o chat", "COMANDOS RELEVANTES", JOptionPane.INFORMATION_MESSAGE);
        } else if (mensagem.matches(".*(obrigad|obrigado|valeu|grato|agradeço|thanks).*")) {
            JOptionPane.showMessageDialog(null, "Fico feliz em ajudar! ❤️ Digite AJUDA se precisar de mais orientações.", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não entendi completamente. \uD83D\uDE15\n - Você pode perguntar sobre:\n - Abrigos próximos\n - Alertas de risco\n - Comandos disponíveis");
        }
    }
}
