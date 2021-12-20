package ArrayLists.Example_3;
import java.util.*;

public class example3 {
    public static void main(String[] args) {
        System.out.println(getRandomIntList());
    }

    public static ArrayList<Integer> getRandomIntList(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            int newNum = (int) (Math.random() * 101);
            list.add(newNum);
        }
        return list;
    }
}
