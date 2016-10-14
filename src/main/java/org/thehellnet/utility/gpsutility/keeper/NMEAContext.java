package org.thehellnet.utility.gpsutility.keeper;

import org.joda.time.DateTime;
import org.thehellnet.utility.gpsutility.model.Mode;

/**
 * Created by sardylan on 13/10/16.
 */
public class NMEAContext {

    private double latitude;
    private double longitude;
    private float altitude;

    private DateTime dateTime;
    private int satellites;

    private Mode gpsMode;
    private Mode glonassMode;

    private float pdop;
    private float hdop;
    private float vdop;

    private float geoid;

    private int dgpsLastUpdate;
    private int dgpsStationId;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getSatellites() {
        return satellites;
    }

    public void setSatellites(int satellites) {
        this.satellites = satellites;
    }

    public Mode getGpsMode() {
        return gpsMode;
    }

    public void setGpsMode(Mode gpsMode) {
        this.gpsMode = gpsMode;
    }

    public Mode getGlonassMode() {
        return glonassMode;
    }

    public void setGlonassMode(Mode glonassMode) {
        this.glonassMode = glonassMode;
    }

    public float getPdop() {
        return pdop;
    }

    public void setPdop(float pdop) {
        this.pdop = pdop;
    }

    public float getHdop() {
        return hdop;
    }

    public void setHdop(float hdop) {
        this.hdop = hdop;
    }

    public float getVdop() {
        return vdop;
    }

    public void setVdop(float vdop) {
        this.vdop = vdop;
    }

    public float getGeoid() {
        return geoid;
    }

    public void setGeoid(float geoid) {
        this.geoid = geoid;
    }

    public int getDgpsLastUpdate() {
        return dgpsLastUpdate;
    }

    public void setDgpsLastUpdate(int dgpsLastUpdate) {
        this.dgpsLastUpdate = dgpsLastUpdate;
    }

    public int getDgpsStationId() {
        return dgpsStationId;
    }

    public void setDgpsStationId(int dgpsStationId) {
        this.dgpsStationId = dgpsStationId;
    }
}
