package org.thehellnet.utility.gpsutility.utility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by sardylan on 05/10/16.
 */
public class UtilityTest {

    @Test
    public void checksum() throws Exception {
        String input;
        int expected;
        int actual;

        input = "GPRMC,135412.0,A,3913.409979,N,00906.115442,E,0.0,295.7,051016,0.1,W,A";
        expected = 0x16;
        actual = Utility.checksum(input);
        assertEquals(expected, actual);
    }

    @Test
    public void verifyChecksum() throws Exception {
        String input;
        boolean expected;
        boolean actual;

        input = "$GPRMC,135412.0,A,3913.409979,N,00906.115442,E,0.0,295.7,051016,0.1,W,A*16";
        expected = true;
        actual = Utility.verifyChecksum(input);
        assertEquals(expected, actual);

        input = "GPRMC,135412.0,A,3913.409979,N,00906.115442,E,0.0,295.7,051016,0.1,W,A*16";
        expected = false;
        actual = Utility.verifyChecksum(input);
        assertEquals(expected, actual);

        input = "$GPRMC,135412.0,A,3913.409979,N,00906.115442,E,0.0,295.7,051016,0.1,W,A*";
        expected = false;
        actual = Utility.verifyChecksum(input);
        assertEquals(expected, actual);

        input = "$GPRMC,135412.0,A,3913.409979,N,00906.115442,E,0.0,295.7,051016,0.1,W,A";
        expected = false;
        actual = Utility.verifyChecksum(input);
        assertEquals(expected, actual);
    }
}