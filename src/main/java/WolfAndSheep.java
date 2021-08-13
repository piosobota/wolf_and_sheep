import java.util.InputMismatchException;
import java.util.Scanner;

public class WolfAndSheep {
    public static final int  MINIMAL_BOARD_SIZE=4;
    public static void main(String[] args) {
        int boardSize = -1;
        Board board;
        GameMaster gameMaster = new GameMaster();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj w Grze Wilk i Owca !!!!");
        System.out.println("by Emil Burdach and Piotr Sobota");
        System.out.println();
        board = new Board(Communication.boardSizeQuestion(scanner));
        gameMaster.setSheepCount(gameMaster.howManySheeps(board.getBoardSize()));
        gameMaster.setWolfCount(gameMaster.howManyWolfs());
        System.out.println(gameMaster.getSheepCount());
        System.out.println(gameMaster.getWolfCount());

        }

    }
