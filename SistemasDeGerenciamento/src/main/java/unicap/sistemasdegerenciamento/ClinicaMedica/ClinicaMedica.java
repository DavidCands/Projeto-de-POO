package unicap.sistemasdegerenciamento.ClinicaMedica;

import java.util.Scanner;

public class ClinicaMedica {
    public static void main(String[] args, Clinica clinica) {
        Scanner scanner = new Scanner(System.in);
        //Clinica clinica = new Clinica();
        int opcao;
        do {
            System.out.println("\n--- Sistema de Clinica Medica ---");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Médico");
            System.out.println("3. Exibir Informações de Pessoas");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do paciente: ");
                    String nomePaciente = scanner.nextLine();
                    System.out.print("Digite o CPF do paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    System.out.print("Digite a idade do paciente: ");
                    int idadePaciente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o email do paciente: ");
                    String emailPaciente = scanner.nextLine();
                    System.out.print("Digite o telefone do paciente: ");
                    String telefonePaciente = scanner.nextLine();

                    Paciente paciente = new Paciente(nomePaciente, cpfPaciente, idadePaciente, emailPaciente, telefonePaciente);
                    clinica.adicionarPessoa(paciente);
                    System.out.println("Paciente adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do médico: ");
                    String nomeMedico = scanner.nextLine();
                    System.out.print("Digite o CPF do médico: ");
                    String cpfMedico = scanner.nextLine();
                    System.out.print("Digite a especialidade do médico: ");
                    String especialidadeMedico = scanner.nextLine();

                    Medico medico = new Medico(nomeMedico, cpfMedico, especialidadeMedico);
                    clinica.adicionarPessoa(medico);
                    System.out.println("Médico adicionado com sucesso!");
                    break;

                case 3:
                    clinica.exibirInformacoesPessoas();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}
