package unicap.sistemasdegerenciamento.SistemadeGerenciamento;

import unicap.sistemasdegerenciamento.Eventos.Eventos;
import unicap.sistemasdegerenciamento.Eventos.Evento;
import unicap.sistemasdegerenciamento.Eventos.Local;
import unicap.sistemasdegerenciamento.Restaurante.Restaurante;
import unicap.sistemasdegerenciamento.Restaurante.Mesa;
import unicap.sistemasdegerenciamento.ClinicaMedica.Clinica;
import unicap.sistemasdegerenciamento.ClinicaMedica.ClinicaMedica;
import unicap.sistemasdegerenciamento.ClinicaMedica.Medico;
import java.util.Scanner;
import unicap.sistemasdegerenciamento.Restaurante.Pedido;

public class GerenciamentoUnificado {

    public static void main(String[] args) {
        //Evento evento = new Evento()
        Clinica clinica = new Clinica();
        
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;

            do {
                System.out.println("\n--- Sistema de Gerenciamento Unificado ---");
                System.out.println("1. Gerenciar Eventos");
                System.out.println("2. Gerenciar Restaurante");
                System.out.println("3. Gerenciar Clinica");
                System.out.println("4. Aplicar Desconto para Medico");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opcao: ");
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
                        gerenciarClinica(clinica);
                        break;
                    case 4:
                        aplicarDescontoMedico(clinica /*,evento*/);
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
    
    private static void gerenciarEventos() {
        System.out.println("Gerenciando Eventos...");
        Eventos.main(new String[0]);
    }
    
    private static void gerenciarRestaurante() {
        System.out.println("Gerenciando Restaurante...");
        Restaurante.main(new String[0]);
    }
    
    private static void gerenciarClinica(Clinica clinica) {
        System.out.println("Gerenciando Clinica...");
        ClinicaMedica.main(new String[0], clinica);
    }
    
    private static void aplicarDescontoMedico(Clinica clinica) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome do medico para aplicar o desconto: ");
        String nomeMedico = scanner.nextLine();
        Medico medico = clinica.buscarMedicoPorNome(nomeMedico);
        
        if (medico != null) {
            System.out.println("1- Desconto no Evento \n2- Desconto no Restaurante");
            System.out.println("Aonde deseja aplicar o desconto?");
            int opc = scanner.nextInt();
            
            if(opc == 1){
                /*System.out.println("Informe o nome do Evento: ");
                String nomeDoEvento = scanner.nextLine();

                System.out.print("Informe a data do evento (DD/MM/AAAA): ");
                String dataEvento = scanner.nextLine();

                System.out.print("Informe o nome do local: ");
                String nomeLocal = scanner.nextLine();

                System.out.print("Informe o endereco do local: ");
                String enderecoLocal = scanner.nextLine();

                System.out.print("Informe o numero de vagas disponiveis: ");
                int vagasEvento = scanner.nextInt();
                scanner.nextLine();*/

                System.out.print("Informe o preco original do evento: R$");
                double precoEvento = scanner.nextDouble();

                //Local local = new Local(nomeLocal, enderecoLocal);
                //Evento evento = new Evento(nomeDoEvento, dataEvento, local, vagasEvento, precoEvento);

                double precoComDescontoEvento = precoEvento * 0.8;
                System.out.println("Preco do evento com desconto: R$" + precoComDescontoEvento);
            }
            
            else if(opc == 2){
                System.out.println("Informe o preco original da conta do restaurante: R$");
                double precoRestaurante = scanner.nextDouble();
                scanner.nextLine();
                double precoComDescontoRestaurante = precoRestaurante * 0.8;
                System.out.println("Preco do restaurante com desconto: R$" + precoComDescontoRestaurante);
                
                
                /*System.out.print("Informe o ID do pedido: ");
                int idPedido = scanner.nextInt();

                Pedido pedido = new Pedido(0, new Mesa(0)); // Instância temporária para buscar pedidos
                Pedido pedidoDesconto = pedido.buscarPedidoPorId(idPedido);

                if (pedidoDesconto != null) {
                    double totalComDesconto = pedidoDesconto.getTotal() * 0.8; // Aplica 20% de desconto
                    pedidoDesconto.setTotal(totalComDesconto); // Adiciona um setter para 'total' em Pedido

                    System.out.println("Desconto aplicado! Novo total do pedido com desconto: R$" + totalComDesconto);
                } 
                else {
                    System.out.println("Pedido nao encontrado.");
                }*/
            }
            else{
                System.out.println("Opcao invalida!");
            }
            
            //Isso linha debaixo muda o preço do evento para todos os participantes da lista
            //evento.setPrecoEvento(evento.getPrecoEvento() * 0.8);
        }
        else {
            System.out.println("Medico nao encontrado na clinica.");
        }
    }
}
