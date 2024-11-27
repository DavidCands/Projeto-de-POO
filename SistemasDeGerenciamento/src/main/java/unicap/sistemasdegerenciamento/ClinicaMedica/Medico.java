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
}
