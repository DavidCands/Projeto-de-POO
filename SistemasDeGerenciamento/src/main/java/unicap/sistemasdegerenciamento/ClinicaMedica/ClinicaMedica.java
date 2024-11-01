package unicap.sistemasdegerenciamento.ClinicaMedica;

import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ClinicaMedica {
    public static void main(String[] args, Clinica clinica) {
        Scanner scanner = new Scanner(System.in);
        //Clinica clinica = new Clinica();
        int opcao;
        do {
            System.out.println("\n--- Sistema de Clinica Medica ---");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Medico");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Exibir Relatorio de Consultas");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do paciente: ");
                    String nomePaciente = scanner.nextLine();
                    
                    System.out.print("Digite o CPF do paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    
                    System.out.println("Digite a idade do paciente: ");
                    int idadePaciente = scanner.nextInt();
                    
                    System.out.println("Digite o email do paciente: ");
                    String emailPaciente = scanner.nextLine();
                    
                    System.out.println("Digite o telefone do paciente: ");
                    String telefonePaciente = scanner.nextLine();
                    
                    Paciente paciente = new Paciente(nomePaciente, cpfPaciente, idadePaciente, emailPaciente, telefonePaciente);
                    clinica.adicionarPaciente(paciente);
                    
                    System.out.println("Paciente adicionado com sucesso!");
                    break;
                    
                case 2:
                    System.out.print("Digite o nome do medico: ");
                    String nomeMedico = scanner.nextLine();
                    
                    System.out.print("Digite a especialidade do medico: ");
                    String especialidadeMedico = scanner.nextLine();
                    
                    Medico medico = new Medico(nomeMedico, especialidadeMedico);
                    clinica.adicionarMedico(medico);
                    
                    System.out.println("Medico adicionado com sucesso!");
                    break;
                    
                case 3:
                    System.out.print("Digite o nome do paciente: ");
                    String nomePacienteConsulta = scanner.nextLine();
                    
                    Paciente pacienteConsulta = clinica.buscarPacientePorNome(nomePacienteConsulta);
                    if (pacienteConsulta == null) {
                        System.out.println("Paciente nao encontrado.");
                        break;
                    }
                    
                    System.out.print("Digite o nome do medico: ");
                    String nomeMedicoConsulta = scanner.nextLine();
                    
                    Medico medicoConsulta = clinica.buscarMedicoPorNome(nomeMedicoConsulta);
                    if (medicoConsulta == null) {
                        System.out.println("Medico nao encontrado.");
                        break;
                    }
                    clinica.agendarConsulta(pacienteConsulta, medicoConsulta, new Date());
                    break;
                    
                case 4:
                    clinica.buscarConsultas();
                    break;
                    
                case 0:
                    System.out.println("Voltando...");
                    break;
                    
                default:
                    System.out.println("Opcao invalida!");
                    break;
                    
            }
        }while(opcao != 0);
    }
}
