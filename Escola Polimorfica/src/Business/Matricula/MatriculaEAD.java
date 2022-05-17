package Business.Matricula;

import Business.Aluno.Aluno;
import Business.Turma.TurmaEAD;

public class MatriculaEAD extends MatriculaComNotas{

    private TurmaEAD turma;

    private int materiaisAcessados;
    
    public MatriculaEAD(Aluno aluno, TurmaEAD turma) {
        super (aluno, turma);
        this.turma = turma;
    }

    public void acessarMaterial() {
        if(this.materiaisAcessados < turma.getQtdMateriais()) {
            this.materiaisAcessados++;
        }
    }

    public int getMateriaisAcessados() {
        return materiaisAcessados;
    }

    public TurmaEAD getTurma() {
        return turma;
    }
}
