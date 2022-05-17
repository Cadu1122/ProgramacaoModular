public class JogoFisico extends Jogo {

    private static final double ADIC_DISCO = 15;

    private static final double ACRESC_ESPECIAL = 0.10;

    private boolean versaoEspecial;

    private int quantDiscos;
    
    public JogoFisico (String nome, int anoLancamento, double precoBase, int quantDiscos,  boolean versaoEspecial) {
        super(nome, anoLancamento, precoBase);
        this.quantDiscos = quantDiscos;
        this.versaoEspecial = versaoEspecial;
    }

    public int getQuantDiscos() {
        return quantDiscos;
    }

    public void setQuantDiscos(int quantDiscos) {
        if (quantDiscos >= 0) {
            this.quantDiscos = quantDiscos;
        }
    }

    @Override
    public double precoVenda() {
        return super.precoVenda();
    }

    @Override
    protected double precoBase() {
        return precoAdicionais();
    }

    /**
     * Calcula o preco adicional do disco e do valor do acrescimo
     * @return Valor do disco e do acrescimo
     */

    private double precoAdicionais() {
        double preco = precoBase + ADIC_DISCO;
        if(versaoEspecial) {
            return preco + (preco * ACRESC_ESPECIAL);
        } else {
            return preco;
        }
    }
}
