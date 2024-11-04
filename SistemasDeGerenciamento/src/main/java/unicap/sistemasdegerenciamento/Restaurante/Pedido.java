package unicap.sistemasdegerenciamento.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private String nome;  
    private Mesa mesa;
    private List<ItemDoPedido> itens;
    private double total;
    private boolean fechado;
    private List<Pedido> pedidos;

    public Pedido(int id, String nome, Mesa mesa) {
        this.id = id;
        this.nome = nome; 
        this.mesa = mesa;
        this.itens = new ArrayList<>();
        this.total = 0.0;
        this.fechado = false;
        this.isMedico = isMedico;
        pedidos = new ArrayList<>();
    }

    public void adicionarItem(ItemDoPedido item) {
        if (!fechado) {
            itens.add(item);
            total += item.calcularPrecoTotal();
        } else {
            System.out.println("O pedido já foi fechado!");
        }
    }

    public void removerItem(String nomeItem, int quantidade) {
        if (!fechado) {
            ItemDoPedido itemARemover = null;

            for (ItemDoPedido item : itens) {
                if (item.getNome().equalsIgnoreCase(nomeItem)) {
                    itemARemover = item;
                    break;
                }
            }

            if (itemARemover != null) {
                if (itemARemover.getQuantidade() > quantidade) {
                    itemARemover.setQuantidade(itemARemover.getQuantidade() - quantidade);
                    total -= itemARemover.getPreco() * quantidade;
                    System.out.println(quantidade + " unidade(s) de " + nomeItem + "(s) removida(s) com sucesso.");
                } else {
                    itens.remove(itemARemover);
                    total -= itemARemover.calcularPrecoTotal();
                    System.out.println("Todas as unidades de " + nomeItem + " foram removidas.");
                }
            } else {
                System.out.println("Item não encontrado.");
            }
        } else {
            System.out.println("O pedido já foi fechado!");
        }
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido ID " + pedido.getId() + " adicionado com sucesso.");
    }

    public void cancelarPedido() {
        if (!fechado) {
            itens.clear();
            total = 0.0;
            System.out.println("O seu pedido foi cancelado. Realize um novo pedido.");
        } else {
            System.out.println("O pedido já foi fechado e não pode ser cancelado.");
        }
    }

    public void fecharPedido() {
        this.fechado = true;
        System.out.println("\n>> Conta Fechada <<");
        System.out.println("Conta Final:");
        this.gerarRelatorio();
    }

    public void reabrirPedido() {
        this.fechado = false;
    }

    public void gerarRelatorio() {
        System.out.println("Pedido ID: " + this.getId());
        System.out.println("Nome do Pedido: " + this.getNome());  
        System.out.println("Mesa: " + this.mesa.getNumero());
        System.out.println("------------------");
        System.out.println("Pedido do Cliente:");

        for (ItemDoPedido item : this.itens) {
            System.out.println(">> " + item.getNome() + " <<");
            System.out.println("+ Quantidade: " + item.getQuantidade());
            System.out.println("+ Preço Unitário: R$" + item.getPreco());
            System.out.println("+ Preço Total: R$" + item.calcularPrecoTotal());
        }

        System.out.println("# Total a pagar: R$" + this.total);

        if (this.fechado) {
            System.out.println("Conta fechada");
        } else {
            System.out.println("Conta aberta");
        }
    }

    public Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        System.out.println("Pedido com ID " + id + " não encontrado.");
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<ItemDoPedido> getItens() {
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

    public boolean isFechado() {
        return fechado;
    }
}
