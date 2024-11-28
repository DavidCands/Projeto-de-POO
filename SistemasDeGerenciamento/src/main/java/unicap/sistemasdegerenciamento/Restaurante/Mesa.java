package unicap.sistemasdegerenciamento.Restaurante;

public class Mesa {
    private final int numero;
    private Pedido pedido;
    private boolean ocupada;
    
    public Mesa(int numero){
        this.numero = numero;
        this.ocupada = false;
    }

    public int getNumero(){
        return this.numero;
    }

    public Pedido getPedido(){
        return this.pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean isOcupada(){
        return this.ocupada;
    }
    
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}

class GerenciadorDeMesa {
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
    
    private static int contadorDeIds = 1;
    
    private static int gerarIdDoPedido() {
        return contadorDeIds++;
    }
}
