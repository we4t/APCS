public class CH03 {
    public static void main(String[] args) {
        printPageIndex(139, "Objects");
        System.out.println("A program that maintains a database of all books in a library has at least two objects");
        System.out.println("A Book object, with operations like getTitle, getAuthor, isOnShelf, isFiction, and goOutOfPrint.");
        System.out.println("A ListOfBooks object, with operations like search, addBook, removeBook, and sortByAuthor.");
        System.out.println("Book myBook = new Book()");
        System.out.println("myBooke is called object reference");

        printPageIndex(140, "Classes");
        System.out.println("A class is a software blueprint for implementing objects of a given type");
        
        printPageIndex(141, "PUBLIC, PRIVATE, STATIC");
        System.out.println("public signals that the class is usable by all client programs");
        System.out.println("If class is not public, it can be used only by classes in its own package");
        System.out.println("Similarly, public methods are accessible to all client programs.");
        System.out.println("in the AP Java subset all instance variables are private");
        System.out.println("A static variable (class variable) contains a value that is shared by all instances of the class. Static means that memory allocation happens once.");
         
        printPageIndex(142, "METHODS - Headers");
        System.out.println("Header : access specifier, return type, method name, parameter list");

        printPageIndex(142, "TYPE OF METHODS");
        System.out.println("Constructors : creates an object of class.");
        System.out.println("Constructors are 1. Have same name with Object 2. does not have any return type 3. excuted with keyword new");

        printPageIndex(143, "ACCESSORS");
        System.out.println("An accessor method is a public method that accesses a class object without altering the object.");

        printPageIndex(143, "MUATORS");
        System.out.println("A mutator method changes the state of an object by modifying at least one of its instance variables.");
        
    }

    public static void printPageIndex(int page, String index) {
        System.out.printf("page : %d, contents : %s \n\n", page, index);
    }
}


