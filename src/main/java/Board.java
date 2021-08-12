import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {
    public int boardSizeQuestion(Scanner scanner) {
        int boardSize = -1;
        System.out.print("Jak dużą planszę mam stworzyć? (Nie mniejszą niż  " + WolfAndSheep.MINIMAL_BOARD_SIZE + " ) : ");
        while (boardSize < WolfAndSheep.MINIMAL_BOARD_SIZE) {
            try {
                boardSize = scanner.nextInt();
                if (boardSize < WolfAndSheep.MINIMAL_BOARD_SIZE) {
                    System.out.print("Podaj liczbę nie mniejszą od " + WolfAndSheep.MINIMAL_BOARD_SIZE + " : ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Podaj liczbę a nie znak!!! : ");
                scanner.next();
            }
        }
        return boardSize;
    }
}
