package unicap.sistemasdegerenciamento.SistemadeGerenciamento;
 
import unicap.sistemasdegerenciamento.Eventos.*;
import unicap.sistemasdegerenciamento.Restaurante.*;
import unicap.sistemasdegerenciamento.ClinicaMedica.*;
 
import java.util.Scanner;
 
public class GerenciamentoUnificado {
 
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            
            do {
                System.out.println("\n--- Sistema de Gerenciamento Unificado ---");
                System.out.println("1. Gerenciar Eventos");
                System.out.println("2. Gerenciar Restaurante");
                System.out.println("3. Gerenciar Clínica");
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
        Eventos.main(new String[0]);
    }
 
    private static void gerenciarRestaurante() {
        Restaurante restaurante = new Restaurante();  
        Restaurante.main(new String[0]);              
    }
 
    private static void gerenciarClinica() {
        Clinica clinica = new Clinica();  
        clinica.main(new String[0]);
        public static void main(String[] args) {
        Clinica clinica = new Clinica();
        
        Medico medico1 = new Medico("Dr. João", "Cardiologista");
        clinica.cadastrarMedico(medico1);

        Evento evento = new Evento(200.00);
        Restaurante restaurante = new Restaurante(100.00); 

        double precoComDescontoEvento = evento.aplicarDescontoMedico(clinica, medico1);
        double precoComDescontoRestaurante = restaurante.aplicarDescontoMedico(clinica, medico1);

        System.out.println("Preço do evento com desconto: " + precoComDescontoEvento);
        System.out.println("Preço do restaurante com desconto: " + precoComDescontoRestaurante);
    }
}
    }
}
