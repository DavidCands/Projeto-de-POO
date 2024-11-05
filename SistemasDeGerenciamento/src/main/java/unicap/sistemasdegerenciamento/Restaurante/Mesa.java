package unicap.sistemasdegerenciamento.Restaurante;

public class Mesa {
    private final int numero;
    private Pedido pedido;
    private boolean ocupada;
    
    public Mesa(int numero){
        this.numero = numero;
        this.ocupada = false;
    }
    
    private int gerarIdDoPedido(){
        return (int)(Math.random() * 1000);
    }
    
    public void ocuparMesa(String nomeCliente, boolean isMedico){
        if(ocupada == false){
            ocupada = true;
            this.pedido = new Pedido(gerarIdDoPedido(), this, nomeCliente, isMedico);
        }
        else{
            System.out.println("A mesa esta ocupada!");
        }
    }
    
    public void liberarMesa(){
        ocupada = false;
        pedido = null;
    }

    public int getNumero(){
        return this.numero;
    }

    public Pedido getPedido(){
        return this.pedido;
    }

    public boolean isOcupada(){
        return this.ocupada;
    }
}
