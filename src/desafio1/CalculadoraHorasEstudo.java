package desafio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraHorasEstudo {

    public static void executar(Scanner scanner) {
        System.out.println("\n--- Calculadora de Horas de Estudo ---");

        int dias = lerNumeroInteiro(scanner, "Digite a quantidade de dias de estudo (0 a 7): ", 0, 7);

        int[] horas = new int[dias];
        int total = 0;

        for (int i = 0; i < dias; i++) {
            String prompt = "Dia " + (i + 1) + " - horas (0 a 8): ";
            horas[i] = lerNumeroInteiro(scanner, prompt, 0, 8);
            total += horas[i];
        }

        double media = dias == 0 ? 0.0 : (double) total / dias;

        System.out.println("\n--- Resultado ---");
        System.out.println("Dias de estudo: " + dias);
        System.out.print("Horas: ");
        if (dias == 0) {
            System.out.println("(nenhuma)");
        } else {
            for (int i = 0; i < horas.length; i++) {
                System.out.print(horas[i]);
                if (i < horas.length - 1) System.out.print(" ");
            }

            System.out.println();
        }

        System.out.println("Total: " + total + " horas");

        System.out.printf("Média: %.1f horas/dia%n", media);

        if (total >= 20) {
            System.out.println("Meta atingida");
        } else {
            System.out.println("Meta não atingida");
        }
    }

    private static int lerNumeroInteiro(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);

            try {
                int valor = scanner.nextInt();

                scanner.nextLine();

                if (valor < min || valor > max) {
                    System.out.println("Valor deve estar entre " + min + " e " + max + ".");
                    continue;
                }

                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine();
            }
        }
    }
}
