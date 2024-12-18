package unicap.sistemasdegerenciamento.Restaurante;

public class ItemDoPedido {
    private String nome;
    private int quantidade;
    private double preco;

    public ItemDoPedido(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public double calcularPrecoTotal(){
        return quantidade * preco;
    }
    
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
