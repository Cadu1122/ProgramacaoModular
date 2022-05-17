package Business.Turma;

import Business.Aluno.Aluno;
import Business.Matricula.MatriculaComNotas;

public abstract class TurmaComNotas extends Turma {

    private int qtdTestes;
    
    public TurmaComNotas (int nivel, int qtdTestes) {
        super (nivel);
        this. qtdTestes = qtdTestes;
    }

    public int getQtdTestes() {
        return qtdTestes;
    }

    public abstract MatriculaComNotas[] getMatriculas();

    /**
     * Calcula a media de notas da turma
     * @return Media de notas da turma
     */

    public float getMediaNotas() {
        float media = 0;
        for(int i = 0; i < getQtdAlunos(); i++) {
            media += getMatriculas()[i].getNotaTotal();
            System.out.println(media);
        }
        media /= getQtdAlunos();
        return media;
    }

    /**
     * Procura o aluno que possui o melhor desempenho academico da turma, levando em consideracao suas notas e a frequencia
     * @return Aluno que possui o melhor desempenho academico
     */

    public Aluno getAlunoEmpenhado() {
        MatriculaComNotas maior = getMatriculas()[0];
        for(int i = 1; i < getQtdAlunos(); i++) {
            if(maior.getDesempenho() < getMatriculas()[i].getDesempenho()) {
                maior = getMatriculas()[i];
            }
        }
        return maior.getAluno();
    }
}
