import java.util.LinkedList;

public class Printer {
    public static void printResult(LinkedList<String> result, String dest) {
        System.out.print("\t");
        for (String s : result) {
            if (!s.equals(dest)) {
                System.out.print(s + " -> ");
            } else {
                System.out.println(s);
                return;
            }

            if (result.indexOf(s) == result.size() - 1) {
                System.out.println("X");
                return;
            }
        }
    }

    public static void printResult(LinkedList<String> result, LinkedList<String> revResult) {
        System.out.print("\t");
        for (String s : result) {
            System.out.print(s + " -> ");
        }
        for (int i = revResult.size() - 1; i >= 0; i--) {
            System.out.print(i == revResult.size() - 1 ? revResult.get(i) : " <- " + revResult.get(i));
        }
        System.out.println();
    }
}
