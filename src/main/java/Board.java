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

    public char getField(int x, int y) {
        if(x>=boardSize || y>=boardSize)
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

    public void removeSheep(int x, int y){
        boardTable[x][y] = ' ';
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
    public static int boardSizeQuestion(Scanner scanner) {
        int boardSize = -1;
        System.out.print("Jak dużą planszę mam stworzyć? (Nie mniejszą niż  " + WolfAndSheep.MINIMAL_BOARD_SIZE + "  oraz parzystą ) : ");
        while (boardSize < WolfAndSheep.MINIMAL_BOARD_SIZE || boardSize%2!=0) {
            try {
                boardSize = scanner.nextInt();
                if (boardSize < WolfAndSheep.MINIMAL_BOARD_SIZE) {
                    System.out.print("Podaj liczbę nie mniejszą od " + WolfAndSheep.MINIMAL_BOARD_SIZE + " : ");
                }
                else if (boardSize%2!=0) {
                    System.out.print("Podaj liczbę podzielną na 2, plansza musi być parzysta ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Podaj liczbę a nie znak!!! : ");
                scanner.next();
            }
        }
        return boardSize;
    }

    public int getBoardSize() {
        return boardSize;
    }
}
