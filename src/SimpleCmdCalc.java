import java.util.ArrayList;
import java.util.Scanner;

public class SimpleCmdCalc {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();
        int i = 0;
        double firstResult;
        String act = "act";

        firstResult = getFirstResult(in, numbers, i, act);

        loopCalc(in, numbers, i, firstResult, act);
    }

    private static void loopCalc(Scanner in, ArrayList<Double> numbers, int i, double firstResult, String act) {
        double result;
        //noinspection InfiniteLoopStatement
        while (true) {

            while (i < 1) {
                System.out.println("Enter :");
                String value = in.nextLine();

                if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
                    act = value;
                } else {
                    try {
                        numbers.set(1, Double.parseDouble(value));
                        i++;
                    } catch (NumberFormatException e) {
                        System.err.println("Неверный формат строки!");
                    }
                }
            }
            numbers.set(0, firstResult);
            result = getResult(numbers, act);
            firstResult = result;
            i = 0;
        }
    }

    private static double getFirstResult(Scanner in, ArrayList<Double> numbers, int i, String act) {
        double result;
        while (i < 2) {
            System.out.println("Enter :");
            String value = in.nextLine();

            if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
                act = value;
            } else {
                try {
                    numbers.add(Double.parseDouble(value));
                    i++;
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат строки!");
                }
            }
        }
        result = getResult(numbers, act);
        return result;
    }

    private static double getResult(ArrayList<Double> numbers, String act) {
        double result = 0;
        if (act.equals("+")) {
            result = numbers.get(0) + numbers.get(1);
        } else {
            if (act.equals("-")) {
                result = numbers.get(0) - numbers.get(1);
            } else {
                if (act.equals("*")) {
                    result = numbers.get(0) * numbers.get(1);
                } else {
                    if (act.equals("/")) {
                        result = numbers.get(0) / numbers.get(1);
                    } else {
                        System.out.println("Какая-то хрень...");
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
