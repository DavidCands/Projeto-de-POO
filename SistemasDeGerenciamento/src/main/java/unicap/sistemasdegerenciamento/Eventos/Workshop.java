package unicap.sistemasdegerenciamento.Eventos;

public class Workshop extends Evento {
    public Workshop(String nome, String data, Local local, int vagasDisponiveis, double precoEvento) {
        super(nome, data, local, vagasDisponiveis, precoEvento);
    }

    @Override
    public void definirRegras() {
        System.out.println("Workshops têm um limite de 50 participantes e incluem material didático.");
    }
}
