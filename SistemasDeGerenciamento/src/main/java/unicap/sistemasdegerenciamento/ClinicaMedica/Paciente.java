package unicap.sistemasdegerenciamento.ClinicaMedica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Paciente {
    private String nome;
    private String cpf;
    private int idade;
    private String email;
    private String telefone;
    private List<Consulta> consultas;

    public Paciente(String nome, String cpf, int idade, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.consultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada para " + nome);
        } else {
            System.out.println("Consultas de " + nome + ":");
            for (Consulta consulta : consultas) {
                System.out.println("Data: " + consulta.getData() + ", Médico: " + consulta.getMedico().getNome());
            }
        }
    }

    public void cancelarConsulta(String dataStr) {
        Date dataParaCancelar = null;
        try {
            dataParaCancelar = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido! Use dd/MM/yyyy.");
            return;
        }
        
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
    }
}
