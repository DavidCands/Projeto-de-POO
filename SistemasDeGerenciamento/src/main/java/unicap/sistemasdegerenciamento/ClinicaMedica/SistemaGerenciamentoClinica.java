package unicap.sistemasdegerenciamento.ClinicaMedica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaGerenciamentoClinica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n--- Sistema de Gerenciamento de Clínica ---");
            System.out.println("1. Cadastrar novo paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Agendar consulta");
            System.out.println("4. Gerenciar consultas");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  
            switch (opcao) {
                case 1:
                    cadastrarPaciente(scanner, pacientes);
                    break;
                case 2:
                    listarPacientes(pacientes);
                    break;
                case 3:
                    marcarConsulta(scanner, pacientes, medicos);
                    break;
                case 4:
                    gerenciarConsultas(scanner, pacientes);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
 
    private static void cadastrarPaciente(Scanner scanner, List<Paciente> pacientes) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF do paciente: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Idade do paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Email do paciente: ");
        String email = scanner.nextLine();
        
        System.out.print("Telefone do paciente: ");
        String telefone = scanner.nextLine();
        
        Paciente paciente = new Paciente(nome, cpf, idade, email, telefone);
        pacientes.add(paciente);
 
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void listarPacientes(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        }
        else {
            System.out.println("\nLista de Pacientes:");
            for (int i = 0; i < pacientes.size(); i++) {
                Paciente paciente = pacientes.get(i);
                System.out.println((i + 1) + ". " + paciente.getNome() + " - " + paciente.getIdade() + " anos");
            }
        }
    }

    private static void marcarConsulta(Scanner scanner, List<Paciente> pacientes, List<Medico> medicos) {
        listarPacientes(pacientes);
        if (pacientes.isEmpty()){
            return;
        }
 
        System.out.print("Escolha o número do paciente para agendar a consulta: ");
        int pacienteIndex = scanner.nextInt();
        scanner.nextLine();

        if (pacienteIndex > 0 && pacienteIndex <= pacientes.size()) {
            Paciente paciente = pacientes.get(pacienteIndex - 1);
 
            System.out.println("Escolha um médico para a consulta: ");
            Medico medico = escolherMedico(scanner, medicos);
            
            System.out.print("Informe a data da consulta(dd/MM/yyyy): ");
            String dataConsulta = scanner.nextLine();
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date data = formato.parse(dataConsulta);
                Consulta consulta = new Consulta(paciente, medico, data);
                paciente.adicionarConsulta(consulta);

                System.out.println("Consulta agendada com sucesso para " + paciente.getNome() + " com o Dr(a). " + medico.getNome());
            }
            catch (ParseException e) {
                System.out.println("Formato de data inválido! Use dd/MM/yyyy.");
            }
        }
        else {
            System.out.println("Paciente não encontrado.");
        }
    }
 
    private static Medico escolherMedico(Scanner scanner, List<Medico> medicos) {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado. Cadastrando um novo médico.");
            return cadastrarMedico(scanner, medicos);
        }
        else {
            System.out.println("\nLista de Médicos:");
            for (int i = 0; i < medicos.size(); i++) {
                Medico medico = medicos.get(i);
                System.out.println((i + 1) + ". " + medico.getNome() + " - Especialidade: " + medico.getEspecialidade());
            }
 
            System.out.print("Escolha o número do médico: ");
            int medicoIndex = scanner.nextInt();
            scanner.nextLine();  
 
            if (medicoIndex > 0 && medicoIndex <= medicos.size()) {
                return medicos.get(medicoIndex - 1);
            } 
            else {
                System.out.println("Médico não encontrado.");
                return null;
            }
        }
    }
 
    private static Medico cadastrarMedico(Scanner scanner, List<Medico> medicos) {
        System.out.print("Nome do médico: ");
        String nome = scanner.nextLine();
        
        System.out.print("Especialidade do médico: ");
        String especialidade = scanner.nextLine();
        
        Medico medico = new Medico(nome, especialidade);
        medicos.add(medico);
 
        System.out.println("Médico cadastrado com sucesso!");
        return medico;
    }
    
    private static void gerenciarConsultas(Scanner scanner, List<Paciente> pacientes) {
        listarPacientes(pacientes);
        if (pacientes.isEmpty()){
            return;
        }

        System.out.print("Escolha o número do paciente para gerenciar as consultas: ");
        int pacienteIndex = scanner.nextInt();
        scanner.nextLine();
 
        if (pacienteIndex > 0 && pacienteIndex <= pacientes.size()) {
            Paciente paciente = pacientes.get(pacienteIndex - 1);
            paciente.listarConsultas();
            
            System.out.println("Deseja cancelar alguma consulta? [1 - Sim | 2 - Não]");
            int cancelar = scanner.nextInt();
            scanner.nextLine();  
 
            if (cancelar == 1) {
                System.out.print("Informe a data da consulta a ser cancelada: ");
                String data = scanner.nextLine();
                paciente.cancelarConsulta(data);
            }
        }
        else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
