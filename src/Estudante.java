import java.util.Objects;

public class Estudante {
    private final int id;
    private final String nome;

    public Estudante(int id, String nome) {
        this.id = id;
        this.nome = Objects.requireNonNull(nome, "nome");
    }

    public int getId() { return id; }
    public String getNome() { return nome; }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
