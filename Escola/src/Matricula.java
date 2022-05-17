public class Matricula {

    private Aluno aluno;

    private Turma turma;

    private float[] notas;

    private int aulasComparecidas;

    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
        if(this.aluno.getMatricula() != null) {
            this.aluno.getMatricula().excluir();
        }
        this.aluno.setMatricula(this);
        this.turma.addAluno(this);
        notas = new float[Turma.QTD_TESTES];
    }

    public Aluno getAluno() {
        return aluno;
    }
    
    /**
     * Coloca a nota do aluno em sua respectiva avaliacao
     * @param prova Numero da avaliacao
     * @param nota Nota final do aluno
     */

    public void setNota(int prova, float nota) {
        if (prova >= 1 && prova <= Turma.QTD_TESTES && nota >= 0 && nota <= 100 / Turma.QTD_TESTES) {
            this.notas[prova-1] = nota;
        }
    }

    /**
     * Retorna a nota da respectiva prova
     * @param prova Prova a retornar a nota
     * @return Nota da respectiva prova
     */

    public float getNota(int prova) {
        if(prova >= 1 && prova <= Turma.QTD_TESTES) {
            return this.notas[prova - 1];
        } else {
            return -1;
        }
    }

    /**
     * Adiciona uma unidade as aulas comparecidas do aluno
     */

    public void addFrequencia() {
        if(turma != null && turma.getQtdAulas() > this.aulasComparecidas) {
            this.aulasComparecidas++;
        }
    }

    public float getFrequencia() {
        if(this.turma != null && this.turma.getQtdAulas() != 0) {
            return ((float) this.aulasComparecidas / this.turma.getQtdAulas()) * 100;
        } else {
            return 0;
        }
    }

    /**
     * Metodo que identifica se o aluno passou ou nao
     * @return Booleano que identifica se o aluno passou ou nao
     */

    public boolean isAprovado() {
        return getFrequencia() >= 75 && getNotaTotal() >= 60;
    }

    /**
     * Calcula o desempenho do aluno baseado em sua frequencia e em sua nota
     * @return Desempenho total do aluno
     */

    public float getDesempenho() {
        return ((this.getNotaTotal() * 80) + (this.getFrequencia() * 20)) / 100;
    }

    /**
     * Soma a nota de todas as provas feitas pelo aluno
     * @return Soma das notas do aluno
     */

    public float getNotaTotal() {
        int totalDeNotas = 0;
        for(int i = 1; i <= Turma.QTD_TESTES; i++) {
            if(notas[i-1] != 0) {
                totalDeNotas += notas[i-1];
            }
        }
        return totalDeNotas;
    }

    public void excluir () {
        this.aluno.setMatricula(null);
        if(this.turma.getMatricula(aluno.getNome()) == this) {
            this.turma.removeAluno(aluno.getNome());
        }
    }

    @Override
    public String toString() {
        String relatorio = this.aluno.toString() + " | Nota: " + getNotaTotal() + " | Aprovado: ";
        relatorio += isAprovado() ? "sim" : "não";
        return relatorio;
    }
}
