package unicap.sistemasdegerenciamento;

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

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }

    public abstract void exibirInformacoesEspecificas();

    public boolean isMedico() {
        return false; 
    }
}
