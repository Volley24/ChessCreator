package tests;

import chesscreator.chess.coordinates.CoordinateConverter;
import chesscreator.chess.coordinates.Position;
import org.junit.Assert;
import org.junit.Test;

public class CoordinateConverterTest {
    /*
(0) 8 |r|n|b|q|k|b|n|r|
(1) 7 |p|p|p|p|p|p|p|p|
(2) 6 | | | | | | | | |
(3) 5 | | | | | | | | |
(4) 4 | | | | | | | | |
(5) 3 | | | | | | | | |
(6) 2 |P|P|P|P|P|P|P|P|
(7) 1 |R|N|B|Q|K|B|N|R|
       A B C D E F G H
      (0,1,2,3,4,5,6,7)
 */

    @Test
    public void rawToDisplayTest(){
        Assert.assertEquals("E4", CoordinateConverter.toDisplay(4, 4));

        Assert.assertEquals("C6", CoordinateConverter.toDisplay(2, 2));

        Assert.assertEquals("B8", CoordinateConverter.toDisplay(1, 0));

        Assert.assertEquals("A3", CoordinateConverter.toDisplay(0, 5));
    }

    @Test
    public void displayToRawTest(){
        Assert.assertTrue(CoordinateConverter.toRaw("C6").equals(new Position(2,2)));

        Assert.assertTrue(CoordinateConverter.toRaw("a1").equals(new Position(0, 7)));

        Assert.assertTrue(CoordinateConverter.toRaw("H8").equals(new Position(7, 0)));

        Assert.assertTrue(CoordinateConverter.toRaw("D3").equals(new Position(3, 5)));
    }
}
