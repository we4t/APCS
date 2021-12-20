public class StringTest {
    public static void main(String[] args) {
        String a = new String("abc");
        String b = new String("abc");
        System.out.println("is constructing String Object with constructor with same parameter is identical (==)? : ");
        System.out.println(a==b);
        
        String c = "abc";
        String d = "abc";
        System.out.println("is constructing String Object with string constant with same parameter is identical (==)? : ");
        System.out.println(c==d);
        
        String initMsg = new String("first");
        System.out.println(System.identityHashCode(initMsg));
        initMsg = initMsg.substring(2);
        System.out.println(System.identityHashCode(initMsg));

        

    } 
}
