package unicap.sistemasdegerenciamento.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Mesa mesa;
    private List<ItemDoPedido> itens;
    private double total;
    private boolean fechado;
    private List<Pedido> pedidos;

    public Pedido(int id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
        this.itens = new ArrayList<>();
        this.total = 0.0;
        this.fechado = false;
        pedidos = new ArrayList<>();
    }

    public void adicionarItem(ItemDoPedido item){
        if(fechado == false){
            itens.add(item);
            total += item.calcularPrecoTotal();
        }
        else{
            System.out.println("O pedido ja foi fechado!");
        }
    }

    public void removerItem(String nomeItem, int quantidade) {
        if(fechado == false){
            ItemDoPedido itemARemover = null;

            for(ItemDoPedido item : itens){
                if(item.getNome().equalsIgnoreCase(nomeItem)){
                    itemARemover = item;
                    break;
                }
            }

            if(itemARemover != null){
                if(itemARemover.getQuantidade() > quantidade){
                    itemARemover.setQuantidade(itemARemover.getQuantidade() - quantidade);
                    total -= itemARemover.getPreco() * quantidade;
                    System.out.println(quantidade+ " unidade(s) de " +nomeItem+ "(s) removida(s) com sucesso.");
                }
                else {
                    itens.remove(itemARemover);
                    total -= itemARemover.calcularPrecoTotal();
                    System.out.println("Todas as unidades de " +nomeItem+ " foram removidas.");
                }
            }
            else {
                System.out.println("Item nao encontrado.");
            }
        }
        else {
            System.out.println("O pedido ja foi fechado!");
        }
    }
    
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido ID " + pedido.getId() + " adicionado com sucesso.");
    }
    
    public void cancelarPedido(){
        if(fechado == false){
            itens.clear();
            total = 0.0;
            System.out.println("O seu pedido foi cancelado. Realize um novo pedido.");
        } 
        else{
            System.out.println("O pedido já foi fechado e nao pode ser cancelado.");
        }
    }
    
    public void fecharPedido(){
        this.fechado = true;
        System.out.println("\n>>Conta Fechada<<");
        System.out.println("Conta Final:");
        this.gerarRelatorio();
    }
    
    public void reabrirPedido(){
        this.fechado = false;
    }
    
    public void gerarRelatorio(){
        System.out.println("Pedido ID: " + this.getId());
        System.out.println("Mesa: " + this.mesa.getNumero());
        System.out.println("------------------");
        System.out.println("Pedido do Cliente:");

        for(ItemDoPedido item : this.itens){
            System.out.println(">> " +item.getNome()+ " <<");
            System.out.println("+Quantidade: " +item.getQuantidade());
            System.out.println("+Preco Unitario: R$" +item.getPreco());
            System.out.println("+Preco Total: R$" +item.calcularPrecoTotal());
        }

        System.out.println("#Total a pagar: R$" +this.total);
        
        if(this.fechado == true){
            System.out.println("Conta fechada");
        }
        else{
            System.out.println("Conta aberta");
        }
    }
    
    public Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        System.out.println("Pedido com ID " + this.getId() + " não encontrado.");
        return null;
    }

    public int getId(){
        return id;
    }

    public Mesa getMesa(){
        return mesa;
    }

    public List<ItemDoPedido> getItens(){
        return itens;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isFechado(){
        return fechado;
    }
}
