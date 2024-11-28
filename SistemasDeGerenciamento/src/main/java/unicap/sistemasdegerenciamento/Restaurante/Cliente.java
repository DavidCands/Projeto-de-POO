package unicap.sistemasdegerenciamento.Restaurante;

public class Cliente extends Pessoa {
    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }


    public void exibirInformacoes() {
        System.out.println("Cliente: " + getNome() + ", CPF: " + getCpf());
    }
}

package unicap.sistemasdegerenciamento.Restaurante;

public class Medico extends Pessoa {
    public Medico(String nome, String cpf) {
        super(nome, cpf);
    }


    public void exibirInformacoes() {
        System.out.println("Médico: " + getNome() + ", CPF: " + getCpf());
    }
}
