# Trabalho de POO — Coleções Java (List, Set e Map)

## 1) Integrantes do grupo 
- **(1)** Sérgio Mendes

> Substitua pelos nomes reais do grupo.

---

## 2) Breve descrição do projeto
Este projeto implementa um **sistema simples de controle acadêmico** em Java, capaz de:
- **Gerenciar estudantes** (adicionar, remover, buscar e ordenar) usando **List**.
- **Controlar disciplinas únicas** (evitando duplicatas) usando **Set**.
- **Associar estudantes às suas matrículas e notas** e gerar relatórios (médias, top N, aprovados, etc.) usando **Map**.

Os dados são carregados **em memória** (dataset de exemplo) e os resultados são exibidos no console (ou salvos em arquivo via redirecionamento para `output.txt`).

---

## 3) Justificativa das coleções e implementações

### ✅ List (ArrayList) — `ListaEstudantes`
Foi usada uma **List** para manter a sequência de estudantes e permitir:
- Inserção simples (`add`)
- Acesso por índice (`get`)
- Ordenação por nome (`sort`)
- Busca por substring (varredura)

**Implementação escolhida: `ArrayList`**
- Boa performance para acesso por índice e iteração
- Estrutura simples para o caso proposto (dataset em memória)

---

### ✅ Set (LinkedHashSet) — `CadastroDisciplinas`
Foi usado um **Set** para garantir que **não haja disciplinas duplicadas** (por código).

**Implementação escolhida: `LinkedHashSet`**
- Mantém a **ordem de inserção**, como pedido no enunciado
- Ainda evita duplicatas automaticamente
- Permite imprimir as disciplinas na ordem em que foram cadastradas

> Para o `Set` funcionar corretamente, a classe `Disciplina` implementa `equals()` e `hashCode()` baseados no `codigo`.

---

### ✅ Map (HashMap) — `HistoricoNotas`
Foi usado um **Map** para associar cada estudante às suas matrículas e notas:
- `idEstudante -> List<Matricula>`

**Implementação escolhida: `HashMap`**
- Busca eficiente por chave (id do estudante)
- Ideal para relacionar rapidamente um estudante ao seu histórico
- Simples e adequado para o escopo do trabalho

---

## 4) Como executar o programa e gerar `output.txt`

### Pré-requisitos
- **Java JDK** instalado (recomendado **Java 17+**)
- Terminal (Prompt/PowerShell no Windows, Terminal no macOS/Linux)

### Passo a passo (simples)
1. Coloque todos os arquivos `.java` na **mesma pasta**:
   - `Main.java`
   - `Estudante.java`
   - `Disciplina.java`
   - `Matricula.java`
   - `ListaEstudantes.java`
   - `CadastroDisciplinas.java`
   - `HistoricoNotas.java`

2. Abra o terminal nessa pasta.

3. Compile:
   - **Windows (cmd/PowerShell):**
     ```bash
     javac *.java
     ```
   - **macOS/Linux:**
     ```bash
     javac *.java
     ```

4. Execute normalmente (mostra no console):
   ```bash
   java Main
   ```

5. Para **gerar o arquivo `output.txt`** (salvar a saída):
   - **Windows / macOS / Linux (igual):**
     ```bash
     java Main > output.txt
     ```

6. Confira o arquivo criado:
   - O `output.txt` ficará **na mesma pasta** do projeto.

---

## 5) Comentário sobre desafio encontrado
Um ponto importante deste trabalho foi garantir que o **Set realmente identificasse duplicatas**.  
Para isso, foi necessário implementar corretamente `equals()` e `hashCode()` na classe `Disciplina`, considerando que a duplicidade é definida pelo **mesmo código** (independente de maiúsculas/minúsculas).  
Outro desafio comum foi manter o código organizado por responsabilidades (POO), separando a lógica entre:
- classes de modelo (`Estudante`, `Disciplina`, `Matricula`)
- classes de controle de coleções (`ListaEstudantes`, `CadastroDisciplinas`, `HistoricoNotas`)
- classe de execução/integração (`Main`)

---

### Estrutura do projeto (referência)
```
.
├─ Main.java
├─ Estudante.java
├─ Disciplina.java
├─ Matricula.java
├─ ListaEstudantes.java
├─ CadastroDisciplinas.java
└─ HistoricoNotas.java
```
