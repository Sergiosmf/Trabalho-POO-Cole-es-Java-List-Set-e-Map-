import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListaEstudantes {
    private final List<Estudante> estudantes = new ArrayList<>();

    // Parte A: adicionarEstudante(Estudante e)
    public void adicionarEstudante(Estudante e) {
        estudantes.add(e);
    }

    // Parte A: removerEstudantePorId(int id)
    public boolean removerEstudantePorId(int id) {
        return estudantes.removeIf(e -> e.getId() == id);
    }

    // Parte A: obterEstudantePorIndice(int indice)
    public Estudante obterEstudantePorIndice(int indice) {
        return estudantes.get(indice);
    }

    // Parte A: buscarEstudantesPorNome(String substring) -> List<Estudante> (case-insensitive)
    public List<Estudante> buscarEstudantesPorNome(String substring) {
        String sub = substring == null ? "" : substring.toLowerCase();
        List<Estudante> resultado = new ArrayList<>();
        for (Estudante e : estudantes) {
            if (e.getNome().toLowerCase().contains(sub)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    // Parte A: ordenarEstudantesPorNome()
    public void ordenarEstudantesPorNome() {
        estudantes.sort(Comparator.comparing(Estudante::getNome, String.CASE_INSENSITIVE_ORDER));
    }

    public List<Estudante> getTodos() {
        return estudantes;
    }
}
