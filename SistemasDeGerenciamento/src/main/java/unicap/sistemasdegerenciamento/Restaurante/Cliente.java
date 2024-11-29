package unicap.sistemasdegerenciamento.Restaurante;

import unicap.sistemasdegerenciamento.Pessoa;

public class Cliente extends Pessoa {

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public void exibirDetalhesAdicionais() {
        System.out.println("Detalhes adicionais do cliente: Nenhum detalhe específico.");
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Cliente: " + getNome() + ", CPF: " + getCpf());
    }
}
