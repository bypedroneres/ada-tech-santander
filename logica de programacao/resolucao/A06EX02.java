import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class A06EX02 {
    // Definição do enum Estado para representar os estados e suas respectivas taxas de imposto.
    public enum Estado {
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
        try {
            // Testes dos cálculos de preço final para diferentes estados e arredondamento.
            System.out.println(arredondar(valorProdutoFinal(250.10, Estado.MG)) == 267.607);
            System.out.println(arredondar(valorProdutoFinal(250.10, Estado.RJ)) == 287.615);
            System.out.println(arredondar(valorProdutoFinal(250.10, Estado.SP)) == 280.112);

            // Teste de lançamento da exceção para estado inválido.
            valorProdutoFinal(250.10, Estado.valueOf("DF")); // Essa linha deve lançar a exceção EstadoInvalidoException.
        } catch (EstadoInvalidoException e) {
            System.out.println("Estado inválido!");
        }
    }

    // Método para calcular o preço final do produto com base no estado de destino e sua taxa de imposto.
    public static double valorProdutoFinal(double valorProduto, Estado estadoDestino) throws EstadoInvalidoException {
        if (estadoDestino == null) {
            throw new EstadoInvalidoException();
        }

        // Obtém a taxa de imposto correspondente ao estado de destino e calcula o preço final.
        double taxaImposto = estadoDestino.getTaxaImposto();
        double precoFinal = valorProduto * (1 + taxaImposto);
        return arredondar(precoFinal);
    }

    // Método para arredondar um número com 4 casas decimais.
    public static double arredondar(double numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.####", symbols);
        return Double.parseDouble(decimalFormat.format(numero));
    }
}

// Classe customizada de exceção para representar o caso de um estado inválido.
class EstadoInvalidoException extends Exception {
    public EstadoInvalidoException() {
        super("Estado inválido!");
    }
}
