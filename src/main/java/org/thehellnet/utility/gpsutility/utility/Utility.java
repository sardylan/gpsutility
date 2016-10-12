package org.thehellnet.utility.gpsutility.utility;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Created by sardylan on 05/10/16.
 */
public final class Utility {

    public static int checksum(String sentence) {
        if (sentence == null)
            return 0;

        int checksum = 0;
        for (char c : sentence.toCharArray()) checksum ^= c;
        return checksum;
    }

    public static boolean verifyChecksum(String sentence) {
        if (!sentence.startsWith("$")) return false;
        if (!sentence.contains("*")) return false;
        if (sentence.indexOf("*") != sentence.length() - 3) return false;
        int actualChecksum = checksum(sentenceTrim(sentence));
        int expectedChecksum = Integer.parseInt(sentence.substring(sentence.indexOf("*") + 1), 16);
        return actualChecksum == expectedChecksum;
    }

    public static DateTime dateTimeFromTimeString(DateTime oldDateTime, String newTime) {
        return new DateTime(oldDateTime.getYear(),
                oldDateTime.getMonthOfYear(),
                oldDateTime.getDayOfMonth(),
                Integer.parseInt(newTime.substring(0, 2)),
                Integer.parseInt(newTime.substring(2, 4)),
                Integer.parseInt(newTime.substring(4, 6)),
                DateTimeZone.UTC);
    }

    public static String sentenceTrim(String sentence) {
        return sentence.substring(1, sentence.indexOf("*"));
    }

    public static String[] sentenceSplit(String sentence) {
        return sentenceTrim(sentence).split(",", -1);
    }
}
