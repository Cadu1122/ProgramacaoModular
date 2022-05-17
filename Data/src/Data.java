public class Data {

    private int dia;

    private int mes;

    private int ano;

    Data(int dia, int mes, int ano) {
        if(isDataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 2022;
        }
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    /**
     * Verifica se a data inserida e valida
     * @param dia int
     * @param mes int
     * @param ano int
     * @return true caso a data seja valida e false caso nao seja
     */

    private boolean isDataValida(int dia, int mes, int ano) {
        if(diasDoMes(mes, ano) >= dia && dia >= 1) {
            return true;
        }
        return false;
    }

    /**
     * Verifica quantos dias tem em um determinado mes
     * @param mes int
     * @param ano int
     * @return quandidade de dias do respectivo mes, retorna 0 caso seja um mes invalido
     */

    private int diasDoMes(int mes, int ano) {
        int resp = 0;
        if (mes == 2) {
            if (isBissexto(ano)) {
                resp = 29;
            } else {
                resp = 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            resp = 30;
        } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            resp = 31;
        }
        return resp;
    }

    /**
     * Verifica se o ano e bissexto
     * @param ano int
     * @return true se o ano for bissexto, false caso o contrario
     */

    private boolean isBissexto(int ano) {
        boolean resp = true;
        if(ano % 100 == 0 && ano % 400 != 0)
            resp = false;
        else if (ano % 4 != 0)
            resp = false;
        return resp;
    }

    /**
     * Compara duas datas para averiguar qual delas e a mais futura
     * @param dataAComparar data que sera utilizada para realizar a comparacao
     * @return data mais futura
     */

    public Data dataFutura(Data dataAComparar) {
        Data resp = this;
        if(this.ano != dataAComparar.getAno()) {
            if(this.ano > dataAComparar.getAno()) {
                resp = this;
            } else {
                resp = dataAComparar;
            }
        } else if (this.mes != dataAComparar.getMes()) {
            if(this.mes > dataAComparar.getMes()) {
                resp = this;
            } else {
                resp = dataAComparar;
            }
        } else if (this.dia != dataAComparar.getDia()) {
            if(this.dia > dataAComparar.getDia()) {
                resp = this;
            } else {
                resp = dataAComparar;
            }
        }
        return resp;
    }

    /**
     * Adiciona dias a data, avancando ela no futuro
     * @param dias quantidade de dias a serem adicionados
     * @return data apos a adicao de dias
     */

    public Data addDias(int dias) {
        Data dataSomada = this;
        dataSomada.dia += dias;
        while (!isDataValida(dataSomada.dia, dataSomada.mes, dataSomada.ano)) {
            if (dataSomada.dia > 0) {
                dataSomada.dia -= diasDoMes(dataSomada.mes, dataSomada.ano);
                dataSomada.mes++;
                if(dataSomada.mes == 13) {
                    dataSomada.mes = 1;
                    dataSomada.ano++;
                }
            }
        }
        return dataSomada;
    }

    /**
     * Deixa a data escrita de forma convencional
     * @return String com uma data no formato dd/mm/aaaa
     */

    public String formatarData() {
        String resp = "";
        if (this.dia < 9) {
            resp = "0";
        }
            resp += this.dia + "/";
        if (this.mes < 9) {
            resp += "0";
        }
        resp += this.mes + "/" + this.ano;
        return resp;
    }
}