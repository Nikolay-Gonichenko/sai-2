import java.util.ArrayList;
import java.util.LinkedList;

public class WeightedGraph extends Graph {
    private ArrayList<Vertex> vertexes = new ArrayList<>();
    private final int V = 27;
    private boolean[] visited = new boolean[V];

    static class Vertex {
        public String name;
        public int id;
        public LinkedList<Edge> adj = new LinkedList<>();
        public int h;
    }

    static class Edge {
        public int id;
        int w;
    }

    private void addVertex(int vid, String vname, int hw) {
        this.vertexes.add(vid, new Vertex() {{
            name = vname;
            id = vid;
            h = hw;
        }});
    }

    private void addEdge(String city1, String city2, int weight) {
        int id1 = Utility.stringToInt(city1);
        int id2 = Utility.stringToInt(city2);
        this.vertexes.get(id1).adj.add(new Edge() {{
            id = id2;
            w = weight;
        }});
        this.vertexes.get(id2).adj.add(new Edge() {{
            id = id1;
            w = weight;
        }});
    }

    public WeightedGraph() {
        this.addVertex(Utility.stringToInt("Вильнюс"), "Вильнюс", 865);
        this.addVertex(Utility.stringToInt("Брест"), "Брест", 1396);
        this.addVertex(Utility.stringToInt("Витебск"), "Витебск", 1225);
        this.addVertex(Utility.stringToInt("Воронеж"), "Воронеж", 2074);
        this.addVertex(Utility.stringToInt("Волгоград"), "Волгоград", 1493);
        this.addVertex(Utility.stringToInt("Ниж.Новгород"), "Ниж.Новгород", 2136);
        this.addVertex(Utility.stringToInt("Даугавпилс"), "Даугавпилс", 1076);
        this.addVertex(Utility.stringToInt("Калининград"), "Калининград", 1198);
        this.addVertex(Utility.stringToInt("Каунас"), "Каунас", 967);
        this.addVertex(Utility.stringToInt("Киев"), "Киев", 131);
        this.addVertex(Utility.stringToInt("Житомир"), "Житомир", 0);
        this.addVertex(Utility.stringToInt("Донецк"), "Донецк", 863);
        this.addVertex(Utility.stringToInt("Кишинев"), "Кишинев", 598);
        this.addVertex(Utility.stringToInt("С.Петербург"), "С.Петербург", 1827);
        this.addVertex(Utility.stringToInt("Рига"), "Рига", 1234);
        this.addVertex(Utility.stringToInt("Москва"), "Москва", 1940);
        this.addVertex(Utility.stringToInt("Казань"), "Казань", 2752);
        this.addVertex(Utility.stringToInt("Минск"), "Минск", 2630);
        this.addVertex(Utility.stringToInt("Мурманск"), "Мурманск", 3239);
        this.addVertex(Utility.stringToInt("Орел"), "Орел", 1572);
        this.addVertex(Utility.stringToInt("Одесса"), "Одесса", 618);
        this.addVertex(Utility.stringToInt("Таллинн"), "Таллинн", 1542);
        this.addVertex(Utility.stringToInt("Харьков"), "Харьков", 602);
        this.addVertex(Utility.stringToInt("Симферополь"), "Симферополь", 1241);
        this.addVertex(Utility.stringToInt("Ярославль"), "Ярославль", 2813);
        this.addVertex(Utility.stringToInt("Уфа"), "Уфа", 3277);
        this.addVertex(Utility.stringToInt("Самара"), "Самара", 3738);

        this.addEdge("Вильнюс", "Брест", 531);
        this.addEdge("Витебск", "Брест", 638);
        this.addEdge("Витебск", "Вильнюс", 360);
        this.addEdge("Воронеж", "Витебск", 869);
        this.addEdge("Воронеж", "Волгоград", 581);
        this.addEdge("Волгоград", "Витебск", 1455);
        this.addEdge("Витебск", "Ниж.Новгород", 911);
        this.addEdge("Вильнюс", "Даугавпилс", 211);
        this.addEdge("Калининград", "Брест", 699);
        this.addEdge("Калининград", "Вильнюс", 333);
        this.addEdge("Каунас", "Вильнюс", 102);
        this.addEdge("Киев", "Вильнюс", 734);
        this.addEdge("Киев", "Житомир", 131);
        this.addEdge("Житомир", "Донецк", 863);
        this.addEdge("Житомир", "Волгоград", 1493);
        this.addEdge("Кишинев", "Киев", 467);
        this.addEdge("Кишинев", "Донецк", 812);
        this.addEdge("С.Петербург", "Витебск", 602);
        this.addEdge("С.Петербург", "Калининград", 736);
        this.addEdge("С.Петербург", "Рига", 641);
        this.addEdge("Москва", "Казань", 815);
        this.addEdge("Москва", "Ниж.Новгород", 411);
        this.addEdge("Москва", "Минск", 690);
        this.addEdge("Москва", "Донецк", 1084);
        this.addEdge("Москва", "С.Петербург", 664);
        this.addEdge("Мурманск", "С.Петербург", 1412);
        this.addEdge("Мурманск", "Минск", 2238);
        this.addEdge("Орел", "Витебск", 522);
        this.addEdge("Орел", "Донецк", 709);
        this.addEdge("Орел", "Москва", 368);
        this.addEdge("Одесса", "Киев", 487);
        this.addEdge("Рига", "Каунас", 267);
        this.addEdge("Таллинн", "Рига", 308);
        this.addEdge("Харьков", "Киев", 471);
        this.addEdge("Харьков", "Симферополь", 639);
        this.addEdge("Ярославль", "Воронеж", 739);
        this.addEdge("Ярославль", "Минск", 940);
        this.addEdge("Уфа", "Казань", 525);
        this.addEdge("Уфа", "Самара", 461);
    }

