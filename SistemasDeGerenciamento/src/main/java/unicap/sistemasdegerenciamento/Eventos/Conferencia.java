package unicap.sistemasdegerenciamento.Eventos;

public class Conferencia extends Evento {
    public Conferencia(String nome, String data, Local local, int vagasDisponiveis, double precoEvento) {
        super(nome, data, local, vagasDisponiveis, precoEvento);
    }

    @Override
    public void definirRegras() {
        System.out.println("Conferências podem ter até 500 participantes e incluem coffee breaks.");
    }
}
