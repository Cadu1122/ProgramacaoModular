import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

public class MicroondasTest {
    Microondas microondas = new Microondas();

    @BeforeEach
    public void reset() {
        microondas.desligar();
        microondas.fecharPorta();
        microondas.setTempo(0, 0);
    }

    @Test
    public void abrirPorta() {
        microondas.abrirPorta();
        assertEquals(true, microondas.isPortaAberta());
    }

    @Test
    public void fecharPorta() {
        microondas.fecharPorta();
        assertEquals(false, microondas.isPortaAberta());
    }

    @Test
    public void setarTemporizadorComMinutos() {
        microondas.setTempo(1, 30);
        assertEquals("1:30", microondas.getTempo());
    }

    @Test
    public void setarTemporizadorComTempoInvalido() {
        microondas.setTempo(-1, 200);
        assertEquals("0:00", microondas.getTempo());
    }

    @Test
    public void desligar() {
        microondas.desligar();
        assertEquals(false, microondas.isLigado());
    }

    @Test
    public void ligar() {
        microondas.ligar();
        assertEquals(true, microondas.isLigado());
    }

    @Test
    public void passarTempo() {
        microondas.setTempo(3, 30);
        microondas.ligar();
        microondas.passarTempo();
        assertEquals("3:29", microondas.getTempo());
    }
    
    @Test
    public void passarTempoEnquantoDesligado() {
        microondas.setTempo(3, 20);
        microondas.passarTempo();
        assertEquals("3:20", microondas.getTempo());
    }

    @Test
    public void passarTempoComMinutos() {
        microondas.setTempo(3, 00);
        microondas.ligar();
        microondas.passarTempo();
        assertEquals("2:59", microondas.getTempo());
    }

    @Test
    public void passarTempoComMicroondasPausado() {
        microondas.setTempo(1, 5);
        microondas.ligar();
        microondas.pausar();
        microondas.passarTempo();
        assertEquals("1:05", microondas.getTempo());
    }

    @Test
    public void reiniciar() {
        microondas.setTempo(10, 0);
        microondas.ligar();
        microondas.pausar();
        microondas.ligar();
        microondas.passarTempo();
        assertEquals("9:59", microondas.getTempo());
    }

    @Test
    public void abrirPortaComMicroondasLigado() {
        microondas.ligar();
        microondas.abrirPorta();
        assertEquals(false, microondas.isPortaAberta());
    }

    @Test
    public void ligarMicroondasComPortaAberta() {
        microondas.abrirPorta();
        microondas.ligar();
        assertEquals(false, microondas.isLigado());
    }
}
