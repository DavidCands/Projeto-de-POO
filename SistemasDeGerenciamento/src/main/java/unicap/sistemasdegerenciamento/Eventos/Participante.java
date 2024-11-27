package unicap.sistemasdegerenciamento.Eventos;

import unicap.sistemasdegerenciamento.Pessoa;

class Participante extends Pessoa{
    private boolean isEstudante;
    private boolean isMedico;
    private double precoPago;
    
    public Participante(String nome, String email, String telefone, int idade, boolean isEstudante, boolean isMedico, double valorEvento) {
        super(nome, email, telefone, idade);
        this.isEstudante = isEstudante;
        this.isMedico = isMedico;
        if(isEstudante){
            System.out.println("Desconto para o Estudante aplicado!");
            this.precoPago = valorEvento * 0.50;
        }
        else if(isMedico){
            System.out.println("Desconto para o Medico aplicado!");
            this.precoPago = valorEvento * 0.80;
        }
        else{
            this.precoPago = valorEvento;
        }
        this.precoPago = valorEvento;
    }

    public void exibirInformacoes(){
        System.out.println("Informações do Participante:");
        System.out.println("Nome: "+ getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("E-Mail: "+ getEmail());
        System.out.print("Profissão: ");
        if (isEstudante == true){
            System.out.println("Estudadnte");
        }
        else if (isMedico == true){
            System.out.println("Médico");
        }
        System.out.println("Preço a pagar: " +precoPago);
    }
    
    public double getPrecoPago() {
        return precoPago;
    }
    
    public void setPrecoPago(double precoPago) {
        this.precoPago = precoPago;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Idade: " + getIdade());
    }
    
}
