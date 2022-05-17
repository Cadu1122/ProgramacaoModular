package Business.Matricula;

import Business.Aluno.Aluno;
import Business.Turma.TurmaCursoLivre;

public class MatriculaCursolivre extends Matricula {

    private TurmaCursoLivre turma;

    private int materiaisAcessados;

    public MatriculaCursolivre(Aluno aluno, TurmaCursoLivre turma) {
        super(aluno);
        this.turma = turma;
        materiaisAcessados = 0;
    }

    public int getMateriaisAcessados() {
        return materiaisAcessados;
    }

    public void acessarMaterial() {
        if(this.materiaisAcessados < turma.getQtdMateriais()) {
            this.materiaisAcessados++;
        }
    }

    @Override
    public boolean isAprovado() {
        return getMateriaisAcessados() == turma.getQtdMateriais();
    }

    @Override
    public TurmaCursoLivre getTurma() {
        return this.turma;
    }
}
