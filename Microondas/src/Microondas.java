public class Microondas {

    private boolean portaAberta = false;

    public boolean isPortaAberta() {
        return portaAberta;
    }

    public void abrirPorta() {
        if(!ligado) {
            this.portaAberta = true;
        }
    }

    public void fecharPorta() {
        this.portaAberta = false;
    }

    private int minutos = 0;

    private int segundos = 0;

    public void setTempo(int minutos, int segundos) {
        if((minutos >= 0 && minutos <= 99) || (segundos >= 0 && segundos <= 99)) {
            this.minutos = minutos;
            this.segundos = segundos;
        }
    }

    public String getTempo() {
        String tempoFormatado = this.minutos + ":";
        if(this.segundos <= 9) {
            tempoFormatado += "0";
        }
        tempoFormatado += this.segundos;
        return tempoFormatado;
    }

    private boolean ligado = false;

    public void desligar() {
        ligado = false;
        setTempo(0, 0);
    }

    public boolean isLigado() {
        return this.ligado;
    }

    public void ligar() {
        if(portaAberta == false) {
            ligado = true;
        }
    }

    public void passarTempo() {
        if(ligado) {
            if(segundos == 0) {
                if(minutos == 0) {
                    desligar();
                } else {
                    minutos--;
                    segundos = 59;
                }
            } else {
                segundos--;
            }
        }
    }

    public void pausar() {
        ligado = false;
    }
}
