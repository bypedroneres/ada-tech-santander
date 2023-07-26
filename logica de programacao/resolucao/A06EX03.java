import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class A06EX03 {
    public static void main(String[] args) throws EstadoInvalidoException {
        System.out.println(valorProdutoFinal(250.10, "MG") == 267.607);
        System.out.println(valorProdutoFinal(250.10, "RJ") == 287.615);
        System.out.println(valorProdutoFinal(250.10, "SP") == 280.112);

        try {
            valorProdutoFinal(250.10, "DF");
        } catch (EstadoInvalidoException e) {
            System.out.println("Estado inválido!");
        }

        // Teste de conversão de string para Enum
        String diaDaSemanaString = "sábado";
        try {
            Semana diaDaSemana = Semana.fromString(diaDaSemanaString);
            System.out.println("Enum convertido: " + diaDaSemana);
        } catch (IllegalArgumentException e) {
            System.out.println("Dia da semana inválido!");
        }
    }

    public static double valorProdutoFinal(double valorProduto, String estadoDestino) throws EstadoInvalidoException {
        try {
            Estado estado = Estado.valueOf(estadoDestino);
            double valorImposto = valorProduto * estado.getImposto();
            return arredondar(valorProduto + valorImposto);
        } catch (IllegalArgumentException e) {
            throw new EstadoInvalidoException();
        }
    }

    public static double arredondar(double numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.####", symbols);
        return Double.parseDouble(decimalFormat.format(numero));
    }
}

// Enum para estados
enum Estado {
    MG(0.07), RJ(0.15), SP(0.12);

    private double imposto;

    Estado(double imposto) {
        this.imposto = imposto;
    }

    public double getImposto() {
        return imposto;
    }
}

// Enum para dias da semana
enum Semana {
    SEGUNDA("segunda-feira"), TERCA("terça-feira"), QUARTA("quarta-feira"),
    QUINTA("quinta-feira"), SEXTA("sexta-feira"), SABADO("sábado"), DOMINGO("domingo");

    private String nome;

    Semana(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Converter de string para Enum
    public static Semana fromString(String text) {
        for (Semana dia : Semana.values()) {
            if (dia.getNome().equalsIgnoreCase(text)) {
                return dia;
            }
        }
        throw new IllegalArgumentException("Dia da semana inválido: " + text);
    }
}

class EstadoInvalidoException extends Exception {
    // Classe de exceção personalizada
}
