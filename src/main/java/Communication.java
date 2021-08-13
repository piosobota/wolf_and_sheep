import java.util.InputMismatchException;
import java.util.Scanner;

public class Communication {
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
}
