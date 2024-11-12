import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nome;
    private String especialidade;
    private List<LocalDateTime> agendaDisponivel;  

    public Medico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.agendaDisponivel = new ArrayList<>(); 
        preencherAgenda();  
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public List<LocalDateTime> getAgendaDisponivel() {
        return agendaDisponivel;
    }

    public void removerHorario(LocalDateTime horario) {
        agendaDisponivel.remove(horario);  
    }

    private void preencherAgenda() {    
        LocalDateTime dataInicio = LocalDateTime.now().withHour(8).withMinute(0);  
        for (int i = 0; i < 8; i++) {  
            agendaDisponivel.add(dataInicio.plusHours(i));
        }
    }
}
