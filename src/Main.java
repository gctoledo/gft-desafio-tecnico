import desafio1.CalculadoraHorasEstudo;
import desafio2.ReservasApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Desafios =====");
            System.out.println("1) Calculadora de Horas de Estudo");
            System.out.println("2) Sistema de Reservas de Sala");
            System.out.println("3) Como pedir ajuda para uma IA (LLM)");
            System.out.println("0) Sair");

            int opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    CalculadoraHorasEstudo.executar(scanner);
                    break;
                case 2:
                    ReservasApp.executar(scanner);
                    break;
                case 3:
                    executarDesafio3();
                    break;
                case 0:
                    System.out.println("Encerrando aplicação!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void executarDesafio3() {
        System.out.println("\n--- Desafio 3 – Como pedir ajuda para uma IA (LLM) ---");

        System.out.println("\"Estou escrevendo um código em C# que gera números aleatórios usando " +
                "a classe Random, mas percebi que, quando executo o programa várias vezes, " +
                "a sequência gerada é sempre parecida ou até igual. Poderia me explicar " +
                "por que isso acontece e sugerir formas de tornar a geração de números " +
                "mais imprevisível em C#, talvez usando uma semente mais adequada ou " +
                "outras classes/bibliotecas? Gostaria de exemplos de código corrigido.\"");
    }

    private static int lerOpcao(Scanner scanner) {
        while (true) {
            System.out.print("Escolha uma opção: ");
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();
                return opcao;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine();
            }
        }
    }
}
