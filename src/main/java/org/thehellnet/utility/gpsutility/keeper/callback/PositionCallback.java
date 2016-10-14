package org.thehellnet.utility.gpsutility.keeper.callback;

/**
 * Created by sardylan on 13/10/16.
 */
public interface PositionCallback {

    void newPosition(double latitude, double longitude, float altitude);
}
