package org.thehellnet.utility.gpsutility.keeper;

import org.joda.time.DateTime;
import org.thehellnet.utility.gpsutility.keeper.callback.DateTimeCallback;
import org.thehellnet.utility.gpsutility.keeper.callback.PositionCallback;

/**
 * Created by sardylan on 14/10/16.
 */
class CallbackCaller {

    private static final int INTERVAL_POSITION = 2;
    private static final int INTERVAL_DATETIME = 1;

    private PositionCallback positionCallback;
    private DateTime positionDateTime;

    private DateTimeCallback dateTimeCallback;
    private DateTime dateTimeDateTime;

    void setPositionCallback(PositionCallback positionCallback) {
        this.positionCallback = positionCallback;
    }

    public void setDateTimeCallback(DateTimeCallback dateTimeCallback) {
        this.dateTimeCallback = dateTimeCallback;
    }

    void callPosition(double latitude, double longitude, float altitude) {
        if (positionCallback == null
                || !checkTimeout(positionDateTime, INTERVAL_POSITION)) {
            return;
        }

        positionDateTime = new DateTime();
        positionCallback.newPosition(latitude, longitude, altitude);
    }

    void callDateTime(DateTime dateTime) {
        if (dateTimeCallback == null
                || !checkTimeout(dateTimeDateTime, INTERVAL_POSITION)) {
            return;
        }

        dateTimeDateTime = new DateTime();
        dateTimeCallback.newDateTime(dateTime);

    }

    private boolean checkTimeout(DateTime dateTime, int interval) {
        return dateTime == null || dateTime.plusSeconds(interval).isBeforeNow();
    }
}
