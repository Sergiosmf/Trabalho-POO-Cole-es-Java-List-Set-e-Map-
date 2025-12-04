import java.util.Objects;

public class Matricula {
    private final String codigoDisciplina;
    private final double nota;

    public Matricula(String codigoDisciplina, double nota) {
        this.codigoDisciplina = Objects.requireNonNull(codigoDisciplina, "codigoDisciplina").trim();
        this.nota = nota;
        if (this.codigoDisciplina.isEmpty()) throw new IllegalArgumentException("codigoDisciplina vazio");
    }

    public String getCodigoDisciplina() { return codigoDisciplina; }
    public double getNota() { return nota; }

    @Override
    public String toString() {
        return codigoDisciplina + "(" + nota + ")";
    }
}
