package unicap.sistemasdegerenciamento.ClinicaMedica;

public class Medico extends Pessoa implements Agendavel {
    private String especialidade;
    private boolean disponivel;

    public Medico(String nome, String cpf, String especialidade) {
        super(nome, cpf);
        this.especialidade = especialidade;
        this.disponivel = true;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Médico: " + getNome() + ", CPF: " + getCpf() + ", Especialidade: " + especialidade + ", Disponível: " + (disponivel ? "Sim" : "Não"));
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
