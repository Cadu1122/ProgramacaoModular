import java.time.LocalDate;

public abstract class Jogo {
    
    private static final int TEMP_DESC = 2;

    private static final double PCT_DESCONTO = 0.2;

    private static final double MARGEM_LUCRO = 0.35;

    protected String nome;

    protected int anoLancamento;

    protected double precoBase;

    protected int[] avaliacoes;

    public Jogo(String nome, int anoLancamento, double precoBase) {
        this.nome = nome;
        this.setAnoLancamento(anoLancamento);
        this.setPrecoBase(precoBase);
        this.avaliacoes = new int[100];
    }

    public double getPrecoBase() {
        return precoBase;
    }

    /**
     * Calcula o preco base do produto, incluindo preco de disco e edicao especial
     * @return Preco base do disco
     */
    protected double precoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        if(anoLancamento <= LocalDate.now().getYear()) {
            this.anoLancamento = anoLancamento;
        }
    }

    /**
     * Calcula o preco de venda final do produto
     * @return preco de venda final
     */

    public double precoVenda() {
        double preco = descontoTempo();
        preco += preco * MARGEM_LUCRO;
        return preco;
    }

    /**
     * Cria uma nova avaliação para o jogo
     * @param nota Nota a ser armazenada
     */

    public void novaAvaliacao(int nota) {
        if(nota > 0 && nota <= 5) {
            int posicao;
            for(posicao = 0; posicao < avaliacoes.length && avaliacoes[posicao] != 0; posicao++);
            avaliacoes[posicao] = nota;
        }
    }

    /**
     * Calcula a média de todas as avaliações armazenadas
     * @return Media das avaliações
     */

    public double avaliacaoMedia() {
        double media = 0;
        int qtd;
        for(qtd = 0; qtd < avaliacoes.length && avaliacoes[qtd] != 0; qtd++) {
            media += avaliacoes[qtd];
        }
        if(qtd == 0) {
            return 0;
        }
        return media / qtd;
    }

    /**
     * Método auxiliar para calcular o valor de desconto
     * @return Valor do desconto
     */

    private double descontoTempo() {
        double preco = precoBase();
        int tempoLancamento = LocalDate.now().getYear() - anoLancamento;
        for(int i = 0; i < tempoLancamento / TEMP_DESC; i++) {
            preco -= preco * PCT_DESCONTO;
        }
        return preco;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nAno de lançamento: " + this.anoLancamento + "\nPreço: " + this.precoVenda() + "\nAvaliação: " + this.avaliacaoMedia();
    }
}
