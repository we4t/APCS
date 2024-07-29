public class MCGITest {
    public static void main(String[] args) {
        MCGraphIntegration circle = new MCGraphIntegration("x*y< 1");
        circle.setScope('x', 1, 2);
        circle.setScope('y', 0.5, 1);
        System.out.println(circle);
        System.out.println(circle.calMC());
    }
}   
