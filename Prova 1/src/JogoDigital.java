public class JogoDigital extends Jogo {

    public JogoDigital(String nome, int anoLancamento, double precoBase) {
        super(nome, anoLancamento, precoBase);
    }

    @Override
    public double precoVenda() {
        return super.precoVenda();
    }

    @Override
    protected double precoBase() {
        return super.precoBase();
    }
}