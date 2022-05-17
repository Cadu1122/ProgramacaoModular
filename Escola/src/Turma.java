public class Turma {

    public static final int QTD_TESTES = 4;

    public static final int QTD_AULAS_TOTAL = 20;
    
    private Matricula[] matriculas;

    private int codigo;

    private int qtdAulas = 0;

    /**
     * Construtor da turma
     * @param nivel Repesenta o nivel da turma
     * @param diaSemana Repesenta o dia da semana que ocorrera a aula. Pode variar de 2 (Segunda) a 7 (Sabado)
     * @param horario Representa o horario do dia que ocorrera as aulas. Pode variar de 1 (Manha) a 3 (Noite)
     */

    Turma(int nivel, int diaSemana, int horario) {
        if ((nivel >= 1 && nivel < 10) && (diaSemana >= 2 && diaSemana <= 7) && (horario >= 1 && horario <= 3)) {
            this.codigo = (nivel * 100) + (diaSemana * 10) + horario;
        } else {
            this.codigo = 121;
        }
        matriculas = new Matricula[20];
    }

    public int getCodigo() {
        return codigo;
    }

    /**
     * Adiciona um aluno na turma, alem de remover o aluno de sua turma antiga
     * @param aluno Aluno que sera adicionado
     */
    public void addAluno(Aluno aluno) {
        if (getQtdAlunos() < matriculas.length - 1 && getMatricula(aluno.getNome()) == null) {
            int posicao = posicionarAluno(aluno);
            matriculas[posicao] = new Matricula(aluno, this);
        }
    }

    public void addAluno(Matricula matricula) {
        if(getQtdAlunos() < matriculas.length - 1) {
            int posicao = posicionarAluno(matricula.getAluno());
            matriculas[posicao] = matricula;
        }
    }

    public Matricula getMatricula(String nome) {
        int indice = pesquisarAluno(nome);
        return indice == -1 ? null : matriculas [indice];
    }

    /**
     * Remove o aluno da turma
     * @param nome Nome do aluno que sera removido
     */

    public void removeAluno(String nome) {
        int indice = pesquisarAluno(nome);
        if(indice != -1) {
            Matricula matriculaAntiga = matriculas[indice];
            int i;
            for(i = indice; i < getQtdAlunos() - 1; i++) {
                matriculas[i] = matriculas[i+1];
            }
            matriculas[i] = null;
            matriculaAntiga.excluir();
        }
    }

    public int getNivel() {
        return codigo / 100;
    }

    /**
     * Adiciona uma aula a quantidade de aulas que ja foram realisadas
     */

    public void addAula() {
        if(qtdAulas < QTD_AULAS_TOTAL) {
            this.qtdAulas++;
        }
    }

    public int getQtdAulas() {
        return this.qtdAulas;
    }

    /**
     * Cria um relatorio com nome, nota e estado de aprovacao
     * @return String formatada com todas as informacoes acima
     */

    public String getRelatorio() {
        String relatorio = "";
        for(int i = 0; i < getQtdAlunos(); i++) {
            relatorio += matriculas[i].toString() + "\n";
        }
        return relatorio;
    }

    /**
     * Calcula a media de notas da turma
     * @return Media de notas da turma
     */

    public float getMediaNotas() {
        float media = 0;
        for(int i = 0; i < getQtdAlunos(); i++) {
            media += matriculas[i].getNotaTotal();
        }
        media /= getQtdAlunos();
        return media;
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

    /**
     * Procura o aluno que possui o melhor desempenho academico da turma, levando em consideracao suas notas e a frequencia
     * @return Aluno que possui o melhor desempenho academico
     */

    public Aluno getAlunoEmpenhado() {
        Matricula maior = matriculas[0];
        for(int i = 1; i < getQtdAlunos(); i++) {
            if(maior.getDesempenho() < matriculas[i].getDesempenho()) {
                maior = matriculas[i];
            }
        }
        return maior.getAluno();
    }

    public int getQtdAlunos() {
        int qtd;
        for(qtd = 0; qtd < matriculas.length && matriculas[qtd] != null; qtd++);
        return qtd;
    }

    private int posicionarAluno(Aluno aluno) {
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
        int resultadoDePesq = matriculas[meio].getAluno().getNome().compareTo(nome);
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
