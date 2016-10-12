package org.thehellnet.utility.gpsutility.sentence;

import org.joda.time.LocalTime;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEASentenceParseException;
import org.thehellnet.utility.gpsutility.model.Mode;
import org.thehellnet.utility.gpsutility.utility.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sardylan on 11/10/16.
 */
public abstract class AbstractCommonGNSSentence extends AbstractNMEASentence {

    protected LocalTime time;
    protected double latitude;
    protected double longitude;
    protected List<Mode> modes;
    protected int satellites;
    protected float hdop;
    protected float altitude;
    protected float geoid;
    protected int dgpsLastUpdate;
    protected int dgpsStationId;

    protected AbstractCommonGNSSentence() {
        super();
    }

    protected AbstractCommonGNSSentence(String sentence) throws NMEAException {
        super(sentence);
    }

    @Override
    protected void init() {
        time = LocalTime.now();
        latitude = 0;
        longitude = 0;
        modes = new ArrayList<>();
        satellites = 0;
        hdop = 0;
        altitude = 0;
        geoid = 0;
        dgpsLastUpdate = 0;
        dgpsStationId = 0;
    }

    @Override
    protected String serialize() {
        return null;
    }

    @Override
    protected void parse(String[] sentenceItems) throws NMEASentenceParseException {
        if (sentenceItems[1].length() > 0)
            time = Parser.time(sentenceItems[1]);
        if (sentenceItems[2].length() > 0 && sentenceItems[3].length() > 0)
            latitude = Parser.latitude(sentenceItems[2], sentenceItems[3]);
        if (sentenceItems[4].length() > 0 && sentenceItems[5].length() > 0)
            longitude = Parser.longitude(sentenceItems[4], sentenceItems[5]);

        if (sentenceItems[6].length() > 0)
            for (char c : sentenceItems[6].toCharArray()) {
                modes.add(Mode.fromString(c));
            }

        if (sentenceItems[7].length() > 0)
            satellites = Integer.parseInt(sentenceItems[7]);
        if (sentenceItems[8].length() > 0)
            hdop = Float.parseFloat(sentenceItems[8]);
        if (sentenceItems[9].length() > 0)
            altitude = Float.parseFloat(sentenceItems[9]);
        if (sentenceItems[10].length() > 0)
            geoid = Float.parseFloat(sentenceItems[10]);
        if (sentenceItems[11].length() > 0)
            dgpsLastUpdate = Parser.integer(sentenceItems[11]);
        if (sentenceItems[12].length() > 0)
            dgpsStationId = Parser.integer(sentenceItems[12]);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

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

    public List<Mode> getModes() {
        return modes;
    }

    public void setModes(List<Mode> modes) {
        this.modes = modes;
    }

    public int getSatellites() {
        return satellites;
    }

    public void setSatellites(int satellites) {
        this.satellites = satellites;
    }

    public float getHdop() {
        return hdop;
    }

    public void setHdop(float hdop) {
        this.hdop = hdop;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCommonGNSSentence)) return false;

        AbstractCommonGNSSentence that = (AbstractCommonGNSSentence) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (satellites != that.satellites) return false;
        if (Float.compare(that.hdop, hdop) != 0) return false;
        if (Float.compare(that.altitude, altitude) != 0) return false;
        if (Float.compare(that.geoid, geoid) != 0) return false;
        if (dgpsLastUpdate != that.dgpsLastUpdate) return false;
        if (dgpsStationId != that.dgpsStationId) return false;
        if (!time.equals(that.time)) return false;
        return modes.equals(that.modes);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = time.hashCode();
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + modes.hashCode();
        result = 31 * result + satellites;
        result = 31 * result + (hdop != +0.0f ? Float.floatToIntBits(hdop) : 0);
        result = 31 * result + (altitude != +0.0f ? Float.floatToIntBits(altitude) : 0);
        result = 31 * result + (geoid != +0.0f ? Float.floatToIntBits(geoid) : 0);
        result = 31 * result + dgpsLastUpdate;
        result = 31 * result + dgpsStationId;
        return result;
    }
}
