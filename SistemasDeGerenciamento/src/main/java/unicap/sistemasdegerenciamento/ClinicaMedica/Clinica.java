package unicap.sistemasdegerenciamento.ClinicaMedica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clinica {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public Clinica() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public Medico buscarMedicoPorNome(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equalsIgnoreCase(nome)) {
                return medico;
            }
        }
        return null;
    }

    public Paciente buscarPacientePorNome(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                return paciente;
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

    public void agendarConsulta(Paciente paciente, Medico medico) {
        agendarConsulta(paciente, medico, new Date());
    }
    
    public void agendarConsulta(String nomePaciente, String nomeMedico, Date data) {
        Paciente paciente = buscarPacientePorNome(nomePaciente);
        Medico medico = buscarMedicoPorNome(nomeMedico);
        if (paciente != null && medico != null) {
            agendarConsulta(paciente, medico, data);
        } else {
            System.out.println("Paciente ou médico não encontrados.");
        }
    }

    public void buscarConsultas() {
        System.out.println("Relatório de Consultas:");
        for (Consulta consulta : consultas) {
            System.out.println(consulta);
        }
    }
}
