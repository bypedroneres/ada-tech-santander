
import java.text.DecimalFormat;
import java.util.Arrays;

public class A04EX01 {
    public static void main(String[] args) {
        double[][] entradas = {
                {100000.00, 12000.00, 20000.00},
                {115500.00,25000.00, 32500.00},
                {121000.0, 14350.0, 21450.0},
                {238500.0, 18350.0, 32450.0},
                {53000.0, 2350.0, 8450.0},
                {1250000.0, 124550.0, 225450.0},
                {145000.0, 12550.0, 22450.0},
                {173000.0, 12450.0, 22540.0},
                {111000.0, 12455.0, 22550.0},
                {123000.0, 8550.0, 25450.0},
                {92000.0, 5450.0, 16450.0}
        };

        double[][] saidas = {
                {12.00, 20.00},
                {21.65, 28.14},
                {11.86, 17.73},
                {7.69, 13.61},
                {4.43, 15.94},
                {9.96, 18.04},
                {8.66, 15.48},
                {7.20, 13.03},
                {11.22, 20.32},
                {6.95, 20.69},
                {5.92, 17.88}
        };

        for (int i = 0; i < entradas.length; i++) {
            double[] resultado = custosCarro(entradas[i]);
            double[] esperado = saidas[i];

            System.out.println("Resultado: " + Arrays.toString(resultado));
            System.out.println("Esperado: " + Arrays.toString(esperado));
            System.out.println(Arrays.equals(resultado, esperado));
            System.out.println();
        }
    }

    public static double[] custosCarro(double[] input) {
        double precoFinal = input[0];
        double distribuidor = input[1];
        double impostos = input[2];

        double percentualDistribuidor = (distribuidor / precoFinal) * 100;
        double percentualImpostos = (impostos / precoFinal) * 100;

        double[] resultado = {arredondar(percentualDistribuidor), arredondar(percentualImpostos)};

        return resultado;
    }

    public static double arredondar(double numero) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(numero));
    }
}
