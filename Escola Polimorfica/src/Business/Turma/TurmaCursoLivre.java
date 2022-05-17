package Business.Turma;

import Business.Matricula.Matricula;
import Business.Matricula.MatriculaCursolivre;

public class TurmaCursoLivre extends Turma {

    private MatriculaCursolivre[] matriculas;

    private int qtdMateriais;
    
    public TurmaCursoLivre (int nivel, int qtdMateriais) {
        super(nivel);
        this.qtdMateriais = qtdMateriais;
        matriculas = new MatriculaCursolivre[0];
        criaCodigo("L");
    }

    public int getQtdMateriais() {
        return qtdMateriais;
    }

    @Override
    public MatriculaCursolivre[] getMatriculas() {
        return getMatriculas();
    }

    @Override
    public void addAluno(Matricula matricula) {
        aumentarMatriculas();
        super.addAluno(matricula);
    }

    @Override
    public void removeAluno(String nome) {
        super.removeAluno(nome);
        reduzirMatriculas();
    }

    public void aumentarMatriculas () {
        MatriculaCursolivre[] matriculasNova = new MatriculaCursolivre [matriculas.length + 1];
        for (int i = 0; i <= matriculas.length; i++) {
            matriculasNova[i] = matriculas[i];
        }
        matriculas = matriculasNova;
    }

    public void reduzirMatriculas () {
        MatriculaCursolivre[] matriculasNova = new MatriculaCursolivre [matriculas.length - 1];
        for (int i = 0; i <= matriculasNova.length; i++) {
            matriculasNova[i] = matriculas[i];
        }
        matriculas = matriculasNova;
    }
}
