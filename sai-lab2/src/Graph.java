import java.util.*;

public class Graph {
    private LinkedList<Integer>[] adjLists;
    private boolean[] visited;
    private final int V = 27;
    private LinkedList<String> result = new LinkedList<>();
    private LinkedList<String> revResult = new LinkedList<>();

    Graph() {
        adjLists = new LinkedList[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++)
            adjLists[i] = new LinkedList<Integer>();

        this.addEdge("Вильнюс", "Брест");
        this.addEdge("Витебск", "Брест");
        this.addEdge("Витебск", "Вильнюс");
        this.addEdge("Воронеж", "Витебск");
        this.addEdge("Воронеж", "Волгоград");
        this.addEdge("Волгоград", "Витебск");
        this.addEdge("Витебск", "Ниж.Новгород");
        this.addEdge("Вильнюс", "Даугавпилс");
        this.addEdge("Калининград", "Брест");
        this.addEdge("Калининград", "Вильнюс");
        this.addEdge("Каунас", "Вильнюс");
        this.addEdge("Киев", "Вильнюс");
        this.addEdge("Киев", "Житомир");
        this.addEdge("Житомир", "Донецк");
        this.addEdge("Житомир", "Волгоград");
        this.addEdge("Кишинев", "Киев");
        this.addEdge("Кишинев", "Донецк");
        this.addEdge("С.Петербург", "Витебск");
        this.addEdge("С.Петербург", "Калининград");
        this.addEdge("С.Петербург", "Рига");
        this.addEdge("Москва", "Казань");
        this.addEdge("Москва", "Ниж.Новгород");
        this.addEdge("Москва", "Минск");
        this.addEdge("Москва", "Донецк");
        this.addEdge("Москва", "С.Петербург");
        this.addEdge("Мурманск", "С.Петербург");
        this.addEdge("Мурманск", "Минск");
        this.addEdge("Орел", "Витебск");
        this.addEdge("Орел", "Донецк");
        this.addEdge("Орел", "Москва");
        this.addEdge("Одесса", "Киев");
        this.addEdge("Рига", "Каунас");
        this.addEdge("Таллинн", "Рига");
        this.addEdge("Харьков", "Киев");
        this.addEdge("Харьков", "Симферополь");
        this.addEdge("Ярославль", "Воронеж");
        this.addEdge("Ярославль", "Минск");
        this.addEdge("Уфа", "Казань");
        this.addEdge("Уфа", "Самара");
    }

    private void addEdge(String src, String dest) {
        adjLists[Utility.stringToInt(src)].add(Utility.stringToInt(dest));
        adjLists[Utility.stringToInt(dest)].add(Utility.stringToInt(src));
    }

    /**
     * Поиск в глубину
     */
    public void DFS(String start, String finish) {
        int vertex = Utility.stringToInt(start);
        int dest = Utility.stringToInt(finish);
        visited[vertex] = true;

        this.result.add(Utility.intToString(vertex));

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj] && !visited[dest]) {
                DFS(Utility.intToString(adj), Utility.intToString(dest));
            }
        }
    }

    /**
     * Поиск в ширину
     */
    public void BFS(String start, String finish) {
        int s = Utility.stringToInt(start);
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            this.result.add(Utility.intToString(s));
            if (Utility.intToString(s).equals(finish)) return; //STOP SEARCHING WHEN WE REACH DEST

            Iterator<Integer> i = adjLists[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    /**
     * Двунаправленный поиск
     */
    public void BSA(String start, String finish) {
        boolean[] visitedF = new boolean[V];
        int vStart = Utility.stringToInt(start);
        int vFinish = Utility.stringToInt(finish);
        LinkedList<Integer> queueStart = new LinkedList<>();
        LinkedList<Integer> queueFinish = new LinkedList<>();
        visited[vStart] = true;
        visited[vFinish] = true;
        queueStart.add(vStart);
        queueFinish.add(vFinish);

        while (queueStart.size() != 0 && queueFinish.size() != 0) {
            vStart = queueStart.poll();
            vFinish = queueFinish.poll();
            result.add(Utility.intToString(vStart));
            revResult.add(Utility.intToString(vFinish));

            Iterator<Integer> iStart = adjLists[vStart].listIterator();
            Iterator<Integer> iFinish = adjLists[vFinish].listIterator();

            while (iStart.hasNext() && iFinish.hasNext()) {
                int nS = iStart.next();
                int nF = iFinish.next();
                if (!visited[nS]) {
                    visited[nS] = true;
                    if (visitedF[nS]) {
                        result.add(Utility.intToString(nS));
                        return;
                    }
                    queueStart.add(nS);
                }
                if (!visitedF[nF]) {
                    visitedF[nF] = true;
                    if (visited[nF]) {
                        revResult.add(Utility.intToString(nF));
                        return;
                    }
                    queueFinish.add(nF);
                }
            }
        }

    }

    /**
     * Поиск с ограничением глубины
     */
    public void DLS(String start, String finish, int depth, int limit) {
        int vertex = Utility.stringToInt(start);
        int dest = Utility.stringToInt(finish);
        visited[vertex] = true;

        this.result.add(Utility.intToString(vertex));

        Iterator<Integer> ite = adjLists[vertex].listIterator();

        if (depth < limit) {
            while (ite.hasNext()) {
                int adj = ite.next();
                if (!visited[adj] && !visited[dest]) {
                    int temp = depth;
                    DLS(Utility.intToString(adj), Utility.intToString(dest), ++temp, limit);
                }
            }
        }
    }

    /**
     * Поиск с итеративным углублением
     */
    public void IDDFS(String start, String finish, int depth, int startLimit) {
        while (!result.contains(finish)) {
            this.DLS(start, finish, depth, startLimit++);
            System.out.print("\tLimit " + (startLimit - 1) + ": ");
            Printer.printResult(result, finish);

            clearVisited();
            if (!result.contains(finish)) result.clear();
        }
    }

    private void clearVisited() {
        for (int i = 0; i < this.V; i++) this.visited[i] = false;
    }

    public LinkedList<String> getResult() {
        return result;
    }

    public LinkedList<String> getRevResult() {
        return revResult;
    }
}
