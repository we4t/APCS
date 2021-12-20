class SuperClass {
    //attributes
    protected int a = 5;
    
    //methods
    public void superClassMethod(){
        System.out.println("this is super Class Method");
    }


}

class SubClass extends SuperClass {
    public void printA(){
        System.out.println("the protected a : " + a);
    }   
}

class Sep17{
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        SubClass subClass = new SubClass();
        subClass.printA();
        System.out.println(subClass.a);
    }
}