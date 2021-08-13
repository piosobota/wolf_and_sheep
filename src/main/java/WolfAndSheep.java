
public class WolfAndSheep {
    public static final int  MINIMAL_BOARD_SIZE=4;

    public static void main(String[] args) {
        int boardSize = -1;
        Board board;
        GameMaster gameMaster;
        System.out.println("Witaj w Grze Wilk i Owca !!!!");
        System.out.println("by Emil Burdach and Piotr Sobota");
        System.out.println();
        board = new Board(Communication.boardSizeQuestion(Communication.scanner));
        gameMaster = new GameMaster(board);
    }

}
