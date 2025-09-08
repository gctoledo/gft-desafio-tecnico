package desafio2;

import java.util.Objects;

public class Reserva {
    private final String nome;
    private final int hora;

    public Reserva(String nome, int hora) {
        this.nome = nome;
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public int getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return hora + "h - " + nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return hora == reserva.hora && Objects.equals(nome, reserva.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, hora);
    }
}
