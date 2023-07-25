import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class A06EX01 {
    // Enum para representar os estados e suas taxas de imposto
    enum Estado {
        MG(0.07),
        SP(0.12),
        RJ(0.15);

        private final double taxaImposto;

        Estado(double taxaImposto) {
            this.taxaImposto = taxaImposto;
        }

        public double getTaxaImposto() {
            return taxaImposto;
        }
    }

    public static void main(String[] args) {
        System.out.println(valorProdutoFinal(250.10, Estado.MG) == 267.607);
        System.out.println(valorProdutoFinal(250.10, Estado.RJ) == 287.615);
        System.out.println(valorProdutoFinal(250.10, Estado.SP) == 280.112);
    }

    public static double valorProdutoFinal(double valorProduto, Estado estado) {
        // Calcula o valor final do produto com base na taxa de imposto do estado
        double valorFinal = valorProduto * (1 + estado.getTaxaImposto());
        // Arredonda o resultado para 4 casas decimais
        return arredondar(valorFinal);
    }

    public static double arredondar(double numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.####", symbols);
        return Double.parseDouble(decimalFormat.format(numero));
    }
}
