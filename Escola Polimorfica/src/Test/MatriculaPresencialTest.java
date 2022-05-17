package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Business.Aluno.Aluno;
import Business.Matricula.MatriculaPresencial;
import Business.Turma.TurmaPresencial;

public class MatriculaPresencialTest {

    TurmaPresencial turma = new TurmaPresencial(8, 6, 5, 4);

    Aluno aluno = new Aluno("Ricardo");

    MatriculaPresencial matricula = new MatriculaPresencial(aluno, turma);

    @Test
    public void notaNaAvaliacao() {
        matricula.setNota(1, 20);
        assertEquals(20, matricula.getNota(1));
        matricula.setNota(2, 26);
        assertEquals(0, matricula.getNota(2));
        matricula.setNota(3, 25);
        assertEquals(25, matricula.getNota(3));
    }

    @Test
    public void verificarAprovacao() {
        matricula.setNota(1, 25);
        matricula.setNota(2, 22);
        matricula.setNota(3, 15);
        matricula.setNota(4, 21);
        assertEquals(false, matricula.isAprovado());
        for(int i = 0; i < 19; i++) {
            matricula.addAulasComparecidas();
        }
        assertEquals(true, matricula.isAprovado());
        matricula.setNota(1, 2);
        matricula.setNota(2, 2);
        matricula.setNota(3, 5);
        matricula.setNota(4, 21);
        assertEquals(false, matricula.isAprovado());
    }

    @Test
    public void verificarFrequencia() {
        matricula.addAulasComparecidas();
        assertEquals(5, matricula.getFrequencia());
    }

    @Test
    public void notaEmTurmaComVariasProvas() {
        TurmaPresencial turma = new TurmaPresencial(3, 5, 7, 10);
        MatriculaPresencial matricula2 = new MatriculaPresencial(aluno, turma);
        matricula2.setNota(7, 10);
        assertEquals(10, matricula2.getNota(7));
        matricula2.setNota(9, 11);
        assertEquals(0, matricula2.getNota(9));
    }
}
