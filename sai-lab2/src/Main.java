public class Main {

    private final  static String start = "С.Петербург";
    private final static String finish = "Житомир";

    public static void main(String[] args) {
        Graph[] g = new Graph[5];
        for (int i = 0; i < 5; i++) g[i] = new Graph();

        System.out.println("Поиск в глубину: ");
        g[0].DFS(start, finish);
        Printer.printResult(g[0].getResult(), finish);

        System.out.println("Поиск в ширину: ");
        g[1].BFS(start, finish);
        Printer.printResult(g[1].getResult(), finish);

        System.out.println("Поиск с ограничением глубины 5: ");
        g[2].DLS(start, finish, 0, 5);
        Printer.printResult(g[2].getResult(), finish);

        System.out.println("Поиск с итеративным углублением : ");
        g[3].IDDFS(start, finish, 0, 1);

        System.out.println("Двунаправленный поиск: ");
        g[4].BSA(start, finish);
        Printer.printResult(g[4].getResult(), g[4].getRevResult());

        System.out.println("\n");

        WeightedGraph weightedGraph1 = new WeightedGraph();
        WeightedGraph weightedGraph2 = new WeightedGraph();
        weightedGraph1.task1(start, finish);
        weightedGraph2.task2(start, finish);
    }
}
