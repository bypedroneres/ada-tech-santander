public class A01EX01 {
    public static void main(String[] args) {
        double fahrenheit = 50;
        double celsius = convertFahrenheitToCelsius(fahrenheit);

        System.out.printf("%.2f graus fahrenheit são %.2f graus celsius.", fahrenheit, celsius);
    }

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }
}