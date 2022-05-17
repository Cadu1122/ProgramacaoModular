package Business.Matricula;

import Business.Aluno.Aluno;
import Business.Turma.TurmaComNotas;

public abstract class MatriculaComNotas extends Matricula {

    private float[] notas;
    
    public MatriculaComNotas(Aluno aluno, TurmaComNotas turma) {
        super(aluno);
        notas = new float[turma.getQtdTestes()];
    }

    /**
     * Coloca a nota do aluno em sua respectiva avaliacao
     * @param prova Numero da avaliacao
     * @param nota Nota final do aluno
     */

    public void setNota(int prova, float nota) {
        if (prova >= 1 && prova <= notas.length && nota >= 0 && nota <= 100 / notas.length) {
            this.notas[prova-1] = nota;
        }
    }

    /**
     * Retorna a nota da respectiva prova
     * @param prova Prova a retornar a nota
     * @return Nota da respectiva prova
     */

    public float getNota(int prova) {
        if(prova >= 1 && prova <= notas.length) {
            return this.notas[prova - 1];
        } else {
            return -1;
        }
    }

    /**
     * Soma a nota de todas as provas feitas pelo aluno
     * @return Soma das notas do aluno
     */

    public float getNotaTotal() {
        int totalDeNotas = 0;
        for(int i = 1; i <= notas.length; i++) {
            if(notas[i-1] != 0) {
                totalDeNotas += notas[i-1];
            }
        }
        return totalDeNotas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Nota: " + getNotaTotal();
    }

    @Override
    public boolean isAprovado () {
        return getNotaTotal() >= 60;
    }

    public float getDesempenho() {
        return this.getNotaTotal();
    }
}
