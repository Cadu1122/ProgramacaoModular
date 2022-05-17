package Business.Aluno;

import Business.Matricula.Matricula;

public class Aluno {

    private String nome;

    private Matricula matricula;
    
    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public Matricula getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Matricula matricula) {
        if (this.matricula != null) {
            this.matricula.getTurma().removeAluno(nome);
        }
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome();
    }
}
