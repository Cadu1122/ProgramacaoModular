package Business.Matricula;

import Business.Aluno.Aluno;
import Business.Turma.Turma;
import Business.Turma.TurmaPresencial;

public class MatriculaPresencial extends MatriculaComNotas {

    private int aulasComparecidas;

    private TurmaPresencial turma;

    public MatriculaPresencial(Aluno aluno, TurmaPresencial turma) {
        super(aluno, turma);
        this.turma = turma;
        turma.addAluno(this);
        this.aulasComparecidas = 0;
    }

    public int getAulasComparecidas() {
        return aulasComparecidas;
    }

    public void addAulasComparecidas() {
        if(this.aulasComparecidas <= Turma.QTD_AULAS_TOTAL) {
            this.aulasComparecidas++;
        }
    }

    public float getFrequencia() {
        return ((float) this.getAulasComparecidas() / Turma.QTD_AULAS_TOTAL) * 100;
    }

    /**
     * Calcula o desempenho do aluno baseado em sua frequencia e em sua nota
     * @return Desempenho total do aluno
     */

    public float getDesempenho () {
        return ((super.getDesempenho() * 80) + (this.getFrequencia() * 20)) / 100;
    }

    public boolean isAprovado () {
        return getFrequencia() >= 75 && super.isAprovado();
    }

    @Override
    public TurmaPresencial getTurma() {
        return turma;
    }
}