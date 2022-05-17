package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Business.Aluno.Aluno;
import Business.Matricula.MatriculaEAD;
import Business.Turma.TurmaEAD;

public class TurmaEADTest {

    public TurmaEAD turma = new TurmaEAD(3, 10, 2);

    public MatriculaEAD[] matriculas = new MatriculaEAD[10];

    public Aluno[] alunos = new Aluno[10];
    
    @BeforeEach
    public void instanciarTurmaCom10Alunos () {
        for(int i = 0; i < 10; i++) {
            alunos[i] = new Aluno("Jorge" + i);
            matriculas[i] = new MatriculaEAD(alunos[i], turma);
        }
    }

    @Test
    public void gerarCodigoDaTurma() {
        assertEquals("3E", turma.getCodigo());
    }

    @Test
    public void gerarAprovacao () {
        matriculas[3].setNota(1, 20);
        matriculas[3].setNota(2, 20);
        matriculas[3].setNota(3, 20);
        matriculas[2].setNota(1, 20);
        matriculas[2].setNota(2, 20);
        matriculas[2].setNota(3, 19);
        assertTrue(matriculas[3].isAprovado());
        assertFalse(matriculas[2].isAprovado());
    }
}
