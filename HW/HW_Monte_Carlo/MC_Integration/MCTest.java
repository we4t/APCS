public class MCTest {
    public static void main(String[] args) {
        MonteCarloIntegration x2 = new MonteCarloIntegration("x*x+ 3");
        System.out.println(x2);
        System.out.println(x2.integrate(0, 3));
    }
}
