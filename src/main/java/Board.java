import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {


    private final char[][] boardTable;
    int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.boardTable = new char[boardSize][boardSize];
        for(int i=0;i<boardSize;i++)
            for(int j=0;j<boardSize;j++)
                boardTable[i][j] = ' ';
    }

    public char getField(int[] tab){
        return getField(tab[0],tab[1]);
    }
    public void move(int[] firstlocation, int[] secondlocation){
        boardTable[secondlocation[0]][secondlocation[1]] = boardTable[firstlocation[0]][firstlocation[1]];
        boardTable[firstlocation[0]][firstlocation[1]] = ' ';
    }

    public char getField(int x, int y) {
        if(x>=boardSize || y>=boardSize || x<0 || y<0 )
            return 0;
        else
            return boardTable[x][y];
    }

    public void addWolf(int x, int y) {
        boardTable[x][y] = 'w';
    }

    public void addSheep(int x, int y) {
        boardTable[x][y] = 'o';
    }

    public void viewBoard(){
        for(int y=-1;y<boardSize;y++){
            for(int x=-1;x<boardSize;x++){
                if(y == -1){
                    if(x != -1)
                        if(x != 0)
                            System.out.print(" | " + (char) (x+'A' -1));
                        else
                            System.out.print(" |  ");
                    if(x == boardSize-1) System.out.print(" |");
                }
                else if(x == -1) {
                    if (y != -1) {
                        System.out.print(" | " + (y + 1));
                    }
                }
                else
                    System.out.print(" | " + boardTable[x][y]);
            }
            System.out.println();
        }

    }


    public int getBoardSize() {
        return boardSize;
    }
}
