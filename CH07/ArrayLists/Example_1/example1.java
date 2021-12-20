

import java.util.*;

public class example1{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            list.add(i*i); //autoboxing
        }

        System.out.println(list);

        int a = list.get(2);
        System.out.println(a);

        Integer x = list.set(3, 5);
        System.out.println(x + " \n" + list);

        x = list.remove(2);
        System.out.println(x + " \n" + list);

        list.add(1, 7);
        System.out.println(list);
        list.add(2, 8);
        System.out.println(list);
    }
}