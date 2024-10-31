package unicap.sistemasdegerenciamento.Eventos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGerenciamentoEventos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Evento> eventos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n--- Sistema de Gerenciamento de Eventos ---");
            System.out.println("1. Cadastrar novo evento");
            System.out.println("2. Listar eventos");
            System.out.println("3. Gerenciar um evento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    cadastrarEvento(scanner, eventos);
                    break;
                case 2:
                    listarEventos(eventos);
                    break;
                case 3:
                    gerenciarEvento(scanner, eventos);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void cadastrarEvento(Scanner scanner, List<Evento> eventos) {
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();
        
        System.out.print("Data do evento: ");
        String data = scanner.nextLine();
        
        System.out.print("Nome do local: ");
        String nomeLocal = scanner.nextLine();
        
        System.out.print("Endereço do local: ");
        String enderecoLocal = scanner.nextLine();

        System.out.print("Número de vagas disponíveis: ");
        int vagasDisponiveis = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Digite o preco do evento: R$");
        double precoEvento = scanner.nextDouble();

        Local local = new Local(nomeLocal, enderecoLocal);
        Evento evento = new Evento(nome, data, local, vagasDisponiveis, precoEvento);
        eventos.add(evento);

        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void listarEventos(List<Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
            System.out.println("\nLista de Eventos:");
            for (int i = 0; i < eventos.size(); i++) {
                Evento evento = eventos.get(i);
                System.out.println((i + 1) + ". " + evento.getNome() + " - " + evento.getData());
            }
        }
    }

    private static void gerenciarEvento(Scanner scanner, List<Evento> eventos) {
        listarEventos(eventos);
        if (eventos.isEmpty()) return;

        System.out.print("Escolha o número do evento para gerenciar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  

        if (opcao > 0 && opcao <= eventos.size()) {
            Evento eventoSelecionado = eventos.get(opcao - 1);
            int opcGerenciar;
            
            do {
                System.out.println("\n--- Gerenciando Evento: " + eventoSelecionado.getNome() + " ---");
                System.out.println("1. Adicionar Participante");
                System.out.println("2. Exibir Detalhes do Evento");
                System.out.println("3. Listar Participantes");
                System.out.println("0. Voltar ao menu de eventos");
                System.out.print("Escolha uma opção: ");
                opcGerenciar = scanner.nextInt();
                scanner.nextLine();

                switch (opcGerenciar) {
                    case 1:
                        adicionarParticipante(scanner, eventoSelecionado);
                        break;
                    case 2:
                        exibirDetalhesEvento(eventoSelecionado);
                        break;
                    case 3:
                        listarParticipantes(eventoSelecionado);
                        break;
                    case 0:
                        System.out.println("Voltando ao menu de eventos...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } while (opcGerenciar != 0);
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    private static void adicionarParticipante(Scanner scanner, Evento evento) {
        System.out.print("Nome do participante: ");
        String nome = scanner.nextLine();
        
        System.out.print("Email do participante: ");
        String email = scanner.nextLine();
        
        System.out.print("Telefone do participante: ");
        String telefone = scanner.nextLine();
        
        System.out.print("Idade do participante: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("O participante é estudante? (true para Sim / false para Não): ");
        boolean isEstudante = scanner.nextBoolean();
        scanner.nextLine();  
        
        Participante participante = new Participante(nome, email, telefone, idade, isEstudante);
        evento.cadastrarParticipante(participante);
        System.out.println("Participante adicionado com sucesso!");
    }

    private static void exibirDetalhesEvento(Evento evento) {
        System.out.println("\n--- Detalhes do Evento ---");
        System.out.println("Nome: " + evento.getNome());
        System.out.println("Data: " + evento.getData());
        System.out.println("Local: " + evento.getLocal().getNome() + " - " + evento.getLocal().getEndereco());
        listarParticipantes(evento);
    }

    private static void listarParticipantes(Evento evento) {
        if (evento.getParticipantes().isEmpty()) {
            System.out.println("Nenhum participante cadastrado.");
        } else {
            System.out.println("\nLista de Participantes:");
            for (Participante participante : evento.getParticipantes()) {
                System.out.println("- " + participante.getNome() + " (Idade: " + participante.getIdade() + ")");
            }
        }
    }
}
