package unicap.sistemasdegerenciamento.SistemadeGerenciamento;

import unicap.sistemasdegerenciamento.Eventos.Eventos;
import unicap.sistemasdegerenciamento.Restaurante.Restaurante;
import unicap.sistemasdegerenciamento.ClinicaMedica.Clinica;
import unicap.sistemasdegerenciamento.ClinicaMedica.Medico;

import java.util.Scanner;

public class GerenciamentoUnificado {

    public static void main(String[] args) {
        Clinica clinica = new Clinica();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;

            do {
                System.out.println("\n--- Sistema de Gerenciamento Unificado ---");
                System.out.println("1. Gerenciar Eventos");
                System.out.println("2. Gerenciar Restaurante");
                System.out.println("3. Gerenciar Clínica");
                System.out.println("4. Aplicar Desconto para Médico");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        gerenciarEventos();
                        break;
                    case 2:
                        gerenciarRestaurante();
                        break;
                    case 3:
                        gerenciarClinica();
                        break;
                    case 4:
                        aplicarDescontoMedico(clinica, scanner);
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

    private static void gerenciarEventos() {
        System.out.println("Gerenciando Eventos...");
        Eventos.main(new String[0]);
    }

    private static void gerenciarRestaurante() {
        System.out.println("Gerenciando Restaurante...");
        Restaurante.main(new String[0]);
    }

    private static void gerenciarClinica() {
        System.out.println("Gerenciando Clínica...");
        Clinica.main(new String[0]);
    }

    private static void aplicarDescontoMedico(Clinica clinica, Scanner scanner) {
        System.out.println("Digite o nome do médico para aplicar o desconto:");
        String nomeMedico = scanner.nextLine();
        
        Medico medico = clinica.buscarMedicoPorNome(nomeMedico);
        if (medico != null) {
            System.out.println("Digite o preço original do evento:");
            double precoEvento = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o preço original do restaurante:");
            double precoRestaurante = scanner.nextDouble();
            scanner.nextLine();
            double precoComDescontoEvento = precoEvento * 0.8;
            double precoComDescontoRestaurante = precoRestaurante * 0.8;

            System.out.println("Preço do evento com desconto: " + precoComDescontoEvento);
            System.out.println("Preço do restaurante com desconto: " + precoComDescontoRestaurante);
        } else {
            System.out.println("Médico não encontrado na clínica.");
        }
    }
}

