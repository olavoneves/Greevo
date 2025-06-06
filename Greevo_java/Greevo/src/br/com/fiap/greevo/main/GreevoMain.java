package br.com.fiap.greevo.main;

import br.com.fiap.greevo.bean.*;

import javax.swing.*;
import java.awt.*;

public class GreevoMain {
    public static void main(String[] args) {
        try {
            String login;
            String senha;
            Administrador adminAtual;

            // Simula banco de dados
            Administrador admin1 = new Administrador("admin1", "senha1");
            Administrador admin2 = new Administrador("admin2", "senha2");
            Administrador admin3 = new Administrador("admin3", "senha3");

            int option = -1;
            while (option != 0) {
                option = Integer.parseInt(JOptionPane.showInputDialog(" === GREEVO OPÇÕES === \n\n 1. Cadastrar Abrigos (Administrador) \n 2. Visualizar Abrigos Próximos (Usuário) \n 3. Controlar Lotação (Administrador) \n 4. Verificar Alerta Meteorológico \n 5. Greevo Assistant \n\n 0. Sair", "Escolha uma opção:"));

                switch (option) {
                    case 1:
                        do {
                            login = JOptionPane.showInputDialog("LOGIN:");
                        } while (login.isEmpty());
                        do {
                            senha = JOptionPane.showInputDialog("SENHA: ");
                        } while (senha.isEmpty());

                        adminAtual = null;
                        if (admin1.autenticar(login, senha)) {
                            adminAtual = admin1;
                        } else if (admin2.autenticar(login, senha)) {
                            adminAtual = admin2;
                        } else if (admin3.autenticar(login, senha)) {
                            adminAtual = admin3;
                        }

                        if (adminAtual != null) {
                            boolean cadastrando = true;
                            while (cadastrando) {

                                String nomeAbrigo;
                                do {
                                    nomeAbrigo = JOptionPane.showInputDialog("--- Cadastro de Abrigo --- \nNome do Abrigo (ex: Igreja): ");
                                } while (nomeAbrigo.isEmpty());

                                String localAbrigo;
                                do {
                                    localAbrigo = JOptionPane.showInputDialog("--- Cadastro de Abrigo --- \nLocal (ex: 'Teresópolis, RJ'): ");
                                } while (localAbrigo.isEmpty());

                                int capacidade;
                                do {
                                    capacidade = Integer.parseInt(JOptionPane.showInputDialog("--- Cadastro de Abrigo --- \nCapacidade Máxima:"));
                                } while (capacidade == 0);
                                int possuiAcessibilidade = JOptionPane.showConfirmDialog(null, "--- Cadastro de Abrigo --- \nAcessível ?", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);
                                int verificaEmergencial = JOptionPane.showConfirmDialog(null, "Abrigo emergencial (com equipe médica e kit SOS)?", "TIPO DE ABRIGO", JOptionPane.YES_NO_OPTION);
                                boolean acessivel;
                                if (possuiAcessibilidade == JOptionPane.YES_OPTION) {
                                    acessivel = true;
                                } else {
                                    acessivel = false;
                                }

                                Localizacao locAbrigo = new Localizacao(localAbrigo);
                                Abrigo abrigo;
                                AbrigoEmergencial abrigoEmergencial;
                                boolean temEquipeMedica;
                                boolean kitMedico;
                                String responsavel;
                                if (verificaEmergencial == JOptionPane.YES_OPTION) {
                                    temEquipeMedica = JOptionPane.showConfirmDialog(null, "Possui equipe médica?", "CONFERE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                                    kitMedico = JOptionPane.showConfirmDialog(null, "Possui kit de primeiros socorros?", "CONFERE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                                    responsavel = JOptionPane.showInputDialog("Responsável Emergencial: ");

                                    abrigoEmergencial = new AbrigoEmergencial(nomeAbrigo, locAbrigo, capacidade, acessivel, temEquipeMedica, kitMedico, responsavel);
                                    adminAtual.cadastrarAbrigo(abrigoEmergencial);
                                    JOptionPane.showMessageDialog(null, String.format("--- Abrigo Emergencial cadastrado com sucesso! --- \n\n Nome: " + abrigoEmergencial.getNome() + "\n Localidade: " + abrigoEmergencial.getLocalizacao().getNome() + "\n Capacidade Máxima: " + abrigoEmergencial.getCapacidadeMaxima() + "\n Possui Acessibilidade: " + abrigoEmergencial.isAcessivel() + "\n Possui Equipe Médica e Kit Socorros:  " + abrigoEmergencial.podeAtenderEmergencias() + "\n Responsável Emergencial: " + abrigoEmergencial.getResponsavel()));
                                } else {
                                    abrigo = new Abrigo(nomeAbrigo, locAbrigo, capacidade, acessivel);
                                    adminAtual.cadastrarAbrigo(abrigo);
                                    JOptionPane.showMessageDialog(null, String.format("--- Abrigo cadastrado com sucesso! --- \n\n Nome: " + abrigo.getNome() + "\n Localidade: " + abrigo.getLocalizacao().getNome() + "\n Capacidade Máxima: " + abrigo.getCapacidadeMaxima() + "\n Possui Acessibilidade: " + abrigo.isAcessivel()), "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                                }

                                int continua = JOptionPane.showConfirmDialog(null, "Cadastrar outro abrigo ?", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);

                                if (continua != JOptionPane.YES_OPTION) {
                                    cadastrando = false;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Acesso negado!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 2:
                        String localUsuario;
                        do {
                            localUsuario = JOptionPane.showInputDialog("--- Busca de Abrigos --- \nInforme sua localização (ex: 'Centro, Dhaka'):");
                        } while (localUsuario.isEmpty());
                        int verificaAcessibilidade = JOptionPane.showConfirmDialog(null, "Precisa de acessibilidade ?", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);

                        boolean acessivel;
                        if (verificaAcessibilidade == JOptionPane.YES_OPTION) {
                            acessivel = true;
                        } else {
                            acessivel = false;
                        }

                        try {
                            Localizacao locUsuario = new Localizacao(localUsuario);
                            Usuario usuario = new Usuario(locUsuario, acessivel);

                            // Simula busca por abrigos próximos
                            Abrigo newAbrigo = new Abrigo("Escola Municipal", locUsuario, 100, true);
                            if (newAbrigo.inRaio(usuario.getLocalizacao(), 5.0)) {
                                JOptionPane.showMessageDialog(null, String.format("--- Abrigo Disponível --- \n-" + newAbrigo.getNome() + " (" + newAbrigo.getLocalizacao().getNome() + ") \nVagas: " + (newAbrigo.getCapacidadeMaxima() - newAbrigo.getLotacaoAtual()) + "\nAcessível: " + newAbrigo.isAcessivel()), "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, String.format("Não existem refúgios em um raio de 5km de " + newAbrigo.getNome()));
                            }

                            boolean inAbrigos = true;
                            while (inAbrigos) {
                                int subOpcao = Integer.parseInt(JOptionPane.showInputDialog("--- OPÇÕES --- \n 1. Falar com Assistente Virtual \n 2. Ver distância até o abrigo \n\n 0. Voltar ao Inicío \nEscolha a Opção:"));

                                if (subOpcao == 1) {
                                    JOptionPane.showMessageDialog(null, "Entre na 5° Opção do menu principal!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                                    inAbrigos = false;
                                } else if (subOpcao == 2) {
                                    double distancia = newAbrigo.getLocalizacao().calcularDistancia(locUsuario);
                                    JOptionPane.showMessageDialog(null, String.format("Distância: " + distancia + " km"), "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    inAbrigos = false;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        do {
                            login = JOptionPane.showInputDialog("LOGIN:");
                        } while (login.isEmpty());
                        do {
                            senha = JOptionPane.showInputDialog("SENHA: ");
                        } while (senha.isEmpty());

                        adminAtual = null;
                        if (admin1.autenticar(login, senha)) {
                            adminAtual = admin1;
                        } else if (admin2.autenticar(login, senha)) {
                            adminAtual = admin2;
                        } else if (admin3.autenticar(login, senha)) {
                            adminAtual = admin3;
                        }

                        if (adminAtual != null) {
                            String locAbrigo;
                            String nomeAbrigo;
                            int quantPessoas;
                            do {
                                locAbrigo = JOptionPane.showInputDialog("Localização do Abrigo (ex: 'Centro, Dhaka'): ");
                                nomeAbrigo = JOptionPane.showInputDialog("Nome do Abrigo (ex: Escola): ");
                                quantPessoas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Pessoas: "));
                            } while (locAbrigo.isEmpty() || nomeAbrigo.isEmpty() || quantPessoas == 0);
                            Localizacao localAbrigo = new Localizacao(locAbrigo);

                            // Simula Atualização de Lotação
                            Abrigo abrigo = new Abrigo(nomeAbrigo, localAbrigo, 100, true);
                            if (abrigo.adicionarPessoas(quantPessoas)) {
                                JOptionPane.showMessageDialog(null, String.format("Lotação Atualizada: " + abrigo.getLotacaoAtual() + "/" + abrigo.getCapacidadeMaxima()), "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Lotação Máxima! Sem Espaço", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Acesso Negado", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 4:
                        // Simulação de alerta, o ideal seria fazer para todos que tiverem login no banco de dados sem precisar pedir a localização ou integrado com o da Defesa Civil
                        String localAlerta;
                        do {
                            localAlerta = JOptionPane.showInputDialog("Informe sua localização (ex: 'Porto Príncipe'): ");
                        } while (localAlerta.isEmpty());
                        verificaAcessibilidade = JOptionPane.showConfirmDialog(null, "Precisa de acessibilidade ?", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);

                        if (verificaAcessibilidade == JOptionPane.YES_OPTION) {
                            acessivel = true;
                        } else {
                            acessivel = false;
                        }

                        try {
                            Localizacao locAlerta = new Localizacao(localAlerta);
                            Usuario usuario =  new Usuario(locAlerta, acessivel);
                            // Simula Alerta
                            Alerta alerta = new Alerta("Chuva Intensa", locAlerta, 5.0);

                            if (usuario.inRisco(alerta)) {
                                JOptionPane.showMessageDialog(null, alerta.dispararAviso(), "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Você não está em uma área de risco!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 5:
                        ChatEmergencia chatEmergencia = new ChatEmergencia();
                        ChatTurista chatTurista = new ChatTurista();

                        boolean inChatbot = true;
                        while (inChatbot) {
                            String mensagem = JOptionPane.showInputDialog("--- Greevo Assistant ---", "Buscando:");
                            mensagem = mensagem.toLowerCase();
                            if (mensagem.contains("sair")) {
                                inChatbot = false;
                            } else if (mensagem.contains("perigo") || mensagem.contains("ajuda") || mensagem.contains("obrigado") || mensagem.contains("abrigo")) {
                                chatEmergencia.responder(mensagem);
                            } else if (mensagem.contains("idioma")) {
                                // Objetivo final - Traduzir todo o fluxo para que o usuário possa comunicar-se na lingua escolhida
                                int idioma = Integer.parseInt(JOptionPane.showInputDialog("Qual idioma você gostaria de se comunicar? \n 1. English \n 2. Spanish \n 3. Franch \n 0. Portuguese"));

                                switch (idioma) {
                                    case 1:
                                        chatTurista.setIdioma("en");
                                        break;
                                    case 2:
                                        chatTurista.setIdioma("es");
                                        break;
                                    case 3:
                                        chatTurista.setIdioma("fr");
                                        break;
                                    case 0:
                                        chatTurista.setIdioma("pt");
                                        break;
                                    default:
                                        break;
                                }
                                chatTurista.responder(mensagem);
                            } else {
                                chatEmergencia.responder(mensagem);
                            }
                        }
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Volte Sempre  \uD83D\uDC4B", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                        break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
