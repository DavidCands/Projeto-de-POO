package unicap.sistemasdegerenciamento.SistemadeGerenciamento;

import unicap.sistemasdegerenciamento.Eventos.Eventos;
import unicap.sistemasdegerenciamento.Restaurante.Restaurante;
import unicap.sistemasdegerenciamento.ClinicaMedica.Clinica;
import unicap.sistemasdegerenciamento.ClinicaMedica.ClinicaMedica;
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
                System.out.println("3. Gerenciar Clinica");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opcao: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        gerenciarEventos(clinica);
                        break;
                    case 2:
                        gerenciarRestaurante(clinica);
                        break;
                    case 3:
                        gerenciarClinica(clinica);
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opcao invalida! Tente novamente.");
                        break;
                }
            } while (opcao != 0);
        }
    }
    
    private static void gerenciarEventos(Clinica clinica) {
        System.out.println("Gerenciando Eventos...");
        Eventos.main(new String[0], clinica);
    }
    
    private static void gerenciarRestaurante(Clinica clinica) {
        System.out.println("Gerenciando Restaurante...");
        Restaurante.main(new String[0], clinica);
    }
    
    private static void gerenciarClinica(Clinica clinica) {
        System.out.println("Gerenciando Clinica...");
        ClinicaMedica.main(new String[0], clinica);
    }
}   
    /*private static void aplicarDescontoMedico(Clinica clinica) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome do medico para aplicar o desconto: ");
        String nomeMedico = scanner.nextLine();
        Medico medico = clinica.buscarMedicoPorNome(nomeMedico);
        
        if (medico != null) {
            System.out.println("1- Desconto no Evento \n2- Desconto no Restaurante");
            System.out.println("Aonde deseja aplicar o desconto?");
            int opc = scanner.nextInt();
            
            if(opc == 1){
                

                System.out.print("Informe o preco original do evento: R$");
                double precoEvento = scanner.nextDouble();


                double precoComDescontoEvento = precoEvento * 0.8;
                System.out.println("Preco do evento com desconto: R$" + precoComDescontoEvento);
            }
            
            else if(opc == 2){
                System.out.println("Informe o preco original da conta do restaurante: R$");
                double precoRestaurante = scanner.nextDouble();
                scanner.nextLine();
                double precoComDescontoRestaurante = precoRestaurante * 0.8;
                System.out.println("Preco do restaurante com desconto: R$" + precoComDescontoRestaurante);
                
            }
            else{
                System.out.println("Opcao invalida!");
            }
        }
        else {
            System.out.println("Medico nao encontrado na clinica.");
        }
    }*/
