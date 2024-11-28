package unicap.sistemasdegerenciamento.Restaurante;

public class Cliente extends Pessoa {

    public Cliente(String nome, boolean isMedico) {
        super(nome, isMedico);
    }
    public void exibirInformacoes() {
        System.out.println("Cliente: " + nome);
    }
}
