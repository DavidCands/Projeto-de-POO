package unicap.sistemasdegerenciamento.Restaurante;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SistemaGerenciamentoRestaurante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mesa> mesas = new ArrayList<>();
        int cont = 1;

        for (int i = 0; i < 5; i++) {
            Mesa mesa = new Mesa(cont);
            mesas.add(mesa);
            cont++;
        }

        int resposta, opcMesa, opcConta, opcCancelarP, opcPedido, opcMais, quant, opcRemoverItem;

        do {
            System.out.println("\n--- Sistema de Gerenciamento de Restaurante ---");
            System.out.println("Essas são as mesas existentes:");
            for (Mesa mesa : mesas) {
                System.out.println("Mesa " + mesa.getNumero() + " ocupada: " + mesa.isOcupada());
            }

            System.out.println("Onde você gostaria de se sentar?");
            opcMesa = scanner.nextInt();
            while (mesas.get(opcMesa - 1).isOcupada()) {
                System.out.println("Essa mesa está ocupada, por favor, escolha uma mesa vaga dentre as opções: ");
                opcMesa = scanner.nextInt();
            }

            Mesa mesaEscolhida = mesas.get(opcMesa - 1);
            scanner.nextLine();
            System.out.print("Informe o seu nome: ");
            String nomeCliente = scanner.nextLine();
            System.out.print("Você é um médico? (1 - Sim | 2 - Não): ");
            int opcMedico = scanner.nextInt();
            Pessoa cliente;

            if (opcMedico == 1) {
                
                cliente = new Medico(nomeCliente, "12345678900");
            } else {
                
                cliente = new Cliente(nomeCliente, "12345678900");
            }

            mesaEscolhida.ocuparMesa(cliente);
            Pedido pedido = mesaEscolhida.getPedido();

            do {
                exibirCardapio();
                do {
                    System.out.println("Qual será o seu pedido? ");
                    opcPedido = scanner.nextInt();
                    System.out.println("Informe a quantidade: ");
                    quant = scanner.nextInt();

                    ItemDoPedido item = criarItemPedido(opcPedido, quant);
                    pedido.adicionarItem(item);

                    System.out.println("Algo mais[1- Sim | 2- Não]? ");
                    opcMais = scanner.nextInt();
                } while (opcMais == 1);

                System.out.println("\nRelatório de Pedido da Mesa " + mesaEscolhida.getNumero() + ": ");
                pedido.gerarRelatorio();

                System.out.println("\nVocê deseja remover algum item do seu pedido[1- Sim | 2- Não]? ");
                opcRemoverItem = scanner.nextInt();

                if (opcRemoverItem == 1) {
                    scanner.nextLine();
                    int opcRemoverItem2;
                    do {
                        System.out.println("Informe o nome do item que deseja remover: ");
                        String nomeItemRemover = scanner.nextLine();

                        System.out.println("Informe a quantidade de " + nomeItemRemover + " que deseja remover: ");
                        int quantItemRemover = scanner.nextInt();

                        pedido.removerItem(nomeItemRemover, quantItemRemover);
                        System.out.println("\nRelatório atualizado de Pedido da Mesa " + mesaEscolhida.getNumero() + ": ");
                        pedido.gerarRelatorio();

                        System.out.println("\nDeseja remover mais algum item do seu pedido[1- Sim | 2- Não]? ");
                        opcRemoverItem2 = scanner.nextInt();
                    } while (opcRemoverItem2 == 1);
                }

                System.out.println("Você deseja cancelar o seu pedido[1- Sim | 2- Não]?");
                opcCancelarP = scanner.nextInt();
                if (opcCancelarP == 1) {
                    pedido.fecharPedido();
                }
            } while (!pedido.fecharPedido());

            System.out.println("Gostaria de fechar a conta[1- Sim | 2- Não]?");
            opcConta = scanner.nextInt();
            if (opcConta == 1) {
                pedido.fecharPedido();
                mesaEscolhida.liberarMesa();
            }

            System.out.println("\nDeseja prosseguir [1- Sim | 2- Não]? ");
            resposta = scanner.nextInt();
        } while (resposta == 1);
        scanner.close();
    }

    private static void exibirCardapio() {
        System.out.println("\n>> Cardápio <<");
        System.out.println("1- Pizza(R$20.00) \n2- Refrigerante(R$7.00)  \n3- Hamburguer(R$10.00) \n4- Batata Frita(R$8.00)");
        System.out.println("5- Jarra de Suco (R$6.00) \n6- Parmegiana (R$32.00) \n7- H2O (R$5.00)");
    }

    private static ItemDoPedido criarItemPedido(int opcPedido, int quantidade) {
        switch (opcPedido) {
            case 1:
                return new ItemDoPedido("Pizza", quantidade, 20.00);
            case 2:
                return new ItemDoPedido("Refrigerante", quantidade, 7.00);
            case 3:
                return new ItemDoPedido("Hamburguer", quantidade, 10.00);
            case 4:
                return new ItemDoPedido("Batata Frita", quantidade, 8.00);
            case 5:
                return new ItemDoPedido("Jarra de Suco", quantidade, 6.00);
            case 6:
                return new ItemDoPedido("Parmegiana", quantidade, 32.00);
            case 7:
                return new ItemDoPedido("H2O", quantidade, 5.00);
            default:
                System.out.println("Opção inválida. Item não adicionado.");
                return null;
        }
    }
}
