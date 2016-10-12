package org.thehellnet.utility.gpsutility.utility;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sardylan on 06/10/16.
 */
public class ParserTest {

    @Test
    public void dateTime() throws Exception {
        String inputDate;
        String inputTime;
        DateTime expected;
        DateTime actual;

        inputDate = "311292";
        inputTime = "123456.0";
        expected = new DateTime(1992, 12, 31, 12, 34, 56);
        actual = Parser.dateTime(inputDate, inputTime);
        assertEquals(expected, actual);

        inputDate = "311292";
        inputTime = "123456.123";
        expected = new DateTime(1992, 12, 31, 12, 34, 56, 123);
        actual = Parser.dateTime(inputDate, inputTime);
        assertEquals(expected, actual);

        inputDate = "311292";
        inputTime = "123456";
        expected = new DateTime(1992, 12, 31, 12, 34, 56);
        actual = Parser.dateTime(inputDate, inputTime);
        assertEquals(expected, actual);

        inputDate = "311292";
        inputTime = "123456";
        expected = new DateTime(1992, 12, 31, 12, 34, 56);
        actual = Parser.dateTime(inputDate, inputTime);
        assertEquals(expected, actual);

        inputDate = "010199";
        inputTime = "123456";
        expected = new DateTime(1999, 1, 1, 12, 34, 56);
        actual = Parser.dateTime(inputDate, inputTime);
        assertEquals(expected, actual);

        inputDate = "010100";
        inputTime = "123456";
        expected = new DateTime(2000, 1, 1, 12, 34, 56);
        actual = Parser.dateTime(inputDate, inputTime);
        assertEquals(expected, actual);

        inputDate = "010101";
        inputTime = "123456";
        expected = new DateTime(2001, 1, 1, 12, 34, 56);
        actual = Parser.dateTime(inputDate, inputTime);
        assertEquals(expected, actual);

        inputDate = "311212";
        inputTime = "123456";
        expected = new DateTime(2012, 12, 31, 12, 34, 56);
        actual = Parser.dateTime(inputDate, inputTime);
        assertEquals(expected, actual);

        inputDate = "311230";
        inputTime = "123456";
        expected = new DateTime(2030, 12, 31, 12, 34, 56);
        actual = Parser.dateTime(inputDate, inputTime);
        assertEquals(expected, actual);
    }
}