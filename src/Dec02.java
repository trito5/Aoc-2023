import java.util.List;
import static utils.FileReader.toStringList;

public class Dec02 {

    public static void run() {
        var input = toStringList("files/2.txt");
        part1(input);
        part2(input);

    }

    public static void part1(List<String> input) {
        var red = 12;
        var green = 13;
        var blue = 14;
        var counter = 0;
        boolean add;
        var tot = 0;
        for (String line : input) {
            add = true;
            counter++;
            var rounds = line.split(": ")[1].split("; ");

            for (String r : rounds) {
                var cubes = r.split(", ");
                for (String c : cubes) {
                    var cube = c.split(" ");
                    var num = Integer.parseInt(cube[0].trim());
                    var col = cube[1];
                    if (col.equals("red") && num > red) {
                        add = false;
                        break;
                    }
                    if (col.equals("green") && num > green) {
                        add = false;
                        break;
                    }
                    if (col.equals("blue") && num > blue) {
                        add = false;
                        break;
                    }

                }
            }
            if (add) {
                tot += counter;
            }
        }
        System.out.println(tot);
    }

    public static void part2(List<String> input) {
        var counter = 0;
        var tot = 0;
        for (String line : input) {
            var red = 1;
            var blue = 1;
            var green = 1;
            counter++;
            var rounds = line.split(": ")[1].split("; ");

            for (String r : rounds) {
                var cubes = r.split(", ");
                for (String c : cubes) {
                    var cube = c.split(" ");
                    var num = Integer.parseInt(cube[0]);
                    var col = cube[1];
                    if (col.equals("red") && num > red) {
                        red = num;
                    }
                    if (col.equals("green") && num > green) {
                        green = num;

                    }
                    if (col.equals("blue") && num > blue) {
                        blue = num;
                    }
                }
            }
            tot += (red * blue * green);
        }
        System.out.println(tot);
    }

}
