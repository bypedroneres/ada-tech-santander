public class A04EX06 {
    public static boolean elementosRepetidos(double[] input) {
        // Cria um conjunto (Set) para armazenar os valores únicos
        java.util.HashSet<Double> uniqueValues = new java.util.HashSet<>();

        // Percorre o array para verificar se existem valores repetidos
        for (double value : input) {
            if (uniqueValues.contains(value)) {
                return true; // Valor repetido encontrado
            } else {
                uniqueValues.add(value); // Adiciona o valor ao conjunto
            }
        }

        // Se chegou aqui, significa que não há valores repetidos
        return false;
    }

    public static void main(String[] args) {
        double[] valores1 = {2.5, 3.2, 4.5, 5, 6};
        double[] valores2 = {2, 2, 3.1, 4, 4.1, 4.1};

        System.out.println(elementosRepetidos(valores1)); // Saída: false
        System.out.println(elementosRepetidos(valores2)); // Saída: true
    }
}
