public class A04EX02 {
    public static double calculoSalario(double[] input) {
        int tempoDeServico = (int) input[0];
        double inflacao = input[1];
        double salarioAtual = input[2];

        double percentualReajuste;

        if (tempoDeServico < 5) {
            percentualReajuste = 1.0 + inflacao;
        } else if (tempoDeServico < 10) {
            percentualReajuste = 1.5 + inflacao;
        } else {
            percentualReajuste = 2.0 + inflacao;
        }

        double novoSalario = salarioAtual * (1 + percentualReajuste / 100);

        return Math.round(novoSalario * 100) / 100.0;
    }

    public static void main(String[] args) {
        double[] input = {1, 5.0, 2000.00};
        double novoSalario = calculoSalario(input);
        System.out.println(novoSalario);
    }
}
