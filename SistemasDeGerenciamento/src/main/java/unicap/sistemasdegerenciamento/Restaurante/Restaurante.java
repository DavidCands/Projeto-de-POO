package unicap.sistemasdegerenciamento.Restaurante;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import unicap.sistemasdegerenciamento.ClinicaMedica.Clinica;

public class Restaurante {
    
    public static void main(String[] args, Clinica clinica) {
        Scanner scanner = new Scanner(System.in);
        List<Mesa> mesas = new ArrayList<>();
        int cont = 1;
        
        for(int i = 0; i < 5; i++){
            Mesa mesa = new Mesa(cont);
            mesas.add(mesa);
            cont++;
        }
        
        int resposta, opcMesa, opcConta, opcCancelarP, opcPedido, opcMais, quant, opcRemoverItem;
        boolean pedidoCancelado;
        
        do{
            System.out.println("\n--- Sistema de Gerenciamento de Restaurante ---");
            System.out.println("Essas sao as mesas existentes:");
            for(Mesa mesa : mesas){
                System.out.println("Mesa " +mesa.getNumero()+ " ocupada: " +mesa.isOcupada());
            }
            
            System.out.println("Onde voce gostaria de se sentar?");
            System.out.println("1. Mesa 1 \n2. Mesa 2 \n3. Mesa 3 \n4. Mesa 4 \n5. Mesa 5");
            opcMesa = scanner.nextInt();
            while(mesas.get(opcMesa - 1).isOcupada()){
                System.out.println("Essa mesa esta ocupada, por favor, escolha uma mesa vaga dentre as opcoes: ");
                opcMesa = scanner.nextInt();
            }

            Mesa mesaEscolhida = mesas.get(opcMesa - 1);
            scanner.nextLine();
            System.out.print("Informe o seu nome: ");
            String nomeCliente = scanner.nextLine();
            boolean isMedico = clinica.buscarMedicoPorNome(nomeCliente) != null;
            
            GerenciadorDeMesa.ocuparMesa(mesaEscolhida, nomeCliente, isMedico);
            Pedido pedido = mesaEscolhida.getPedido();

            for(Mesa mesa : mesas){
                System.out.println("Mesa " +mesa.getNumero()+ " ocupada: " +mesa.isOcupada());
            }
            
            do{
                exibirCardapio();
                do{
                    System.out.println("Qual sera o seu pedido? ");
                    opcPedido = scanner.nextInt();
                    System.out.println("Informe a quantidade: ");
                    quant = scanner.nextInt();

                    ItemDoPedido item = criarItemPedido(opcPedido, quant);
                    pedido.adicionarItem(item);

                    System.out.println("Algo mais[1- Sim | 2- Nao]? ");
                    opcMais = scanner.nextInt();
                }while(opcMais == 1);
                
                System.out.println("\nRelatorio de Pedido da Mesa " +mesaEscolhida.getNumero()+ ": ");
                GeradorDeRelatorio.gerarRelatorio(pedido);

                System.out.println("\nVoce deseja remover algum item do seu pedido[1- Sim | 2- Nao]? ");
                opcRemoverItem = scanner.nextInt();
                
                if(opcRemoverItem == 1){
                    scanner.nextLine();
                    int opcRemoverItem2;
                    do{
                        System.out.println("Informe o nome do item que deseja remover: ");
                        String nomeItemRemover = scanner.nextLine();
                        
                        System.out.println("Informe a quantidade de " +nomeItemRemover+ " que deseja remover: ");
                        int quantItemRemover = scanner.nextInt();
                    
                        pedido.removerItem(nomeItemRemover, quantItemRemover);
                        System.out.println("\nRelatorio atualizado de Pedido da Mesa " +mesaEscolhida.getNumero()+ ": ");
                        GeradorDeRelatorio.gerarRelatorio(pedido);
                        
                        System.out.println("\nDeseja remover mais algum item do seu pedido[1- Sim | 2- Nao]? ");
                        opcRemoverItem2 = scanner.nextInt();
                        scanner.nextLine();
                    }while(opcRemoverItem2 == 1);
                }
                
                System.out.println("Voce deseja cancelar o seu pedido[1- Sim | 2- Nao]?");
                opcCancelarP = scanner.nextInt();
                if(opcCancelarP == 1){
                    pedido.cancelarPedido();
                    pedidoCancelado = true;
                }
                else{
                    pedidoCancelado = false;
                }
            }while(pedidoCancelado == true);
            
            System.out.println("Gostaria de fechar a conta[1- Sim | 2- Nao]?");
            opcConta = scanner.nextInt();
            if(opcConta == 1){
                pedido.fecharPedido();
                GerenciadorDeMesa.liberarMesa(mesaEscolhida);
            }
            
            System.out.println("\nDeseja prosseguir [1- Sim | 2- Nao]? ");
            resposta = scanner.nextInt();
        }while(resposta == 1);
    }

    private static void exibirCardapio(){
        System.out.println("\n>> Cardapio <<");
        System.out.println("1- Pizza(R$20.00) \n2- Refrigerante(R$7.00)  \n3- Hamburguer(R$10.00) \n4- Batata Frita(R$8.00)");
        System.out.println("5- Jarra de Suco (R$6.00) \n6- Parmegiana (R$32.00) \n7- H2O (R$5.00)");
    }
    
    private static ItemDoPedido criarItemPedido(int opcPedido, int quantidade){
        switch(opcPedido){
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
                System.out.println("Opção invalida. Item nao adicionado.");
                return null;
        }
    }
}
