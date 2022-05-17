import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Testes {
    
    private static JogoFisico jogo;

    @BeforeAll
    public static void init() {
        jogo = new JogoFisico("Space Intruders Origins", 2020, 35, 500, true);
    }

    @Test
    public void verificarPrecoDeJogoFisico() {
        assertEquals(59.4, jogo.precoVenda());
    }

    @Test
    public void verificarDesconto() {
        Cliente cliente = new Cliente("Jozias");
        JogoDigital jogo2 = new JogoDigital("Hitman 5", 2022, 500);
        cliente.incluirJogo(jogo2);
        cliente.incluirJogo(jogo);
        assertEquals(277.48, cliente.getProxDesconto());
    }
}