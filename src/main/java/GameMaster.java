public class GameMaster {
    private int sheepCount;
    private int wolfCount;
    private Board board;

    public GameMaster(Board board) {
        this.board = board;
        sheepCount = howManySheeps(board.getBoardSize());
        wolfCount = howManyWolfs(sheepCount);
        initializeSheepsOnBoard();
        initializeWolfOnBoard();
    }

    private static int howManySheeps(int boardSize){
        return boardSize/2;
    }
    private static int howManyWolfs(int sheepCount){
        return sheepCount < 4 ? 1 : sheepCount/4;
    }

    private void initializeSheepsOnBoard(){
        for(int i = 0 ; i < board.getBoardSize(); i++){
            if(i%2!=0){
                board.addSheep(i,0);
            }
        }
    }

    public void initializeWolfOnBoard(){
        Communication.askForWolfs(wolfCount,board);
    }

    public void run(){
        char [] players = new char[]{'w','o'};
        int iter = 0;
        while(true){
            board.viewBoard();
            askForMove(players[iter%2]);
            char winer = gameOver();
            if(winer == 'o'){
                System.out.println("Wygrał gracz który grał owcami, gratulacje !!!");
                return;
            }
            if(winer == 'w'){
                System.out.println("Wygrł gracz który grał wilkiem, gratulacje !!!");
                return;
            }
            iter++;
        }
    }

    private char gameOver() {
        return ' ';
    }

    public void askForMove(char player){
        int[] firstLocation;
        int[] secondLocation;
        while(true){
            while(true) {
                System.out.println("Gracz " + player + ": Podaj lokalację swojego pionka do ruchu : ");
                firstLocation = Communication.askForMoveLocation(player, board);
                if (board.getField(firstLocation) != player) {
                    System.out.println("Twój pionek tam nie stoi!!");
                    continue;
                }
                break;
            }

            while(true) {
                System.out.println("Gracz " + player + ": Podaj lokalację gdzie sie ma ruszyc (wpisz A1 aby wrocic do wyboru pionka) : ");
                secondLocation = Communication.askForMoveLocation(player,board);
                if(secondLocation[0]==0 && secondLocation[1]==0){
                    break;
                }
                if (!isMoveAvailable(firstLocation,secondLocation)) {
                    System.out.println("Nie można się tam ruszyć, wybierz inną lokację!!!");
                    continue;
                }
                board.move(firstLocation,secondLocation);
                return;
            }
        }

    }

    private boolean isMoveAvailable(int[] firstLocation, int[] secondLocation) {
        if(board.getField(firstLocation)=='o' && secondLocation[1]<firstLocation[1]){
            return false;
        }
        if(board.getField(secondLocation)!=' '){
            return false;
        }
        if(Math.abs(firstLocation[0]-secondLocation[0]) * Math.abs(firstLocation[1]-secondLocation[1])!=1){
            return false;
        }
        return true;
    }



    public void setSheepCount(int sheepCount) {
        this.sheepCount = sheepCount;
    }
    public void setWolfCount(int wolfCount) {
        this.wolfCount = wolfCount;
    }
    public int getSheepCount() {
        return sheepCount;
    }
    public int getWolfCount() {
        return wolfCount;
    }
}
