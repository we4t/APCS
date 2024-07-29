class CH02 {
    public static void main(String args[]) {
        printPageIndex(97, "TYPE AND IDENTIFIERS");
        int x;
        x = 27;
        double y, z;
        boolean found;
        int count = 1; // count initialized to 1
        double p = 2.3, q = 4.1; // p and q initialized to 2.3 and 4.1

        printPageIndex(98, "explicit casting");

        int total, n;
        double average;
        total = 600;
        n = 7;
        average = (double) total / n;
        average = total / (double) n; // Same result as line 16

        printPageIndex(98, "implicit casting");
        int num = 5;
        double realNum = num; // num is cast to double
        System.out.println("casting double to int without explicit casting causes compile time error");

        printPageIndex(98, "how to round double variables");
        double roundableNum = 4.4;
        int roundNum = (int) (roundableNum + 0.5);
        roundableNum = -4.4;
        roundNum = (int) (roundableNum - 0.5);

        printPageIndex(99, "Storages of Numbers");
        System.out.printf("the scope of byte : %d ~ %d", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("the scope of short : %d ~ %d", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("the scope of int : %d ~ %d", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("the scope of long : %d ~ %d", Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("the scope of float : %f ~ %f", Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("the scope of double : %f ~ %f", Double.MIN_VALUE, Double.MAX_VALUE);
        System.out.println("float has 1 sign bit, 8 exponet bit, and 23 mantisa bit");
        System.out.println("DOUBLE has 1 sign bit, 11 exponent bit, and 52 mantisa bit");

        printPageIndex(99, "comparing floating-point numbers");
        System.out.printf("the result of 0.1*26 == 0.1 + ... + 0.1 is false");

        printPageIndex(100, "Nan and Infinity");
        System.out.println(
                "When an operation is performed that gives an undefined result, \n Java expresses this result as NaN, not a number.\n Examples of operations that produce NaN are: \ntaking the square root of a negative number, \nand 0.0 divided by 0.0.");
        System.out.println(
                "An operation that gives an infinitely large or infinitely small number, \n like division by zero, produces a result of Infinity or -Infinity in Java.");

        printPageIndex(100, "Final Variables");
        System.out.println("A final variable or user-defined constant, identified by the keyword final");

        printPageIndex(102, "OPERATORS");
        System.out.println("Arithmetic Operators : +, -, *, /, %(reaminder)");
        System.out.println("(double) (3/4) => 0");
        System.out.println("precedence : () -> * / % -> +, -");

        printPageIndex(103, "Relational Operators");
        System.out.println("Relational Operators : ==, !=, >, <, >=, <=");
        System.out.println("return p==q // returns true if p equals q, otherwise false");

        printPageIndex(104, "significant digit of float and double");
        System.out.println("float : 7, double : 15");

        printPageIndex(105, "Logical Operators");
        System.out.println("Logical Operators : !, &&, ||");

        printPageIndex(105, "short-circuit evaluation");
        System.out.println("in &&, second operand does not evaluate when the first condition is false");
        System.out.println("in ||, second operand does not evaluate when the first condition is true");
        System.out.println(
                "if (numScores != 0 && scoreTotal/numScores > 90) will not cause a run time error if numscores == 0");

        printPageIndex(106, "Assignment Operators");
        System.out.println("Assignment Operators : =, +=, -=, *=, /=, %=");
        System.out.println("Assignment always operates from right to left");

        printPageIndex(106, "Inc / Dec operators");
        System.out.println("i++ -> i and ++, ++i -> ++ and i");

        printPageIndex(107, "Operator Precedence");
        System.out.println("Unary -> Arithmetic -> Relational -> Logical -> Assignment");
        System.out.println("Logic : ! -> and -> or");

        printPageIndex(108, "Input/Output");
        System.out.println("value of x is" + x);

        printPageIndex(110, "Escape Sequence");
        System.out.println("There are two general types : decision-making and iteration.");

        printPageIndex(111, "if else-if");
        n = 7; //read user input
        if (n > 0)
            if (n % 2 == 0)
                System.out.println(n);
        else
            System.out.println(n + " is not positive");
        // 7 is not positive
        
        printPageIndex(112, "iteration");
        /*
        for (initialization; termination condition; update statement)
        {
            statements //body of loop
        }
        */
        
        for (int i = 1; i < 5; i++)
            System.out.print(i + " ");

        printPageIndex(113, "for-each loop");

        System.out.println("made an array that has 0 1 2 3 4 5, and print these indexes by using for-each loop");
        int[] a = {0,1,2,3,4,5};
        for (int i : a) {
            System.out.println(i);            
        }

        printPageIndex(118, "errors and exceptions");
        System.out.println("all errors have equal parnent class : java.lang.Object/java.lang.Throwable/java.lang.Exception/java.lang.RuntimeException");
        System.out.println("The book gives six errors : ArithmeticException, NullPointerException, IndexOutOfBoundsException, ArrayIndexOutOfBoundsException, IllegalArgumentException, ConcurrentModificationException");
        System.out.println("An IllegalArgumentException is thrown to indicate that a parameter does not satisfy a method precondition.");
    }

    public static void printPageIndex(int page, String topic) {
        System.out.printf("\npage : %d, contents : %s\n", page, topic);
    }
}