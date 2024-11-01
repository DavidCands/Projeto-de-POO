package unicap.sistemasdegerenciamento.Eventos;

class Participante {
    private String nome;
    private String email;
    private String telefone;
    private int idade;
    private boolean isEstudante;
    private double precoPago;
    
    public Participante(String nome, String email, String telefone, int idade, boolean isEstudante) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
        this.isEstudante = isEstudante;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getIdade() {
        return idade;
    }
    
    public double getPrecoPago() {
        return precoPago;
    }
    
    public void setPrecoPago(double precoPago) {
        this.precoPago = precoPago;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Idade: " + idade);
    }
    public double calcularDesconto(double valorEvento) {
        return isEstudante ? valorEvento * 0.50 : valorEvento;
    }
}
