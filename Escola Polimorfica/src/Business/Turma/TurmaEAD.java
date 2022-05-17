package Business.Turma;

import Business.Matricula.Matricula;
import Business.Matricula.MatriculaEAD;

public class TurmaEAD extends TurmaComNotas{

    private MatriculaEAD[] matriculas;

    private int qtdMateriais;

    public TurmaEAD (int nivel, int qtdTestes, int qtdMateriais) {
        super(nivel, qtdTestes);
        this.qtdMateriais = qtdMateriais;
        this.matriculas = new MatriculaEAD[0];
        criaCodigo("E");
    }

    public int getQtdMateriais() {
        return qtdMateriais;
    }

    public void aumentarMatriculas () {
        MatriculaEAD[] matriculasNova = new MatriculaEAD [matriculas.length + 1];
        for (int i = 0; i <= matriculas.length; i++) {
            matriculasNova[i] = matriculas[i];
        }
        matriculas = matriculasNova;
    }

    public void reduzirMatriculas () {
        MatriculaEAD[] matriculasNova = new MatriculaEAD [matriculas.length - 1];
        for (int i = 0; i <= matriculasNova.length; i++) {
            matriculasNova[i] = matriculas[i];
        }
        matriculas = matriculasNova;
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

    @Override
    public MatriculaEAD[] getMatriculas() {
        return getMatriculas();
    }
}
