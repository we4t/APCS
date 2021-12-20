public class MyScope {
    private double start;
    private double end;

    public MyScope(double s, double e) {
        start = s;
        end = e;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public void setStart(double x){
        start = x;
    }

    public void setEnd(double x){
        end = x;
    }

    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}
