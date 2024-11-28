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
