package Business.Turma;

import Business.Matricula.Matricula;
import Business.Aluno.Aluno;

public abstract class Turma {

    public static final int QTD_AULAS_TOTAL = 20;

    private String codigo;

    /**
     * Construtor da turma
     * @param nivel Repesenta o nivel da turma
     * @param diaSemana Repesenta o dia da semana que ocorrera a aula. Pode variar de 2 (Segunda) a 7 (Sabado)
     * @param horario Representa o horario do dia que ocorrera as aulas. Pode variar de 1 (Manha) a 3 (Noite)
     */

    Turma(int nivel) {
        if ((nivel >= 1 && nivel < 10)) {
            this.codigo = Integer.toString(nivel);
        } else {
            this.codigo = "1";
        }
    }

    public abstract Matricula[] getMatriculas();

    public String getCodigo() {
        return codigo;
    }

    protected void criaCodigo(String restanteCodigo) {
        this.codigo += restanteCodigo;
    }

    public void addAluno(Matricula matricula) {
        Matricula[] matriculas = getMatriculas();
        if(getQtdAlunos() < matriculas.length - 1 && getMatriculaByName(matricula.getAluno().getNome()) == null) {
            int posicao = posicionarAluno(matricula.getAluno());
            matriculas[posicao] = matricula;
        }
    }

    public Matricula getMatriculaByName(String nome) {
        int indice = pesquisarAluno(nome);
        return indice == -1 ? null : getMatriculas() [indice];
    }

    /**
     * Remove o aluno da turma
     * @param nome Nome do aluno que sera removido
     */

    public void removeAluno(String nome) {
        Matricula[] matriculas = getMatriculas();
        int indice = pesquisarAluno(nome);
        if(indice != -1) {
            int i;
            for(i = indice; i < getQtdAlunos() - 1; i++) {
                matriculas[i] = matriculas[i+1];
            }
            matriculas[i] = null;
        }
    }

    public int getNivel() {
        return codigo.charAt(0);
    }

    /**
     * Cria um relatorio com nome, nota e estado de aprovacao
     * @return String formatada com todas as informacoes acima
     */

    public String getRelatorio() {
        Matricula[] matriculas = getMatriculas();
        String relatorio = "";
        for(int i = 0; i < getQtdAlunos(); i++) {
            relatorio += matriculas[i].toString() + "\n";
        }
        return relatorio;
    }

    public int getQtdAlunos() {
        Matricula[] matriculas = getMatriculas();
        int qtd;
        for(qtd = 0; qtd < matriculas.length && matriculas[qtd] != null; qtd++);
        return qtd;
    }

    private int posicionarAluno(Aluno aluno) {
        Matricula[] matriculas = getMatriculas();
        int i;
        for(i = 0; i < getQtdAlunos() && matriculas[i].getAluno().getNome().compareTo(aluno.getNome()) < 0; i++);
        for(int c = getQtdAlunos() - 1; c >= i; c--) {
            matriculas[c+1] = matriculas[c];
        }
        return i;
    }

    /**
     * Metodo auxiliar que retorna a posicao de determinado aluno no vetor
     * @param nome Nome do aluno a ser pesquisado
     * @return Posicao do vetor em que o aluno se encontra
     */

    private int pesquisarAluno(String nome) {
        if (getQtdAlunos() == 0) {
            return 0;
        }
        return pesquisaBin(0, getQtdAlunos() - 1, nome);
    }

    private int pesquisaBin(int esq, int dir, String nome) {
        int meio = (esq + dir) / 2;
        int resultadoDePesq = getMatriculas()[meio].getAluno().getNome().compareTo(nome);
        if(resultadoDePesq == 0) {
            return (esq + dir) / 2;
        } else if(esq >= dir) {
            return -1;
        } else if (resultadoDePesq < 0) {
            return pesquisaBin(meio + 1, dir, nome);
        } else {
            return pesquisaBin(esq, meio - 1, nome);
        }
    }
}
