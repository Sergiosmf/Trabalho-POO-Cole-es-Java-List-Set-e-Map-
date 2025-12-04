import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HistoricoNotas {
    // Parte C: implementação sugerida HashMap
    private final Map<Integer, List<Matricula>> matriculasPorEstudante = new HashMap<>();

    // Parte C: adicionarMatricula(int idEstudante, String codigoDisciplina, double nota)
    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        matriculasPorEstudante.putIfAbsent(idEstudante, new ArrayList<>());
        matriculasPorEstudante.get(idEstudante).add(new Matricula(codigoDisciplina, nota));
    }

    // Parte C: obterMatriculas(int idEstudante) -> List<Matricula>
    public List<Matricula> obterMatriculas(int idEstudante) {
        return matriculasPorEstudante.getOrDefault(idEstudante, List.of());
    }

    // Parte C: obterNota(int idEstudante, String codigoDisciplina) -> Optional<Double>
    public Optional<Double> obterNota(int idEstudante, String codigoDisciplina) {
        return obterMatriculas(idEstudante).stream()
                .filter(m -> m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina))
                .map(Matricula::getNota)
                .findFirst();
    }

    // Parte C: removerMatricula(int idEstudante, String codigoDisciplina)
    public boolean removerMatricula(int idEstudante, String codigoDisciplina) {
        List<Matricula> mats = matriculasPorEstudante.get(idEstudante);
        if (mats == null) return false;
        return mats.removeIf(m -> m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina));
    }

    // Parte C: mediaDoEstudante(int idEstudante) -> double
    public double mediaDoEstudante(int idEstudante) {
        List<Matricula> mats = obterMatriculas(idEstudante);
        if (mats.isEmpty()) return 0.0;
        double soma = 0.0;
        for (Matricula m : mats) soma += m.getNota();
        return soma / mats.size();
    }

    // Parte C: mediaDaDisciplina(String codigoDisciplina) -> double
    public double mediaDaDisciplina(String codigoDisciplina) {
        double soma = 0.0;
        int count = 0;
        for (List<Matricula> mats : matriculasPorEstudante.values()) {
            for (Matricula m : mats) {
                if (m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina)) {
                    soma += m.getNota();
                    count++;
                }
            }
        }
        return count == 0 ? 0.0 : soma / count;
    }

    // Parte C: topNEstudantesPorMedia(int N) -> retorna IDs ordenados por média desc
    public List<Integer> topNEstudantesPorMedia(int N) {
        return matriculasPorEstudante.keySet().stream()
                .sorted((a, b) -> Double.compare(mediaDoEstudante(b), mediaDoEstudante(a)))
                .limit(N)
                .collect(Collectors.toList());
    }
}
