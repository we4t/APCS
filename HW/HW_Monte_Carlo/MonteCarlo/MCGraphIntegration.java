import java.util.*;

public class MCGraphIntegration {
    private ArrayList<Character> variables = new ArrayList<Character>();
    private ArrayList<String> varPoly = new ArrayList<String>();
    private ArrayList<Double> coefficients = new ArrayList<Double>();
    private ArrayList<Integer> exponents = new ArrayList<Integer>();
    private ArrayList<MyScope> scopes = new ArrayList<MyScope>();
    private String condition;
    private char compareOper;
    private double compareNum;
    private int polyNum = 0;
    private Random random = new Random(System.currentTimeMillis()); 
    
    public MCGraphIntegration(String tmpCondition) {
        condition = tmpCondition;
        tmpCondition = formatCondition(tmpCondition);
        interpretCondition(tmpCondition);
    }

    public String formatCondition(String condition) {
        condition = condition.toLowerCase(); // lowercase
        condition = condition.replace(" ", ""); // delete spaces
        condition = condition.replace("*", ""); // delete *
        condition = condition.replace("+", " "); // split condition into polies
        condition = condition.replace("-", " -"); // split condition into polies
        if (condition.indexOf(">") >= 0) {
            compareOper = '>';
            compareNum = Double.parseDouble(condition.substring(condition.indexOf(">") + 1, condition.length()));
            condition = condition.substring(0, condition.indexOf(">"));
        } else if (condition.indexOf("<") >= 0) {
            compareOper = '<';
            compareNum = Double.parseDouble(condition.substring(condition.indexOf("<") + 1, condition.length()));
            condition = condition.substring(0, condition.indexOf("<"));
        }
        return condition;
    }

    public void interpretCondition(String condition) {
        String[] polynomials = condition.split(" ");
        for (String string : polynomials) {
            char firstChar = string.charAt(0);
            if (firstChar >= 97 && firstChar <= 122) {
                string = "1" + string;
            }
            else if( firstChar == 45 && string.charAt(1) >= 97 && string.charAt(1) <= 122){
                string = "-1"+string.substring(1,string.length());
            }
            //System.out.println(string);
            interpretPoly(string);
        }
    }

    public void interpretPoly(String poly) {
        double coefficient = 0;
        int exponent = 0;
        int sign = 1;
        for (int i = 0; i < poly.length(); i++) {
            char curChar = poly.charAt(i);
            if (curChar == 45) {
                sign = -1;
            } else if (curChar >= 48 && curChar <= 57) { // (int)'0' -> 48, (int)'9' -> 57
                while (i < poly.length() && poly.charAt(i) >= 48 && poly.charAt(i) <= 57) {
                    coefficient = coefficient * 10 + (int) (poly.charAt(i)) - 48;
                    i++;
                }
                i--;
                coefficients.add(coefficient * sign);
                coefficient = 0;
                sign = 1;
                if (i == poly.length() - 1) { // last poly
                    exponents.add(0);
                }
            } else if (curChar >= 97 && curChar <= 122) {
                String tmp = "";
                while (i < poly.length() && poly.charAt(i) >= 97 && poly.charAt(i) <= 122) {
                    tmp += Character.toString(poly.charAt(i));
                    exponent++;
                    if (variables.indexOf(poly.charAt(i)) == -1) {
                        variables.add(poly.charAt(i));
                        scopes.add(new MyScope(0, 0));
                    }
                    i++;
                }
                i--;
                if (varPoly.indexOf(tmp) == -1) {
                    varPoly.add(tmp);
                }
                tmp = "";
                exponents.add(exponent);
                exponent = 0;
            }
        }
    }

    public void setScope(char x, double start, double end){
        int index = variables.indexOf(x);
        if(index == -1) return;
        else{
            scopes.get(index).setStart(start);
            scopes.get(index).setEnd(end);
        }
    }

    public double generate(double start, double end){
        return (end - start)*random.nextDouble() + start;
    }

    public double calPoly(String poly){
        double[] var = new double[variables.size()];
        int exponent = 0;
        int i = 0;
        double result = 1;
        for (char v : variables) {
            exponent = poly.length() - poly.replaceAll(Character.toString(v),"").length();
            var[i] = generate(scopes.get(i).getStart(), scopes.get(i).getEnd());
            result *= Math.pow(var[i], exponent);
            i++;
        }
        if(result == 1){
            result = 0;
        }
        return result;
    }
    
    public double calculate(){
        double sum = 0;
        int i = 0;
        for (String cal : varPoly) {
            sum += coefficients.get(i)*calPoly(cal);
            i++;   
        }
        return sum;
    }

    public double calMC(){
        final int loop = 10000000;
        int inner = 0;
        double totalS = 1;
        for (int i = 0; i < variables.size(); i++) 
        {
            totalS *= scopes.get(i).getEnd()-scopes.get(i).getStart();
        }
        for (int i = 0; i < loop; i++) {
            double lValue = calculate();
            if(compareOper == '>'){
                if(lValue > compareNum){
                    inner++;
                }
            }
            else if(compareOper == '<'){
                if(lValue < compareNum){
                    inner++;
                }
            }
        }
        return totalS*inner/loop;
    }

    public String toString() {
        String msg = "";
        msg += "variables : " + variables.toString() + "\n" + "coefficients : " + coefficients.toString() + "\n"
                + "exponents : " + exponents.toString() + "\n" + "condition : " + condition + "\ncompare operator : "
                + compareOper + "\nvariable Polynomials : " + varPoly.toString() + "\nscopes : " ;
        for (MyScope scope : scopes) {
            msg += scope.toString() + ", ";
        }
        msg = msg.substring(0, msg.length() - 2);
        return msg;
    }
}
