package unicap.sistemasdegerenciamento.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemDoPedido> itens;
    private boolean fechado;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.fechado = false;
    }

    public void adicionarItem(ItemDoPedido item) {
        if (!fechado) {
            itens.add(item);
            System.out.println("Item " + item.getNome() + " adicionado.");
        } else {
            System.out.println("Pedido já fechado, não é possível adicionar itens.");
        }
    }

    public void removerItem(String nomeItem, int quantidade) {
        if (!fechado) {
            for (ItemDoPedido item : itens) {
                if (item.getNome().equalsIgnoreCase(nomeItem)) {
                    item.removerQuantidade(quantidade);
                    System.out.println(quantidade + " unidades de " + nomeItem + " removidas.");
                    return;
                }
            }
        }
        System.out.println("Item não encontrado ou pedido fechado.");
    }

    public void fecharPedido() {
        fechado = true;
        System.out.println("Pedido fechado.");
    }

    public void gerarRelatorio() {
        System.out.println("Relatório do Pedido:");
        for (ItemDoPedido item : itens) {
            System.out.println(item.getNome() + " - " + item.getQuantidade() + " unidades - R$" + item.getPreco());
        }
    }
}
