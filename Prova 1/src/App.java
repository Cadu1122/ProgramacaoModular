public class App {
    public static void main(String[] args) {
        Cliente cliente =  new Cliente("Jorge");
        Jogo jogo = new JogoDigital("Space Intruders", 2022, 45);
        cliente.incluirJogo(jogo);
        System.out.println(jogo);
        jogo.setAnoLancamento(2019);
        System.out.println(cliente.getJogo(0));
    }
}
