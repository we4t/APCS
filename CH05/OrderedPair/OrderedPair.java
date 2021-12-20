public class OrderedPair {
    private double x;
    private double y;


    //constructor
    public OrderedPair(double a, double b){
        x = a;
        y = b;
    }
    //override
    public String toString(){
        return "(" + x + " , " + y + ")";
    }
}
