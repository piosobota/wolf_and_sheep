public class GameMaster {
    private int sheepCount;
    private int wolfCount;
    public int howManySheeps(int boardSize){
        return boardSize/2;
    }
    public int howManyWolfs(){
        return sheepCount < 4 ? 1 : sheepCount/4;
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
