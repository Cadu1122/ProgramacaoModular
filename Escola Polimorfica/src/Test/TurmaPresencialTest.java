package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Business.Aluno.Aluno;
import Business.Matricula.MatriculaPresencial;
import Business.Turma.TurmaPresencial;

public class TurmaPresencialTest {
    
    TurmaPresencial turma = new TurmaPresencial(2, 4, 2, 4);

    Aluno[] alunos = new Aluno[20];

    MatriculaPresencial[] matriculas = new MatriculaPresencial[20];

    @BeforeEach
    public void turmaCom10Alunos() {
        for(int i = 0; i < 10; i++) {
            alunos[i] = new Aluno("Paulo" + i);
            matriculas[i] = new MatriculaPresencial(alunos[i], turma);
        }
    }

    @AfterEach
    public void limpar() {
        for(int i = 0; i < 10; i++) {
            turma.removeAluno("Paulo" + i);
        }
    }

    @Test
    public void pesquisarAluno() {
        assertEquals("Nome: Paulo3", turma.getMatriculaByName("Paulo3").getAluno().toString());
    }

    @Test
    public void turmaComMaisDe20Alunos() {
        for(int i = 10; i <= 20; i++) {
            turma.addAluno(new MatriculaPresencial(new Aluno("Paulo" + i), turma));
        }
        assertEquals(null, turma.getMatriculaByName("Paulo20"));
    }

    @Test
    public void alunoComMaisDeUmaTurma() {
        TurmaPresencial turma2 = new TurmaPresencial(3, 5, 1, 4);
        turma2.addAluno(new MatriculaPresencial(alunos[2], turma2));
        assertEquals(null, turma.getMatriculaByName("Paulo2"));
        assertEquals(alunos[2], turma2.getMatriculaByName("Paulo2").getAluno());
    }

    @Test
    public void gerarRelatorio() {
        System.out.println(turma.getRelatorio());
    }

    @Test
    public void mediaDasNotas() {
        matriculas[3].setNota(1, 25);
        matriculas[3].setNota(2, 25);
        matriculas[3].setNota(3, 25);
        matriculas[3].setNota(4, 25);
        assertEquals(10, turma.getMediaNotas());
    }

    @Test
    public void mediaDasFrequencias() {
        matriculas[5].addAulasComparecidas();
        matriculas[3].addAulasComparecidas();
        assertEquals(1, turma.getMediaFrequencia());
    }

    @Test
    public void alunoComMelhorDesempenho() {
        matriculas[5].addAulasComparecidas();
        matriculas[3].addAulasComparecidas();
        matriculas[6].setNota(1, 25);
        matriculas[6].setNota(2, 25);
        matriculas[6].setNota(3, 25);
        matriculas[6].setNota(4, 25);
        assertEquals(alunos[6], turma.getAlunoEmpenhado());
    }
}