    /**
     * Жадный поиск по первому соответствию
     */
    public void task1(String start, String finish) {
        int n = Utility.stringToInt(start);
        visited[n] = true;
        boolean running = true;
        int sum = 0;
        int step = 0;

        System.out.println("Жадный поиск по первому соответствию:");
        System.out.print("\t");
        while (running) {
            System.out.print(this.vertexes.get(n).name + " -> ");

            int min = 9999;
            for (Edge e : vertexes.get(n).adj) {
                if (vertexes.get(e.id).h < min && !visited[e.id]) {
                    min = vertexes.get(e.id).h;
                    step = e.w;
                    n = e.id;
                }
            }
            visited[n] = true;
            sum += step;
            System.out.print(step + " -> ");
            if (n == Utility.stringToInt(finish)) {
                System.out.print(Utility.intToString(n));
                running = false;
            }
        }
        System.out.println("\n \t Общая длина: " + sum);
    }

    /**
     * Метод минимизации суммарной оценки стоимости решения А*
     */
    public void task2(String start, String finish) {
        int n = Utility.stringToInt(start);
        visited[n] = true;
        boolean running = true;
        int sum = 0;
        int step = 0;

        System.out.println("A*:");
        System.out.print("\t");
        while (running) {
            System.out.print(this.vertexes.get(n).name + " -> ");

            int min = Integer.MAX_VALUE;
            for (Edge e : vertexes.get(n).adj) {
                if (vertexes.get(e.id).h + e.w < min && !visited[e.id]) {
                    min = vertexes.get(e.id).h + e.w;
                    step = e.w;
                    n = e.id;
                }
            }
            visited[n] = true;
            sum += step;
            System.out.print(step + " -> ");
            if (n == Utility.stringToInt(finish)) {
                System.out.print(Utility.intToString(n));
                running = false;
            }
        }
        System.out.println("\n \t Общая длина:  " + sum);
    }
}
