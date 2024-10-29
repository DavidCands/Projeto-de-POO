package unicap.sistemasdegerenciamento.ClinicaMedica;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private Date data;
    
    public Consulta(Paciente paciente, Medico medico, Date data) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
    }
    
    public void agendarConsulta() {
        if (medico.isDisponivel()) {
            Consulta consulta = new Consulta(paciente, medico, data);
            medico.setDisponivel(false);
            System.out.println("Consulta agendada com sucesso!");
        }
        else {
            System.out.println("Médico não está disponível.");
        }
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
    
    public Medico getMedico() {
        return medico;
    }
    
    public Date getData() {
        return data;
    }
    
    public String toString() {
        return "Consulta [Paciente: " + paciente.getNome() + ", Médico: " + medico.getNome() + ", Data: " + data + "]";
    }
}
