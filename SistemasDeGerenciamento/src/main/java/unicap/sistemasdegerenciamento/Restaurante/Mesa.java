package unicap.sistemasdegerenciamento.Restaurante;
public class Mesa {
    private int numero;
    private boolean ocupada;
    private Pedido pedido;

    public Mesa(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.pedido = new Pedido();
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void ocupar(Pessoa cliente) {
        this.ocupada = true;
        System.out.println(cliente.getClass().getSimpleName() + " ocupou a mesa " + numero);
    }

    public void liberar() {
        this.ocupada = false;
        System.out.println("Mesa " + numero + " foi liberada.");
    }

    public Pedido getPedido() {
        return pedido;
    }
}
