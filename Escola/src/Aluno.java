public class Aluno {

    private String nome;

    private Matricula matricula;
    
    Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public Matricula getMatricula() {
        return this.matricula;
    }

    /**
     * Coloca a turma no aluno e o aluno da turma, alem de remover o aluno na turma antiga
     * @param turma Turma nova do aluno
     */

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome();
    }
}
