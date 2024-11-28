package unicap.sistemasdegerenciamento.ClinicaMedica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends Pessoa {
    private int idade;
    private String email;
    private String telefone;
    private List<Consulta> consultas;

    public Paciente(String nome, String cpf, int idade, String email, String telefone) {
        super(nome, cpf);
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.consultas = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }
    public void adicionarConsulta(Medico medico, Date data) {
        Consulta novaConsulta = new Consulta(this, medico, data);
        adicionarConsulta(novaConsulta);
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada para " + getNome());
        } else {
            System.out.println("Consultas de " + getNome() + ":");
            for (Consulta consulta : consultas) {
                System.out.println("Data: " + consulta.getData() + ", Médico: " + consulta.getMedico().getNome());
            }
        }
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
