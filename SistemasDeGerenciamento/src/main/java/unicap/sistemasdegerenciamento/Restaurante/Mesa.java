package unicap.sistemasdegerenciamento.Restaurante;

public class Mesa {
    private int numero;
    private boolean ocupada;
    private Pedido pedido;

    public Mesa(int numero){
        this.numero = numero;
        this.ocupada = false;
    }
    
    public void ocuparMesa(Mesa mesa, String nomeCliente, boolean isMedico) {
        if (!mesa.isOcupada()) {
            mesa.setOcupada(true);
            mesa.setPedido(new Pedido(gerarIdDoPedido(), mesa, nomeCliente, isMedico));
            System.out.println("Mesa " + mesa.getNumero() + " ocupada pelo cliente: " + nomeCliente);
        }
        else {
            System.out.println("A mesa ja esta ocupada!");
        }
    }
    
    public void liberarMesa(Mesa mesa) {
        if (mesa.isOcupada()) {
            mesa.setOcupada(false);
            mesa.setPedido(null);
            System.out.println("Mesa " + mesa.getNumero() + " liberada.");
        } 
        else {
            System.out.println("A mesa ja esta vazia!");
        }
    }
    
    private int contadorDeIds = 1;
    
    private int gerarIdDoPedido() {
        return contadorDeIds++;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Pedido getPedido() {
        return pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }
}
