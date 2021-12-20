package Examples.recursion_in_2_dim_grid;

public class example1 {

    public static void main(String[] args) {
        Image im = new Image(9, 9);
        im.printImage();
        System.out.println();
        im.eraseBlackBlob(0, 0);
        System.out.println();
        im.printImage();
        System.out.println();
        im.printOrder();
    }
}

class Image {
    private final int BLACK = 1;
    private final int WHITE = 0;
    private int row, col, cnt = 0;
    private int[][] image;
    private int[][] order;

    public Image(){
        this(8, 8);
    }
    public Image(int a, int b) {
        row = a;
        col = b;
        image = new int[a][b];
        order = new int[a][b];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i == 0 || j == 0 || i == a - 1 || j == b - 1 || i == a/2 || j == b/2)image[i][j] = BLACK;
                else image[i][j] = WHITE;
                order[i][j] = 0;
            }
        }
    }

    public void printImage() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(image[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void printOrder() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(order[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public void eraseBlackBlob(int row, int col){
        if(row >= 0 && row < this.row && col >= 0 && col < this.col){
            if(image[row][col] == BLACK){
                image[row][col] = WHITE;
                order[row][col] = ++cnt;
                eraseBlackBlob(row + 1, col);
                eraseBlackBlob(row - 1, col);
                eraseBlackBlob(row, col - 1);
                eraseBlackBlob(row, col + 1);
            }
        }
    }

    public void eraseWhiteBlob(int row, int col){
        if(row >= 0 && row < this.row && col >= 0 && col < this.col){
            if(image[row][col] == WHITE){
                image[row][col] = BLACK;
                order[row][col] = ++cnt;
                eraseWhiteBlob(row + 1, col);
                eraseWhiteBlob(row - 1, col);
                eraseWhiteBlob(row, col - 1);
                eraseWhiteBlob(row, col + 1);
            }
        }
    }

    public boolean isBlack(int r, int c){
        return image[r][c] == BLACK;
    }

    public boolean isWhite(int r, int c){
        return image[r][c] == WHITE;
    }
}