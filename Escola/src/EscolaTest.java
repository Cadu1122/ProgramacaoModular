import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EscolaTest {
    
    Turma turma = new Turma(2, 4, 2);

    Aluno[] alunos = new Aluno[20];

    @BeforeEach
    public void turmaCom10Alunos() {
        for(int i = 0; i < 10; i++) {
            alunos[i] = new Aluno("Paulo" + i);
            turma.addAluno(alunos[i]);
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
        assertEquals("Nome: Paulo3", turma.getMatricula("Paulo3").getAluno().toString());
    }

    @Test
    public void turmaComMaisDe20Alunos() {
        for(int i = 10; i <= 20; i++) {
            turma.addAluno(new Aluno("Paulo" + i));
        }
        assertEquals(null, turma.getMatricula("Paulo21"));
    }

    @Test
    public void alunoComMaisDeUmaTurma() {
        Turma turma2 = new Turma(3, 5, 1);
        turma2.addAluno(alunos[2]);
        assertEquals(null, turma.getMatricula("Paulo2"));
        assertEquals(alunos[2], turma2.getMatricula("Paulo2").getAluno());
    }

    @Test
    public void notaNaAvaliacao() {
        alunos[2].getMatricula().setNota(1, 20);
        assertEquals(20, alunos[2].getMatricula().getNota(1));
    }

    @Test
    public void descobrirNivelDeEnsinoDaTurma() {
        assertEquals(2, turma.getNivel());
    }

    @Test
    public void recuperarCodigoDeTurma() {
        assertEquals(242, turma.getCodigo());
    }

    @Test
    public void verificarFrequencia() {
        turma.addAula();
        turma.addAula();
        alunos[5].getMatricula().addFrequencia();
        assertEquals(50, alunos[5].getMatricula().getFrequencia());
    }

    @Test
    public void verificarAprovacao() {
        for(int i = 0; i < 19; i++) {
            turma.addAula();
            alunos[5].getMatricula().addFrequencia();
            alunos[3].getMatricula().addFrequencia();
        }
        alunos[5].getMatricula().setNota(1, 25);
        alunos[5].getMatricula().setNota(2, 22);
        alunos[5].getMatricula().setNota(3, 15);
        alunos[5].getMatricula().setNota(4, 21);
        assertEquals(true, alunos[5].getMatricula().isAprovado());
        alunos[6].getMatricula().setNota(1, 25);
        alunos[6].getMatricula().setNota(2, 22);
        alunos[6].getMatricula().setNota(3, 15);
        alunos[6].getMatricula().setNota(4, 21);
        assertEquals(false, alunos[6].getMatricula().isAprovado());
        assertEquals(false, alunos[3].getMatricula().isAprovado());
    }

    @Test
    public void gerarRelatorio() {
        System.out.println(turma.getRelatorio());
    }

    @Test
    public void mediaDasNotas() {
        alunos[6].getMatricula().setNota(1, 25);
        alunos[6].getMatricula().setNota(2, 25);
        alunos[6].getMatricula().setNota(3, 25);
        alunos[6].getMatricula().setNota(4, 25);
        assertEquals(10, turma.getMediaNotas());
    }

    @Test
    public void mediaDasFrequencias() {
        turma.addAula();
        alunos[5].getMatricula().addFrequencia();
        alunos[3].getMatricula().addFrequencia();
        assertEquals(20, turma.getMediaFrequencia());
    }

    @Test
    public void alunoComMelhorDesempenho() {
        turma.addAula();
        alunos[5].getMatricula().addFrequencia();
        alunos[3].getMatricula().addFrequencia();
        alunos[6].getMatricula().setNota(1, 25);
        alunos[6].getMatricula().setNota(2, 25);
        alunos[6].getMatricula().setNota(3, 25);
        alunos[6].getMatricula().setNota(4, 25);
        assertEquals(alunos[6], turma.getAlunoEmpenhado());
    }
}
