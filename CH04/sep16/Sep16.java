class Sep16 {
    class A {
        // attributes
        // methods
        public void a() {
            System.out.println("this is a method of A");
        }

        public void a(int tmp) {
            System.out.println("this is a method of A with integer parameter");
        }

        public void c(){
            System.out.println("this is c method of A");
        }
    }

    class B extends A {
        // attributes
        // methods
        public void a() {
            System.out.println("this is a methods of B, which is overrided");
        }
        public void b(){
            System.out.println("this is b method of B");
        }
    }
    public static void main(String[] args) {
        A a = new A();
        a.a();
        a.a(3); //able

        B b = new B();
        b.a();
        b.a(5);
        b.b();
        b.c();

        A c = new B();
        c.c();
        c.a();
        ((B)c).b(); // able
        // (B)c.b(); -> not able : dot operators operates, then type cast operator operates 
    }


}
