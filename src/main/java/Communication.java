import java.util.InputMismatchException;
import java.util.Scanner;

public class Communication {

    public static Scanner scanner = new Scanner(System.in);

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

    public static int[] convertLegendIntoNumbersLocation(String location){
        int x = convertSymbolToNumber(location.charAt(0) + "");
        int y = Integer.parseInt(location.substring(1,location.length())) -1;

        return new int[]{x,y};
    }

    private static int convertSymbolToNumber(String number){
        return Character.toUpperCase(number.charAt(0)) - 'A';
    }

    public static void askForWolfs(int wolfsCount, Board board) {
        int i = 0;
        while(i<wolfsCount){
            board.viewBoard();
            int pos;

            System.out.print("Gdzie chcesz wilka nr. " + (i+1) + "? Podaj indeks ostatniego wiersza : ");
            try {
                char c = scanner.next().charAt(0);
                if(!Character.isAlphabetic(c)){
                    System.out.println("Musisz podać prawidłowy index A B C itp");
                    continue;
                }
                pos = convertSymbolToNumber(c + "");
            }
            catch(InputMismatchException e){
                System.out.print("Musisz podać liczbę!");
                continue;
            }

            if(pos%2 != 0){
                System.out.println("Podana liczba musi być nieparzysta!");
                continue;
            }
            if(pos<0){
                System.out.println("Podana liczba musi być większa od 0!!!");
                continue;
            }
            if(pos >= board.getBoardSize()){
                System.out.println("Podana liczba musi byc w zakresie szachownicy !!!");
                continue;
            }
            if(board.getField(pos, board.getBoardSize()-1) == 'w'){
                System.out.println("Ej, juz podawałeś tą pozycję dla wilka !!!");
                continue;
            }

            board.addWolf(pos, board.getBoardSize()-1);
            i++;
        }
    }

    public static int[] askForMoveLocation(char player, Board board) {
        int [] pos;

        while(true){
            String move = scanner.next();
            try {
                pos = convertLegendIntoNumbersLocation(move);
            }
            catch(Exception e){
                System.out.println("Podaj poprawny kod!");
                continue;
            }

            if(board.getField(pos[0], pos[1]) == 0){
                System.out.println("Podaj pole mieszczące się w szachownicy!!!");
                continue;
            }

            break;
        }

        return pos;
    }
}
