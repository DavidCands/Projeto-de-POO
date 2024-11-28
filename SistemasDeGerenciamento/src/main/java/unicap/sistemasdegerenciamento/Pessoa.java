package unicap.sistemasdegerenciamento.Restaurante;

public abstract class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public abstract void exibirInformacoes();
    
    public void exibirInformacoes(String tipo) {
        System.out.println("Nome: " + nome + ", CPF: " + cpf + ", Tipo: " + tipo);
    }
}
