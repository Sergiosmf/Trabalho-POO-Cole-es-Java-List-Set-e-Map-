import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CadastroDisciplinas {
    // LinkedHashSet: mantém ordem de inserção (como sugerido no enunciado)
    private final Set<Disciplina> disciplinas = new LinkedHashSet<>();
    private final List<Disciplina> duplicatasDetectadas = new ArrayList<>();

    // Parte B: adicionarDisciplina(Disciplina d) (ignorar duplicadas)
    public void adicionarDisciplina(Disciplina d) {
        boolean added = disciplinas.add(d);
        if (!added) duplicatasDetectadas.add(d); // Extra: detectar duplicatas na importação
    }

    // Parte B: verificarDisciplina(String codigo) -> boolean
    public boolean verificarDisciplina(String codigo) {
        if (codigo == null) return false;
        return disciplinas.contains(new Disciplina(codigo, "X"));
    }

    // Parte B: removerDisciplina(String codigo)
    public boolean removerDisciplina(String codigo) {
        if (codigo == null) return false;
        return disciplinas.remove(new Disciplina(codigo, "X"));
    }

    // Parte B: obterTodasDisciplinas()
    public Set<Disciplina> obterTodasDisciplinas() {
        return disciplinas;
    }

    // Extra: identificar disciplinas duplicadas ao importar dados
    public List<Disciplina> getDuplicatasDetectadas() {
        return duplicatasDetectadas;
    }
}
