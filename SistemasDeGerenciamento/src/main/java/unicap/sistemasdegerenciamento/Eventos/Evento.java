package unicap.sistemasdegerenciamento.Eventos;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String data;
    private Local local;
    private int vagasDisponiveis;
    private double precoEvento;
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
            System.out.println("Participante não encontrado!");
        }
    }

    public void consultarVagas() {
        System.out.println("Vagas disponíveis: " + vagasDisponiveis);
    }

    public void gerarRelatorioParticipacao() {
        System.out.println("\n--- Relatório de Participantes ---");
        System.out.println("Evento: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Local: " + local.getNome() + ", " + local.getEndereco());
        System.out.println("Participantes:");
        for (Participante participante : participantes) {
            System.out.println("- " + participante.getNome() + " (Idade: " + participante.getIdade() + ", Email: " + participante.getEmail() + ")");
        }
    }

    public void exibirDetalhes() {
        System.out.println("\n--- Detalhes do Evento ---");
        System.out.println("Nome do evento: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Local: " + local.getNome() + " - " + local.getEndereco());
        System.out.println("Vagas disponíveis: " + vagasDisponiveis);
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
}
