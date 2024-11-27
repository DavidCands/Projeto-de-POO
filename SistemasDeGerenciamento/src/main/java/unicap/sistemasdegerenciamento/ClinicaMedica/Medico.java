package unicap.sistemasdegerenciamento.ClinicaMedica;

public class Medico extends Pessoa {
    private String especialidade;
    private boolean disponivel;

    public Medico(String nome, String cpf, String especialidade) {
        super(nome, cpf); 
        this.especialidade = especialidade;
        this.disponivel = true;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Médico: " + getNome() + ", CPF: " + getCpf() + ", Especialidade: " + especialidade + ", Disponível: " + disponivel);
    }

    public void atenderConsulta(Consulta consulta) {
        System.out.println("Atendendo consulta de " + consulta.getPaciente().getNome());
    }

    public void atualizarDisponibilidade(boolean disponibilidade) {
        this.disponivel = disponibilidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
