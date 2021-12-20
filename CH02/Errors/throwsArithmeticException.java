class throwsArithmeticException
{
    public static void main(String[] args){
        int divideNum = 0;
        if(divideNum == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
}