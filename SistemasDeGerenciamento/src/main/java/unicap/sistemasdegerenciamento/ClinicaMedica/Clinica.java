package unicap.sistemasdegerenciamento.ClinicaMedica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clinica {
    private List<Pessoa> pessoas;
    private List<Consulta> consultas;

    public Clinica() {
        pessoas = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public Medico buscarMedicoPorNome(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Medico && pessoa.getNome().equalsIgnoreCase(nome)) {
                return (Medico) pessoa;
            }
        }
        return null;
    }

    public Paciente buscarPacientePorNome(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Paciente && pessoa.getNome().equalsIgnoreCase(nome)) {
                return (Paciente) pessoa;
            }
        }
        return null;
    }

    public void agendarConsulta(Paciente paciente, Medico medico, Date data) {
        if (medico.isDisponivel()) {
            Consulta consulta = new Consulta(paciente, medico, data);
            consultas.add(consulta);
            medico.setDisponivel(false);
            System.out.println("Consulta agendada com sucesso!");
        } else {
            System.out.println("Médico não está disponível.");
        }
    }

    public void buscarConsultas() {
        System.out.println("Relatório de Consultas:");
        for (Consulta consulta : consultas) {
            System.out.println(consulta);
        }
    }

    public void exibirInformacoesPessoas() {
        for (Pessoa pessoa : pessoas) {
            pessoa.exibirInformacoes();  
        }
    }
}
