import java.util.*;

public class MonteCarloIntegration {
    private ArrayList<Character> variables = new ArrayList<Character>();
    private ArrayList<Double> coefficients = new ArrayList<Double>();
    private ArrayList<Integer> exponents = new ArrayList<Integer>();
    private String function;
    private double start, end;

    // constructor

    public MonteCarloIntegration(String tmpFunction) {
        function = tmpFunction;
        tmpFunction = formatFunction(tmpFunction);
        interpretFunction(tmpFunction);
    }

    public String formatFunction(String function) {
        function = function.toLowerCase(); // lowercase
        function = function.replace(" ", ""); // delete spaces
        function = function.replace("*", ""); // delete *
        function = function.replace("+", " "); // split function into polies
        function = function.replace("-", " -"); // split function into polies
        return function;
    }

    public void interpretFunction(String function) {
        String[] polynomials = function.split(" ");
        for (String string : polynomials) {
            char firstChar = string.charAt(0);
            if (firstChar >= 97 && firstChar <= 122) {
                string = "1" + string;
            }
            System.out.println(string);
            interpretPoly(string);
        }
    }

    // interpreting Poly
    public void interpretPoly(String poly) {
        // 1. oper : +, -, *, /
        // input example : 3xx
        double coefficient = 0;
        int exponent = 0;
        int sign = 1;
        for (int i = 0; i < poly.length(); i++) {
            char currentchar = poly.charAt(i);
            int x = (int) currentchar;
            if (x == 45)
                sign = -1;
            else if (x >= 48 && x <= 57) { // (int)'0' -> 48, (int)'9' -> 57
                while (i < poly.length() && poly.charAt(i) >= 48 && poly.charAt(i) <= 57) {
                    coefficient = coefficient * 10 + (int) (poly.charAt(i)) - 48;
                    i++;
                }
                coefficients.add(coefficient * sign);
                coefficient = 0;
                sign = 1;
                if (i == poly.length()) {
                    exponents.add(0);
                }
                i--;
            }
            if (x >= 97 && x <= 122) { // (int)'a' = 97, (int)'z' = 122
                while (i < poly.length() && poly.charAt(i) == x) { // xxxxx -> exponent = 5, variable = x
                    exponent++;
                    i++;
                }
                exponents.add(exponent);
                if (variables.indexOf(currentchar) == -1)
                    variables.add(currentchar);
                exponent = 0;
            }
        }
    }

    public double function(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, exponents.get(i));
        }
        return result;
    }

    public double[] getMaxAndMin(double a, double b) {
        double dx = 0.001, min = 0, max = 0, tmp;
        for (double i = a; i <= b; i += dx) {
            tmp = function(i);
            if (min > tmp)
                min = tmp;
            if (max < tmp)
                max = tmp;
        }
        return new double[] { min, max };
    }

    public double generate(double a, double b, Random rnd) {
        return (b - a) * rnd.nextDouble() + a;

    }

    public double integrate(double start, double end) {
        int sign = 1, inner = 0;
        final int loop = 100000000;
        double x, y;
        if (start > end) {
            double tmp = end;
            start = end;
            end = start;
            sign = -1;
        }
        double[] maxAndMin = getMaxAndMin(start, end);
        double area = (maxAndMin[1] - maxAndMin[0]) * (end - start);
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 1; i < loop; i++) {
            x = generate(start, end, rnd);
            y = generate(0, maxAndMin[1], rnd);
            if (y * (y - function(x)) < 0) {
                inner += (int) Math.signum(y);
            }
        }
        return (double) sign * inner / loop * area;
    }

    public String toString() {
        String msg = "";
        msg += "variables : " + variables.toString() + "\n" + "coefficients : " + coefficients.toString() + "\n"
                + "exponents : " + exponents.toString() + "\n" + "function : " + function;
        return msg;
    }
}
