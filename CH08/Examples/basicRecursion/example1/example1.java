package Examples.basicRecursion.example1;

class example1{
    public static void main(String[] args) {
        drawLine(4);
    }

    public static void drawLine(int num){
        if(num == 0){
            System.out.print("That's all, folks!");
        }
        else{
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.println();
            drawLine(num-1);
        }
    }
}