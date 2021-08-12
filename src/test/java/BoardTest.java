import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    Board board;

    @Before
    public void init(){
        board = new Board(8);
    }

    @Test
    public void addWolfTest(){
        board.addWolf(3,3);
        Assert.assertEquals('w', board.getField(3,3));
    }

    @Test
    public void addSheepTest(){
        board.addSheep(4,4);
        Assert.assertEquals('o', board.getField(4,4));
    }

    @Test
    public void removeSheepTest() {
        board.addSheep(1, 1);
        board.removeSheep(1, 1);
        Assert.assertEquals(' ', board.getField(1, 1));
    }

    @Test
    public void visual(){
        board.addSheep(5,5);
        board.viewBoard();
    }

}
