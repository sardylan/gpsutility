package org.thehellnet.utility.gpsutility.utility;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by sardylan on 06/10/16.
 */
public final class Parser {

    public static int integer(String value) {
        if (value == null || value.length() == 0) return 0;
        return Integer.parseInt(value);
    }

    public static LocalTime time(String time) {
        return new LocalTime(Integer.parseInt(time.substring(0, 2)),
                Integer.parseInt(time.substring(2, 4)),
                Integer.parseInt(time.substring(4, 6)));
    }

    public static double latitude(String latitude, String northSouth) {
        double value = Double.parseDouble(latitude.substring(0, 2))
                + (Double.parseDouble(latitude.substring(2)) / 60f);
        if (northSouth.toUpperCase().equals("S")) value *= -1;
        return value;
    }

    public static double longitude(String latitude, String eastWest) {
        double value = Double.parseDouble(latitude.substring(0, 3))
                + (Double.parseDouble(latitude.substring(3)) / 60f);
        if (eastWest.toUpperCase().equals("W")) value *= -1;
        return value;
    }

    public static DateTime dateTime(String date, String time) {
        switch (time.length()) {
            case 6:
                return DateTimeFormat
                        .forPattern("ddMMyy HHmmss")
                        .parseDateTime(String.format("%s %s", date, time));
            default:
                return DateTimeFormat
                        .forPattern("ddMMyy HHmmss.SSS")
                        .parseDateTime(String.format("%s %s", date, time));
        }
    }

    public static float variation(String variation, String eastWest) {
        float value = Float.parseFloat(variation);
        if (eastWest.toUpperCase().equals("W")) value *= -1;
        return value;
    }
}
