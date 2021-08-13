public class GameMaster {
    private int sheepCount;
    private int wolfCount;
    Board board;

    public GameMaster(Board board) {
        sheepCount = howManySheeps(board.getBoardSize());
        wolfCount = howManyWolfs(sheepCount);
    }

    private static int howManySheeps(int boardSize){
        return boardSize/2;
    }
    private static int howManyWolfs(int sheepCount){
        return sheepCount < 4 ? 1 : sheepCount/4;
    }

    public void InitializeSheepsOnBoard(Board board){
        for(int i = 0 ; i < board.getBoardSize(); i++){
            if(i%2!=0){
                board.addSheep(i,0);
            }
        }
    }

    public void InitializeWolfOnBoard(Board board){
        Communication.askForWolfs(wolfCount,board);
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
