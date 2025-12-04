import java.util.Objects;

public class Disciplina {
    private final String codigo;
    private final String nome;

    public Disciplina(String codigo, String nome) {
        this.codigo = Objects.requireNonNull(codigo, "codigo").trim();
        this.nome = Objects.requireNonNull(nome, "nome").trim();
        if (this.codigo.isEmpty()) throw new IllegalArgumentException("codigo vazio");
        if (this.nome.isEmpty()) throw new IllegalArgumentException("nome vazio");
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }

    @Override
    public String toString() {
        return codigo + ", " + nome;
    }

    // Importante para o Set: duplicidade baseada no "codigo"
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;
        Disciplina other = (Disciplina) o;
        return this.codigo.equalsIgnoreCase(other.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.toUpperCase().hashCode();
    }
}
