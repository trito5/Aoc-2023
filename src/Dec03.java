import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Node;
import static utils.FileReader.toStringList;

public class Dec03 {

    public static void run() {
        var input = toStringList("files/3.txt");
        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        List<Node> nodes = new ArrayList<>();
        List<Node> noList = new ArrayList<>();
        var tot = 0;
        changeNodes(input, nodes, noList);
        for (Node n : nodes) {
            if (!noList.contains(n)) {
                if (hasNeighbours(n, nodes)) {
                    tot += n.num;
                }
            }

        }
        System.out.println(tot);
    }

    public static void part2(List<String> input) {
        List<Node> nodes = new ArrayList<>();
        List<Node> noList = new ArrayList<>();
        var tot = 0;
        changeNodes(input, nodes, noList);
        Map<Integer, Integer> m = new HashMap<>();
        for (Node n : nodes) {
            if (!noList.contains(n)) {
                var index = returnMultiplerIndex(n, nodes);
                if (index >= 0) {
                    if (m.containsKey(index)) {
                        int i = m.get(index) * n.num;
                        tot += i;
                    } else {
                        m.put(index, n.num);
                    }
                }
            }

        }
        System.out.println(tot);
    }

    public static void changeNodes(List<String> input, List<Node> nodes, List<Node> noList) {
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(y).length(); x++) {
                char c = input.get(y).charAt(x);
                if (c != '.') {
                    Node n = new Node(x, y, c);
                    if (noList.contains(n)) {
                        continue;
                    }
                    var num = String.valueOf(c);
                    if (num.matches("^-?\\d+$")) {
                        try {
                            n.num = Integer.parseInt(num);
                            num += String.valueOf(input.get(y).charAt(x + 1));
                            n.num = Integer.parseInt(num);
                            noList.add(new Node(x + 1, y));
                            n.steps = 1;
                            num += String.valueOf(input.get(y).charAt(x + 2));
                            n.num = Integer.parseInt(num);
                            noList.add(new Node(x + 2, y));
                            n.steps = 2;
                            num += String.valueOf(input.get(y).charAt(x + 3));
                            n.num = Integer.parseInt(num);
                            noList.add(new Node(x + 3, y));
                            n.steps = 3;
                        } catch (Exception e) {
                            //swallow
                        }
                    }
                    nodes.add(n);
                }
            }
        }
    }

    public static boolean hasNeighbours(Node me, List<Node> nodes) {
        for (int x = - 1; x <= 1 + me.steps; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {
                    continue;
                } else {
                    Node temp = new Node(me.x + x, me.y + y);
                    int index = nodes.indexOf(temp);
                    if (index >= 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int returnMultiplerIndex(Node me, List<Node> nodes) {
        for (int x = - 1; x <= 1 + me.steps; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {
                    continue;
                } else {
                    Node temp = new Node(me.x + x, me.y + y);
                    int index = nodes.indexOf(temp);
                    if (index >= 0 && nodes.get(index).c =='*') {
                        return index;
                    }
                }
            }
        }
        return -1;
    }

}
