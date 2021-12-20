public class sample1 {
    public static void main(String[] args) {
        ColorGrid c1 = new ColorGrid("rrbgyybrbyrrggrrrbyrryrb", 4, 6);
        c1.printColor();
        c1.paintRegion(2, 3, 'b', c1.getChar(2, 3));
        System.out.println();
        c1.printColor();        
    }
}

class ColorGrid{
    private char[][] pixels;
    private int rows;
    private int cols;

    public ColorGrid(String s, int rowNum, int colNum){
        rows = rowNum;
        cols = colNum;
        pixels = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                pixels[i][j] = s.charAt(cols * i + j);
            }
        }
    }

    public char getChar(int row, int col){
        return pixels[row][col];
    }

    public void paintRegion(int row, int col, char newColor, char oldColor){
        if(row >= 0 && row < rows && col >= 0 && col < cols){
            if(pixels[row][col] == oldColor){
                pixels[row][col] = newColor;
                paintRegion(row + 1, col, newColor, oldColor);
                paintRegion(row - 1, col, newColor, oldColor);
                paintRegion(row, col - 1, newColor, oldColor);
                paintRegion(row, col + 1, newColor, oldColor);
            }
        }
    }

    public void printColor(){
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                System.out.print(pixels[i][j] + " ");
            }
            System.out.println();
        }
    }
}
