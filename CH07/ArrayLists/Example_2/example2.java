package ArrayLists.Example_2;
import java.util.*;

public class example2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            list.add(i*i);
        }
        System.out.println(list);
        swap(list, 0, 1);
        System.out.println(list);

    }

    public static void swap(ArrayList<Integer> list, int i, int j){
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
