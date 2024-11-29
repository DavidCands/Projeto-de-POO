package unicap.sistemasdegerenciamento.Eventos;

public class Seminario extends Evento{
    public Seminario(String nome, String data, Local local, int vagasDisponiveis, double precoEvento) {
        super(nome, data, local, vagasDisponiveis, precoEvento);
    }

    @Override
    public void definirRegras() {
        System.out.println("Seminários permitem até 100 participantes e têm um desconto de 10% para grupos.");
    }
}
