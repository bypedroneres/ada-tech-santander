package util;

import java.util.Scanner;

public class Input {

    public static int lerInt(String msg) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(msg);
        int valor = scanner.nextInt();
        scanner.nextLine();

        return valor;
    }
}