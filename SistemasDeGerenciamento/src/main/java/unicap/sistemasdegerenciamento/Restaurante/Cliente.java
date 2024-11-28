public class ClienteRestaurante implements Pessoa {
    private String nome;
    private String cpf;

    public ClienteRestaurante(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(nome + " | CPF: " + cpf);
    }

    @Override
    public boolean isMedico() {
        return false;
    }
}
