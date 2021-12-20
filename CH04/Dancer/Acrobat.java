public class Acrobat extends Dancer {
    // overriding
    public void act() {
        super.act();
        System.out.println(" flip ");
    }

    public void doTrick() {
        System.out.println(" somerResult ");
    }
}
