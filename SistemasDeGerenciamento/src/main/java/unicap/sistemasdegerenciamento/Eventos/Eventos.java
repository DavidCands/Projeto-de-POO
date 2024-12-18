package unicap.sistemasdegerenciamento.Eventos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import unicap.sistemasdegerenciamento.ClinicaMedica.Clinica;

public class Eventos {
    public static void main(String[] args, Clinica clinica) {
        Scanner scanner = new Scanner(System.in);
        //Clinica clinica = new Clinica();
        List<Evento> eventos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n--- Sistema de Eventos ---");
            System.out.println("1. Cadastrar novo evento");
            System.out.println("2. Listar eventos");
            System.out.println("3. Gerenciar um evento");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Selecione o tipo de evento:");
                    System.out.println("1. Seminário");
                    System.out.println("2. Workshop");
                    System.out.println("3. Conferência");
                    int tipoEvento = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Digite a data do evento (DD/MM/AAAA): ");
                    String dataEvento = scanner.nextLine();
                    System.out.print("Digite o nome do local: ");
                    String nomeLocal = scanner.nextLine();
                    System.out.print("Digite o endereço do local: ");
                    String enderecoLocal = scanner.nextLine();
                    System.out.print("Digite o número de vagas disponíveis: ");
                    int vagasEvento = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o preço do evento: R$");
                    double precoEvento = scanner.nextDouble();

                    Local local = new Local(nomeLocal, enderecoLocal);
                    Evento novoEvento = null;

                    switch (tipoEvento) {
                        case 1:
                            novoEvento = new Seminario(nomeEvento, dataEvento, local, vagasEvento, precoEvento);
                            break;
                        case 2:
                            novoEvento = new Workshop(nomeEvento, dataEvento, local, vagasEvento, precoEvento);
                            break;
                        case 3:
                            novoEvento = new Conferencia(nomeEvento, dataEvento, local, vagasEvento, precoEvento);
                            break;
                        default:
                            System.out.println("Tipo de evento inválido.");
                    }

                    if (novoEvento != null) {
                        eventos.add(novoEvento);
                        System.out.println("Evento cadastrado com sucesso!");
                        novoEvento.definirRegras();
                    }
                    break;

                case 2:
                    if (eventos.isEmpty()) {
                        System.out.println("Nenhum evento cadastrado.");
                    } else {
                        System.out.println("\n--- Lista de Eventos ---");
                        for (int i = 0; i < eventos.size(); i++) {
                            System.out.println((i + 1) + ". " + eventos.get(i).getNome());
                        }
                    }
                    break;

                case 3:
                    if (eventos.isEmpty()) {
                        System.out.println("Nenhum evento cadastrado para gerenciar.");
                    } else {
                        System.out.println("\n--- Eventos existentes ---");
                        for (int i = 0; i < eventos.size(); i++) {
                            System.out.println((i + 1) + ". " + eventos.get(i).getNome());
                        }
                        System.out.print("\nDigite o número do evento que deseja gerenciar: ");
                        int indiceEvento = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indiceEvento >= 0 && indiceEvento < eventos.size()) {
                            Evento eventoGerenciar = eventos.get(indiceEvento);

                            int opcaoEvento;
                            do {
                                System.out.println("\n--- Gerenciar Evento: " + eventoGerenciar.getNome() + " ---");
                                System.out.println("1. Cadastrar participante");
                                System.out.println("2. Remover participante");
                                System.out.println("3. Consultar vagas");
                                System.out.println("4. Gerar relatório de participação");
                                System.out.println("5. Exibir detalhes do evento");
                                System.out.println("0. Voltar");
                                System.out.print("Escolha uma opcao: ");
                                opcaoEvento = scanner.nextInt();
                                scanner.nextLine();

                                switch (opcaoEvento) {
                                    case 1:
                                        System.out.print("Digite o nome do participante: ");
                                        String nomeParticipante = scanner.nextLine();

                                        boolean isMedico = clinica.buscarMedicoPorNome(nomeParticipante) != null;

                                        System.out.print("Digite o email do participante: ");
                                        String emailParticipante = scanner.nextLine();
                                        System.out.print("Digite o telefone do participante: ");
                                        String telefoneParticipante = scanner.nextLine();
                                        System.out.print("Digite a idade do participante: ");
                                        int idadeParticipante = scanner.nextInt();
                                        scanner.nextLine();

                                        boolean isEstudante = false;
                                        if (!isMedico) {
                                            System.out.print("O participante é um estudante? (S/N): ");
                                            isEstudante = scanner.nextLine().equalsIgnoreCase("S");
                                        }

                                        double valorEvento = eventoGerenciar.getPrecoEvento();

                                        Participante participante = new Participante(
                                                nomeParticipante, emailParticipante, telefoneParticipante,
                                                idadeParticipante, isEstudante, isMedico, valorEvento);

                                        participante.calcularDesconto(valorEvento);

                                        System.out.println("Valor do evento para " + nomeParticipante + ": R$" + participante.getPrecoPago());

                                        eventoGerenciar.cadastrarParticipante(participante);
                                        break;

                                    case 2:
                                        System.out.print("Digite o nome do participante a ser removido: ");
                                        String nomeRemover = scanner.nextLine();
                                        eventoGerenciar.removerParticipante(nomeRemover);
                                        break;

                                    case 3:
                                        eventoGerenciar.consultarVagas();
                                        break;

                                    case 4:
                                        eventoGerenciar.gerarRelatorioParticipacao();
                                        break;

                                    case 5:
                                        eventoGerenciar.exibirDetalhes();
                                        break;

                                    case 0:
                                        System.out.println("Voltando ao menu principal...");
                                        break;

                                    default:
                                        System.out.println("Opção inválida! Tente novamente.");
                                        break;
                                }
                            } while (opcaoEvento != 0);
                        } else {
                            System.out.println("Evento inválido.");
                        }
                    }
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
}
