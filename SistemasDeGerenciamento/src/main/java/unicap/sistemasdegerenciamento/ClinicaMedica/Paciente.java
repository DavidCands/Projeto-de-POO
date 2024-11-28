package unicap.sistemasdegerenciamento.ClinicaMedica;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

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

    @Override
    public void exibirInformacoes() {
        System.out.println("Paciente: " + getNome() + ", CPF: " + getCpf() + ", Idade: " + idade + ", Email: " + email + ", Telefone: " + telefone);
    }
    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
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

    public void cancelarConsulta(String dataStr) {
        try {
            Date dataParaCancelar = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
            Consulta consultaParaRemover = null;
            for (Consulta consulta : consultas) {
                if (consulta.getData().equals(dataParaCancelar)) {
                    consultaParaRemover = consulta;
                    break;
                }
            }

            if (consultaParaRemover != null) {
                consultas.remove(consultaParaRemover);
                System.out.println("Consulta cancelada com sucesso.");
            } else {
                System.out.println("Consulta não encontrada na data especificada.");
            }
        } catch (ParseException e) {
            System.out.println("Formato de data inválido! Use dd/MM/yyyy.");
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
