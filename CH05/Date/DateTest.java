import java.sql.Date;

public class DateTest {
    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        Date d1 = new Date(millis);
        Date d2 = new Date(millis);
        Date d3 = d1;
        System.out.println(d1 == d3);
        System.out.println(d2 == d3);
        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));
        System.out.println(d1.equals(d3));
        System.out.println(d2.equals(d3));
    }
}
