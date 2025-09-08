package desafio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservasApp {

    private static final GerenciadorReservas GERENCIADOR_RESERVAS = new GerenciadorReservas();

    public static void executar(Scanner in) {
        while (true) {
            System.out.println("\n--- Sistema de Reservas de Sala ---");
            System.out.println("1) Cadastrar reserva");
            System.out.println("2) Listar reservas");
            System.out.println("3) Remover reserva por hora");
            System.out.println("0) Voltar");

            int option = lerNumeroInteiro(in, "Escolha uma opção: ", 0, 3);

            switch (option) {
                case 1:
                    System.out.print("Nome da reserva: ");

                    String nome = lerNome(in);

                    int hora = lerNumeroInteiro(in, "Hora (8 a 18): ", 8, 18);

                    boolean criacaoValida = GERENCIADOR_RESERVAS.cadastrarReserva(nome, hora);

                    if (criacaoValida) {
                        System.out.println("Reserva confirmada para " + hora + "h.");
                    } else if (GERENCIADOR_RESERVAS.existeReservaNoHorario(hora)) {
                        System.out.println("Horário já reservado. Escolha outro horário.");
                    } else {
                        System.out.println("Horário inválido. Use um valor entre 8 e 18.");
                    }
                    break;

                case 2:
                    GERENCIADOR_RESERVAS.listarReservas();
                    break;

                case 3:
                    if (GERENCIADOR_RESERVAS.isEmpty()) {
                        System.out.println("Não há reservas para remover.");
                        break;
                    }

                    int horarioParaRemover = lerNumeroInteiro(in, "Informe a hora da reserva a remover (8 a 18): ", 8, 18);

                    boolean horarioRemovido = GERENCIADOR_RESERVAS.removerReserva(horarioParaRemover);

                    if (horarioRemovido) {
                        System.out.println("Reserva das " + horarioParaRemover + "h removida.");
                    } else {
                        System.out.println("Não existe reserva nesse horário.");
                    }
                    break;

                case 0:
                    return;
            }
        }
    }

    private static int lerNumeroInteiro(Scanner in, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = in.nextInt();

                in.nextLine();

                if (value < min || value > max) {
                    System.out.println("Valor deve estar entre " + min + " e " + max + ".");
                    continue;
                }

                return value;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                in.nextLine();
            }
        }
    }

    private static String lerNome(Scanner in) {
        while (true) {
            String line = in.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.print("Entrada vazia. Digite novamente: ");
        }
    }
}
