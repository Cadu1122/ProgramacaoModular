public class Cliente {

    private static final double GASTO_PARA_DESC = 500;

    private static final double PCT_DESC = 0.2;
    
    public String nome;

    private Jogo[] historico;

    private double proxDesconto;

    public Cliente(String nome) {
        this.nome = nome;
        this.historico = new Jogo[200];
        this.proxDesconto = GASTO_PARA_DESC;
    }

    public double getProxDesconto() {
        return proxDesconto;
    }

    /**
     * Inclui um jogo no historico de compras. Caso haja um desconto, ele sera aplicado
     * @param jogo Jogo a ser incluido
     */

    public void incluirJogo(Jogo novo) {
        int posicao = 0;
        for(posicao = 0; posicao < historico.length && historico[posicao] != null; posicao++);
        this.historico[posicao] = novo;
        if(verificarDesconto()) {
            double precoVenda = novo.precoVenda();
            precoVenda -= precoVenda * PCT_DESC;
            proxDesconto += GASTO_PARA_DESC - precoVenda;
        } else {
            proxDesconto -= novo.precoVenda();
        }
    }

    public Jogo getJogo(int posicao) {
        return historico[posicao];
    }

    private boolean verificarDesconto() {
        return proxDesconto <= 0;
    }
}
