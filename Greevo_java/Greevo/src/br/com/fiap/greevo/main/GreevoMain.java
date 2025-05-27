package br.com.fiap.greevo.main;

import br.com.fiap.greevo.bean.*;

import javax.swing.*;
import java.awt.*;

public class GreevoMain {
    public static void main(String[] args) {
        try {
            // Simula banco de dados
            Administrador admin1 = new Administrador("admin1", "senha1");
            Administrador admin2 = new Administrador("admin2", "senha2");
            Administrador admin3 = new Administrador("admin3", "senha3");

            int option = -1;
            while (option != 0) {
                option = Integer.parseInt(JOptionPane.showInputDialog("""
                        === GREEVO OPÇÕES ===
                        
                        1. Cadastrar Abrigos (Administrador)
                        2. Visualizar Abrigos Próximos (Usuário)
                        3. Controlar Lotação (Administrador)
                        4. Verificar Alerta Meteorológico
                        5. Falar com Chatbot
                        0. Sair
                        
                        """, "Escolha uma opção:"));

                switch (option) {
                    case 1:
                        String login = JOptionPane.showInputDialog("LOGIN:");
                        String senha = JOptionPane.showInputDialog("SENHA: ");

                        if (admin1.autenticar(login, senha) || admin2.autenticar(login, senha) || admin3.autenticar(login, senha)) {
                            boolean cadastrando = true;
                            while (cadastrando) {
                                String nomeAbrigo = JOptionPane.showInputDialog("--- Cadastro de Abrigo --- \nNome do Abrigo: ");
                                String localAbrigo = JOptionPane.showInputDialog("--- Cadastro de Abrigo --- \nLocal (ex: 'Teresópolis, RJ'): ");
                                int capacidade = Integer.parseInt(JOptionPane.showInputDialog("--- Cadastro de Abrigo --- \nCapacidade Máxima:"));
                                int possuiAcessibilidade = JOptionPane.showConfirmDialog(null, "--- Cadastro de Abrigo --- \nAcessível ?", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);

                                boolean acessivel;
                                if (possuiAcessibilidade == JOptionPane.YES_OPTION) {
                                    acessivel = true;
                                } acessivel = false;

                                try {
                                    Localizacao locAbrigo = new Localizacao(localAbrigo);
                                    // Arrumar verificação de quem irá criar o novo abrigo
                                    if (admin1) {
                                        Abrigo newAbrigo = admin3.cadastrarAbrigo(nomeAbrigo, locAbrigo, capacidade, acessivel);
                                    } else if (admin2) {
                                        Abrigo newAbrigo = admin3.cadastrarAbrigo(nomeAbrigo, locAbrigo, capacidade, acessivel);
                                    }
                                    Abrigo newAbrigo = admin3.cadastrarAbrigo(nomeAbrigo, locAbrigo, capacidade, acessivel);
                                } catch (IllegalArgumentException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
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
                        String localUsuario = JOptionPane.showInputDialog("--- Busca de Abrigos --- \nInforme sua localização (ex: 'Centro, Dhaka'):");
                        int verificaAcessibilidade = JOptionPane.showConfirmDialog(null, "Precisa de acessibilidade ?", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);

                        boolean acessivel;
                        if (verificaAcessibilidade != JOptionPane.YES_OPTION) {
                            acessivel = false;
                        } acessivel = true;

                        try {
                            Localizacao locUsuario = new Localizacao(localUsuario);
                            Usuario usuario = new Usuario(locUsuario, acessivel);

                            // Simula busca por abrigos próximos
                            Abrigo newAbrigo = new Abrigo("Escola Municipal", new Localizacao("Teresópolis, RJ"), 100, true);
                            if (newAbrigo.inRaio(usuario.getLocalizacao(), 5.0)) {
                                JOptionPane.showMessageDialog(null, String.format("--- Abrigo Disponível --- \n-" + newAbrigo.getNome() + " (" + newAbrigo.getLocalizacao().getNome() + ") \nVagas: " + (newAbrigo.getCapacidadeMaxima() - newAbrigo.getLotacaoAtual())), "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                            }

                            boolean inAbrigos = true;
                            while (inAbrigos) {
                                int subOpcao = Integer.parseInt(JOptionPane.showInputDialog("--- OPÇÕES --- \n1. Falar com Assistente Virtual \n0. Voltar ao Inicío \nEscolha a Opção:"));

                                if (subOpcao == 1) {
                                    JOptionPane.showMessageDialog(null, "Entre na 5° Opção do menu principal!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                                    inAbrigos = false;
                                } else {
                                    inAbrigos = false;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        login = JOptionPane.showInputDialog("LOGIN:");
                        senha = JOptionPane.showInputDialog("SENHA: ");

                        if (admin1.autenticar(login, senha) || admin2.autenticar(login, senha) || admin3.autenticar(login, senha)) {
                            String nomeAbrigo = JOptionPane.showInputDialog("Nome do Abrigo: ");
                            int quantPessoas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Pessoas: "));

                            // Simula Atualização de Lotação
                            Abrigo abrigo = new Abrigo(nomeAbrigo, new Localizacao("Teresópolis, RJ"), 100, true);
                            if (abrigo.adicionarPessoas(quantPessoas)) {
                                JOptionPane.showMessageDialog(null, String.format("Lotação Atualizada: " + abrigo.getLotacaoAtual() + "/" + abrigo.getCapacidadeMaxima()));
                            } JOptionPane.showMessageDialog(null, "Lotação Máxima! Sem Espaço", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                        } JOptionPane.showMessageDialog(null, "Acesso Negado", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 4:
                        // Simulação de alerta, o ideal seria fazer para todos que tiverem login no banco de dados sem precisar pedir a localização

                        String localAlerta = JOptionPane.showInputDialog("Informe sua localização (ex: 'Porto Príncipe': ");
                        try {
                            Localizacao locAlerta = new Localizacao(localAlerta);
                            Alerta alerta = new Alerta("Chuva Intensa", locAlerta, 5.0);
                            JOptionPane.showMessageDialog(null, alerta.dispararAviso());
                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 5:
                        boolean inChatbot = true;
                        while (inChatbot) {
                            String mensagem = JOptionPane.showInputDialog("--- Greevo Assistant ---", "Buscando:");

                            if (mensagem.equalsIgnoreCase("sair")) {
                                inChatbot = false;
                            }
                            // Adicionar regra de comunicação com Assistante
                        }
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Volte Sempre  \uD83D\uDC4B");
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
