package unicap.sistemasdegerenciamento.Restaurante;

public class CalculadoraDeDesconto {
    public static double aplicarDesconto(double total, boolean isMedico){
        if (isMedico) {
            System.out.println("Desconto para o Médico aplicado!");
            return total * 0.80;
        }
        System.out.println("Nenhum desconto aplicado.");
        return total;
    }
}
