package unicap.sistemasdegerenciamento.ClinicaMedica;

public class Medico extends Pessoa {
    private String especialidade;
    private boolean disponivel;

    public Medico(String nome, String cpf, String especialidade) {
        super(nome, cpf);
        this.especialidade = especialidade;
        this.disponivel = true;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void exibirInformacoes() {
        System.out.println("Médico: " + getNome());
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
    }

    public void exibirInformacoes(boolean mostrarCPF) {
        exibirInformacoes();
        if (mostrarCPF) {
            System.out.println("CPF: " + getCpf());
        }
    }

    public void setDisponivel(boolean disponivel, String mensagem) {
        this.disponivel = disponivel;
        System.out.println(mensagem);
    }

    public void setDisponivel(boolean disponivel, String mensagem, String motivo) {
        this.disponivel = disponivel;
        System.out.println(mensagem + " Motivo: " + motivo);
    }
}
