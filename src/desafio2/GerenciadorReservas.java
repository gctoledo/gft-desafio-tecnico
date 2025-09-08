package desafio2;

import java.util.*;

public class GerenciadorReservas {
    private final Map<Integer, Reserva> reservasPorHora = new HashMap<>();

    public boolean cadastrarReserva(String nome, int hora) {
        if (hora < 8 || hora > 18) return false;

        if (reservasPorHora.containsKey(hora)) return false;

        reservasPorHora.put(hora, new Reserva(nome, hora));

        return true;
    }

    public boolean existeReservaNoHorario(int hora) {
        return reservasPorHora.containsKey(hora);
    }

    public boolean removerReserva(int hora) {
        return reservasPorHora.remove(hora) != null;
    }

    public boolean isEmpty() {
        return reservasPorHora.isEmpty();
    }

    public void listarReservas() {
        if (reservasPorHora.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        List<Integer> horas = new ArrayList<>(reservasPorHora.keySet());

        Collections.sort(horas);

        System.out.println("\n--- Reservas Confirmadas ---");

        for (int h : horas) {
            System.out.println(reservasPorHora.get(h));
        }
    }
}
