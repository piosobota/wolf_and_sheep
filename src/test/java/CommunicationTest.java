import junit.framework.TestCase;
import org.junit.Assert;

public class CommunicationTest extends TestCase {

    public void testConvertLegendIntoNumbersLocationWhenGivenA1() {
        Assert.assertArrayEquals(new int[]{0,0}, Communication.convertLegendIntoNumbersLocation("A1"));
    }
    public void testConvertLegendIntoNumbersLocationWhenGivenC30() {
        Assert.assertArrayEquals(new int[]{2,29}, Communication.convertLegendIntoNumbersLocation("C30"));
    }

}