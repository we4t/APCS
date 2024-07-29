public class CH04 {
    public static void main(String[] args) {
        printPageIndex(175, "Inheritance and Polymorphism");
        printPageIndex(176, "Inheritance \n Superclass and Subclass");
        print("Inheritance defines a relationship between objects that share characteristics");
        print("Don’t get confused by the names: a subclass is bigger than a superclass—it contains more data and more methods!");
        print("Inheritance is very useful manner for code reuse. Since a subclass object shares features of a superclass object, the only new code required is for the additional characteristics of the subclass.");
        print("however, in class hierachy, superclass is located higher than express more classes than subclasses. Thus, like int(small extend) -> double(big extend), superClass -> subClass");
        print("there are 4 types of access modifier. private, default, protected, and public");
        print("using private, the attributes can be accessed only in the same class");
        print("using default, the attributes can be accessed only in the same package");
        print("using protected, the atttributes can be accessed only in the same class, package, and subclasses");
        print("using public, the attributes can be accessed everywhere.");
        printPageIndex(178, "INHERITING INSTANCE METHODS AND VARIABLES");
        print("To access private instance variables, a subclass must use the accessor or mutator methods that it has inherited.");
        printPageIndex(179, "METHOD OVERRIDING AND THE super KEYWORD");
        print("Any public method in a superclass can be overridden in a subclass by defining a method with the same return type and signature (name and parameter types)");
        print("calling the method of superClass is called partial overriding");
        print("This is achieved by using the keyword super in the implementation");
        print("ex) super.superMethod() + additional statements");
        print("Private methods cannot be overridden.");
        printPageIndex(179, "constructors and super");
        print("Constructors are never inherited!");
        print("If no constructor is written for a subclass, the superclass default \n constructor with no parameters is generated. \nIf the superclass does not have a default (zeroparameter) \nconstructor, but only a constructor with parameters, \na compiler error will occur. \nIf there is a default constructor in the superclass,\n inherited data members will be initialized as for the superclass. \nAdditional instance variables in the subclass \nwill get a default initialization—0 for primitive types and null for reference types.")
        print("Note : If super is used in the implementation of a subclass constructor, it must be used in the first line of the constructor body.");
        print("if no constructor is provided in a subclass, the compiler provides the following default constructor: constructor {super();}");
        print("if superclass has only one constructor with parameters, then the super() makes compile error");
        printPageIndex(180, "rules for subclasses");
        print(" A subclass can add new private instance variables.");
        print("A subclass can add new public, private, or static methods.");
        print("A subclass can override inherited methods.");
        print("A subclass may not redefine a public method as private.");
        print("A subclass may not redefine a public method as private.");
        print("A subclass should define its own constructors.");
        print("A subclass cannot directly access the private members of its superclass. It must use accessor or mutator methods.");
        printPageIndex(180, "Declaring Subclass Objects");
        print("defining GradStudent object as Student Object is able because GradStudent is-a Student");
        print("it is type of upcasting");
        printPageIndex(182, "POLYMORPHISM");
        print("A method that has been overridden in at least one subclass is said to be polymorphic.");
        print("An example is computeGrade, which is redefined for both GradStudent and UnderGrad.");
        print("Polymorphism is the mechanism of selecting the appropriate method for a particular object in a class hierarchy");
        printPageIndex(146, "Dynamic Binding(Late Binding) and Static Binding(Early Binding)");
        print("at page 147, the object u and g are refernce-known reference variable");
        print("which means, they are determinded when the program starts, which is static preference");
        print("however, the reference variable s is not determinded when the program starts");
        print("thus, the reference variable s has dynamic preference, which is called dynamic binding");
        printPageIndex(147, "example2");
        print("at example 2, for defining the studnet array, there are 6 reference type variables, so the computer allocates 24 bytes");
        print("furthermore, by using reference variable for real parameter, although the code uses for-each loop, the method can modify the objects");
        printPageIndex(148, "using super in a subclass");
        print("in example code, calling a method in Acrobat calls methods in superclass, and if the superclass's method calls another method, then the method is called which is the most nearest to the object");
        printPageIndex(149, "downcasting");
        print("because the dot operator has higher excute hierachy, we have to put two parentheses while type casting");
        
    }

    public static void printPageIndex(int page, String contents)
    {
        System.out.printf("page : %d contents : %s \n \n", page, contents);
    }

    public static void print(String msg){
        System.out.println(msg);
    }
}
