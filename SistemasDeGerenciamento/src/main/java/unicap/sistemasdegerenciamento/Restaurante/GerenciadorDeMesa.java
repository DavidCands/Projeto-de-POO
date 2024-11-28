package unicap.sistemasdegerenciamento.Restaurante;

public class GerenciadorDeMesa {
    public static void ocuparMesa(Mesa mesa, String nomeCliente, boolean isMedico) {
        if (!mesa.isOcupada()) {
            mesa.setOcupada(true);
            mesa.setPedido(new Pedido(gerarIdDoPedido(), mesa, nomeCliente, isMedico));
            System.out.println("Mesa " + mesa.getNumero() + " ocupada pelo cliente: " + nomeCliente);
        }
        else {
            System.out.println("A mesa ja esta ocupada!");
        }
    }
    
    public static void liberarMesa(Mesa mesa) {
        if (mesa.isOcupada()) {
            mesa.setOcupada(false);
            mesa.setPedido(null);
            System.out.println("Mesa " + mesa.getNumero() + " liberada.");
        } 
        else {
            System.out.println("A mesa ja esta vazia!");
        }
    }
    
    private static int gerarIdDoPedido() {
        return (int) (Math.random() * 1000);
    }
}
