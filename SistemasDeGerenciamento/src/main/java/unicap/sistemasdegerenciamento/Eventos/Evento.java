package unicap.sistemasdegerenciamento.Eventos;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String data;
    private Local local;
    private int vagasDisponiveis;
    private double precoEvento;
    private Participante precoPago;
    private List<Participante> participantes;

    public Evento(String nome, String data, Local local, int vagasDisponiveis, double precoEvento) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.vagasDisponiveis = vagasDisponiveis;
        this.precoEvento = precoEvento;
        this.participantes = new ArrayList<>();
    }

    public void cadastrarParticipante(Participante participante) {
        if (vagasDisponiveis > 0) {
            participantes.add(participante);
            vagasDisponiveis--;
            System.out.println("Participante cadastrado!");
        } else {
            System.out.println("Sem vagas disponíveis!");
        }
    }

    public void removerParticipante(String nomeParticipante) {
        boolean participanteRemovido = participantes.removeIf(participante -> participante.getNome().equals(nomeParticipante));
        if (participanteRemovido) {
            vagasDisponiveis++;
            System.out.println("Participante removido!");
        } else {
            System.out.println("Participante nao encontrado!");
        }
    }

    public void consultarVagas() {
        System.out.println("Vagas disponiveis: " + vagasDisponiveis);
    }

    public void gerarRelatorioParticipacao() {
        System.out.println("\n--- Relatorio de Participantes ---");
        System.out.println("Evento: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Local: " + local.getNome() + ", " + local.getEndereco());
        System.out.println("Participantes:");
        for (Participante participante : participantes) {
            System.out.println("- " + participante.getNome() + " (Idade: " + participante.getIdade() + ", Email: " + participante.getEmail() + ", Preco pago: R$" + participante.getPrecoPago() + ")");
        }
    }

    public void exibirDetalhes() {
        System.out.println("\n--- Detalhes do Evento ---");
        System.out.println("Nome do evento: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Local: " + local.getNome() + " - " + local.getEndereco());
        System.out.println("Vagas disponiveis: " + vagasDisponiveis);
        System.out.println("----------------------------");
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public Local getLocal() {
        return local;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public double getPrecoEvento() {
        return precoEvento;
    }

    public void setPrecoEvento(double precoEvento) {
        this.precoEvento = precoEvento;
    }
    public class Seminario extends Evento {
        public Seminario(String nome, String data, Local local, int vagasDisponiveis, double precoEvento) {
            super(nome, data, local, vagasDisponiveis, precoEvento);
        }

        public void definirRegras() {
            System.out.println("Seminários permitem até 100 participantes e têm um desconto de 10% para grupos.");
        }
    }
    public class Workshop extends Evento {
        public Workshop(String nome, String data, Local local, int vagasDisponiveis, double precoEvento) {
            super(nome, data, local, vagasDisponiveis, precoEvento);
        }

        public void definirRegras() {
            System.out.println("Workshops têm um limite de 50 participantes e incluem material didático.");
        }
    }
    public class Conferencia extends Evento {
        public Conferencia(String nome, String data, Local local, int vagasDisponiveis, double precoEvento) {
            super(nome, data, local, vagasDisponiveis, precoEvento);
        }

        public void definirRegras() {
            System.out.println("Conferências podem ter até 500 participantes e incluem coffee breaks.");
        }
    }
}

    public void setPrecoEvento(double precoEvento) {
        this.precoEvento = precoEvento;
    }
    }
