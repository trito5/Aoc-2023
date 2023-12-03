import java.util.List;
import static utils.FileReader.toStringList;

public class Dec01 {

    public static void run() {
        var input = toStringList("files/1.txt");
        part1(input);
        part2(input);

    }

    public static void part1(List<String> input) {
        var tot = 0;
        for (String s : input) {
            String s1 = s.replaceAll("[a-z]*", "");
            String s2 = String.valueOf(s1.charAt(0)) + String.valueOf(s1.charAt(s1.length() - 1));
            tot += Integer.parseInt(s2);
        }
        System.out.println(tot);
    }

    public static void part2(List<String> input) {
        var tot = 0;
        for (String s : input) {
            String rep = s.replace("zero", "0");
            rep = s.replaceAll("one", "one1one");
            rep = rep.replaceAll("two", "two2two");
            rep = rep.replaceAll("three", "three3three");
            rep = rep.replaceAll("four", "four4four");
            rep = rep.replaceAll("five", "five5five");
            rep = rep.replaceAll("six", "six6six");
            rep = rep.replaceAll("seven", "sevem7seven");
            rep = rep.replaceAll("eight", "eight8eight");
            rep = rep.replaceAll("nine", "nine9nine");
            rep = rep.replaceAll("[a-z]", "");

            String s2 = rep.charAt(0) + "" + rep.charAt(rep.length() - 1);
            tot += Integer.parseInt(s2);
        }
       System.out.println(tot); //54100
    }


}
