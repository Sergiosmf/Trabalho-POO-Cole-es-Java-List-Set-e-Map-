import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // ===== Parte D (1): carregar datasets fornecidos =====
        ListaEstudantes lista = new ListaEstudantes();
        lista.adicionarEstudante(new Estudante(1, "Ana"));
        lista.adicionarEstudante(new Estudante(2, "Bruno"));
        lista.adicionarEstudante(new Estudante(3, "Carla"));
        lista.adicionarEstudante(new Estudante(4, "Diego"));
        lista.adicionarEstudante(new Estudante(5, "Elisa"));

        CadastroDisciplinas cadastro = new CadastroDisciplinas();
        cadastro.adicionarDisciplina(new Disciplina("MAT101", "Matemática"));
        cadastro.adicionarDisciplina(new Disciplina("PRG201", "Programação"));
        cadastro.adicionarDisciplina(new Disciplina("BD301", "Banco de Dados"));
        cadastro.adicionarDisciplina(new Disciplina("EDF110", "Educação Física"));
        // forçando duplicata (extra do enunciado)
        cadastro.adicionarDisciplina(new Disciplina("PRG201", "Programação (duplicada)"));

        HistoricoNotas historico = new HistoricoNotas();
        // Matrículas/Notas (estudanteId, disciplinaCodigo, nota):
        historico.adicionarMatricula(1, "MAT101", 8.5);
        historico.adicionarMatricula(1, "PRG201", 9.0);
        historico.adicionarMatricula(2, "PRG201", 7.0);
        historico.adicionarMatricula(3, "BD301", 6.5);
        historico.adicionarMatricula(4, "PRG201", 8.0);
        historico.adicionarMatricula(5, "EDF110", 10.0);

        // ===== Parte D (2): exibir estudantes ordenados por nome =====
        System.out.println("== Lista de Estudantes (ordem de cadastro) ==");
        for (Estudante e : lista.getTodos()) System.out.println(e);

        lista.ordenarEstudantesPorNome();
        System.out.println("\n== Lista de Estudantes (ordenada) ==");
        for (int i = 0; i < lista.getTodos().size(); i++) {
            System.out.print(lista.getTodos().get(i).getNome());
            if (i < lista.getTodos().size() - 1) System.out.print(", ");
        }
        System.out.println();

        // ===== Parte D (3): exibir disciplinas mantendo ordem de inserção =====
        System.out.println("\n== Disciplinas (inserção) ==");
        Set<Disciplina> disciplinas = cadastro.obterTodasDisciplinas();
        int k = 0;
        for (Disciplina d : disciplinas) {
            System.out.print(d.getCodigo());
            if (k < disciplinas.size() - 1) System.out.print(", ");
            k++;
        }
        System.out.println();

        // ===== Parte D (5): duplicatas detectadas =====
        System.out.println("\n== Duplicatas detectadas na importação ==");
        if (cadastro.getDuplicatasDetectadas().isEmpty()) {
            System.out.println("(nenhuma)");
        } else {
            for (Disciplina d : cadastro.getDuplicatasDetectadas()) {
                System.out.println(d.getCodigo());
            }
        }

        // ===== Parte D (4): para cada estudante, exibir suas disciplinas e notas (Map) =====
        System.out.println("\n== Matrículas ==");
        for (Estudante e : lista.getTodos()) {
            List<Matricula> mats = historico.obterMatriculas(e.getId());
            System.out.print(e.getNome() + ": ");
            for (int i = 0; i < mats.size(); i++) {
                System.out.print(mats.get(i));
                if (i < mats.size() - 1) System.out.print(", ");
            }
            System.out.printf(" Média: %.2f%n", historico.mediaDoEstudante(e.getId()));
        }

        // ===== Parte D (5): Médias por disciplina =====
        System.out.println("\n== Médias por Disciplina ==");
        for (Disciplina d : disciplinas) {
            System.out.printf("%s: %.2f%n", d.getCodigo(), historico.mediaDaDisciplina(d.getCodigo()));
        }

        // ===== Parte D (5): Top N estudantes por média =====
        System.out.println("\n== Top 3 alunos por média ==");
        List<Integer> topIds = historico.topNEstudantesPorMedia(3);
        for (int i = 0; i < topIds.size(); i++) {
            int id = topIds.get(i);
            Estudante e = lista.getTodos().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
            if (e != null) {
                System.out.printf("%d) %s - %.2f%n", (i + 1), e.getNome(), historico.mediaDoEstudante(id));
            }
        }

        // ===== Parte D (5): Alunos com média >= 8.0 =====
        System.out.println("\n== Alunos com média >= 8.0 ==");
        boolean algum = false;
        for (Estudante e : lista.getTodos()) {
            if (historico.mediaDoEstudante(e.getId()) >= 8.0) {
                System.out.print((algum ? ", " : "") + e.getNome());
                algum = true;
            }
        }
        if (!algum) System.out.print("(nenhum)");
        System.out.println();

        // ===== Parte D (5): Disciplinas com média < 6.0 =====
        System.out.println("\n== Disciplinas com média < 6.0 ==");
        boolean algumaDisc = false;
        for (Disciplina d : disciplinas) {
            double md = historico.mediaDaDisciplina(d.getCodigo());
            if (md > 0.0 && md < 6.0) {
                System.out.print((algumaDisc ? ", " : "") + d.getCodigo());
                algumaDisc = true;
            }
        }
        if (!algumaDisc) System.out.print("(nenhuma)");
        System.out.println();
    }
}
