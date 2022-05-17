package Business.Matricula;

import Business.Aluno.Aluno;
import Business.Turma.Turma;

public abstract class Matricula {

    private Aluno aluno;

    public Matricula(Aluno aluno) {
        this.aluno = aluno;
        this.aluno.setMatricula(this);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public abstract Turma getTurma();

    /**
     * Metodo que identifica se o aluno passou ou nao
     * @return Booleano que identifica se o aluno passou ou nao
     */

    public abstract boolean isAprovado();

    @Override
    public String toString() {
        String relatorio = this.aluno.toString() + " | Aprovado: ";
        relatorio += isAprovado() ? "sim" : "não";
        return relatorio;
    }
}
