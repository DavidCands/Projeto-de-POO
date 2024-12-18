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
    private boolean isMedico; 

    public Pedido(int id, Mesa mesa, String nomeCliente, boolean isMedico) {
        this.id = id;
        this.mesa = mesa;
        this.itens = new ArrayList<>();
        this.total = 0.0;
        this.fechado = false;
        this.pedidos = new ArrayList<>();
        this.isMedico = isMedico;
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
        this.total = CalculadoraDeDesconto.aplicarDesconto(this.total, this.isMedico);
        this.fechado = true;
        System.out.println("\n>> Conta Fechada <<");
        System.out.println("Conta Final:");
        GeradorDeRelatorio.gerarRelatorio(this);
    }

    public void reabrirPedido() {
        this.fechado = false;
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

class CalculadoraDeDesconto {
    public static double aplicarDesconto(double total, boolean isMedico){
        if (isMedico) {
            System.out.println("Desconto para o Médico aplicado!");
            return total * 0.80;
        }
        System.out.println("Nenhum desconto aplicado.");
        return total;
    }
}

class GeradorDeRelatorio {
    public static void gerarRelatorio(Pedido pedido) {
        System.out.println("Pedido ID: " + pedido.getId());
        System.out.println("Mesa: " + pedido.getMesa().getNumero());
        System.out.println("------------------");
        System.out.println("Pedido do Cliente: ");

        for (ItemDoPedido item : pedido.getItens()) {
            System.out.println(">> " + item.getNome() + " <<");
            System.out.println("+ Quantidade: " + item.getQuantidade());
            System.out.println("+ Preco Unitario: R$" + item.getPreco());
            System.out.println("+ Preco Total: R$" + item.calcularPrecoTotal());
        }

        System.out.println("# Total a pagar: R$" + pedido.getTotal());

        if (pedido.isFechado()) {
            System.out.println("Conta fechada");
        } else {
            System.out.println("Conta aberta");
        }
    }
}