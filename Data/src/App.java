public class App {
    public static void main(String[] args) throws Exception {
        Data data1 = new Data(25, 12, 199);
        Data data2 = new Data(29, 2, 1204);
        data1 = data1.addDias(1);
        System.out.println(data1.dataFutura(data2).formatarData());
    }
}
