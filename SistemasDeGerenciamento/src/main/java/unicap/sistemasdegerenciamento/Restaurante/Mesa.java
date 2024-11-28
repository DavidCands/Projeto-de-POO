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

    public void ocuparMesa(Pessoa pessoa) {
        this.ocupada = true;
        System.out.println("Mesa " + numero + " ocupada por " + pessoa.getNome());

        if (pessoa instanceof Medico) {
            System.out.println(pessoa.getNome() + " é um médico.");
        }
    }

    public void liberarMesa() {
        this.ocupada = false;
        System.out.println("Mesa " + numero + " liberada.");
    }

    public Pedido getPedido() {
        return pedido;
    }
}
