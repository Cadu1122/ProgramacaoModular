package Business.Turma;

import Business.Matricula.Matricula;
import Business.Matricula.MatriculaPresencial;

public class TurmaPresencial extends TurmaComNotas {

    private MatriculaPresencial[] matriculas;

    public TurmaPresencial (int nivel, int diaSemana, int horario, int qtdTestes) {
        super(nivel, qtdTestes);
        if ((diaSemana >= 2 && diaSemana <= 7) && (horario >= 1 && horario <= 3)) {
            criaCodigo(Integer.toString((diaSemana * 10) + horario));
        }
        matriculas = new MatriculaPresencial[20];
    }

    @Override
    public MatriculaPresencial[] getMatriculas() {
        return matriculas;
    }

    @Override
    public void addAluno(Matricula matricula) {
        if (matricula instanceof MatriculaPresencial) {
            super.addAluno(matricula);
        }
    }

    /**
     * Calcula a media de frequencia da turma
     * @return Media da porcentagem de frequencia da turma
     */

    public float getMediaFrequencia() {
        float media = 0;
        for(int i = 0; i < getQtdAlunos(); i++) {
            media += matriculas[i].getFrequencia();
        }
        media /= getQtdAlunos();
        return media;
    }
}
