public class A04EX03 {
    public static String[] soletrandoStr(String input) {
        String[] result = new String[input.length()];

        for (int i = 0; i < input.length(); i++) {
            result[i] = String.valueOf(input.charAt(i));
        }

        return result;
    }

    public static void main(String[] args) {
        String palavra = "amor";
        String[] caracteres = soletrandoStr(palavra);

        for (String caractere : caracteres) {
            System.out.println(caractere);
        }
    }
}
