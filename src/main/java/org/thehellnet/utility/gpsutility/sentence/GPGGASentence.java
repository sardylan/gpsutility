package org.thehellnet.utility.gpsutility.sentence;

import org.joda.time.LocalTime;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEASentenceParseException;
import org.thehellnet.utility.gpsutility.model.Mode;
import org.thehellnet.utility.gpsutility.utility.Parser;

/**
 * Created by sardylan on 05/10/16.
 */
@NMEASentence(identifier = "GGA", prefix = "GP", items = 15)
public class GPGGASentence extends AbstractNMEASentence {

    private LocalTime time;
    private double latitude;
    private double longitude;
    private Mode mode;
    private int satellites;
    private float hdop;
    private float altitude;
    private float geoid;
    private int dgpsLastUpdate;
    private int dgpsStationId;

    public GPGGASentence() {
        super();
    }

    public GPGGASentence(String sentence) throws NMEAException {
        super(sentence);
    }

    @Override
    protected void init() {
        time = LocalTime.now();
        latitude = 0;
        longitude = 0;
        mode = Mode.INVALID;
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

        if (sentenceItems[3].length() > 0 && sentenceItems[3].length() > 0)
            latitude = Parser.latitude(sentenceItems[2], sentenceItems[3]);

        if (sentenceItems[4].length() > 0 && sentenceItems[5].length() > 0)
            longitude = Parser.longitude(sentenceItems[4], sentenceItems[5]);

        if (sentenceItems[6].length() > 0)
            mode = Mode.fromNumber(sentenceItems[6]);

        if (sentenceItems[7].length() > 0)
            satellites = Integer.parseInt(sentenceItems[7]);

        if (sentenceItems[8].length() > 0)
            hdop = Float.parseFloat(sentenceItems[8]);

        if (sentenceItems[9].length() > 0)
            altitude = Float.parseFloat(sentenceItems[9]);

        if (sentenceItems[11].length() > 0)
            geoid = Float.parseFloat(sentenceItems[11]);

        if (sentenceItems[13].length() > 0)
            dgpsLastUpdate = Parser.integer(sentenceItems[13]);

        if (sentenceItems[14].length() > 0)
            dgpsStationId = Parser.integer(sentenceItems[14]);
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

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
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
        if (!(o instanceof GPGGASentence)) return false;

        GPGGASentence sentence = (GPGGASentence) o;

        if (Double.compare(sentence.latitude, latitude) != 0) return false;
        if (Double.compare(sentence.longitude, longitude) != 0) return false;
        if (satellites != sentence.satellites) return false;
        if (Float.compare(sentence.hdop, hdop) != 0) return false;
        if (Float.compare(sentence.altitude, altitude) != 0) return false;
        if (Float.compare(sentence.geoid, geoid) != 0) return false;
        if (dgpsLastUpdate != sentence.dgpsLastUpdate) return false;
        if (dgpsStationId != sentence.dgpsStationId) return false;
        if (!time.equals(sentence.time)) return false;
        return mode == sentence.mode;

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
        result = 31 * result + mode.hashCode();
        result = 31 * result + satellites;
        result = 31 * result + (hdop != +0.0f ? Float.floatToIntBits(hdop) : 0);
        result = 31 * result + (altitude != +0.0f ? Float.floatToIntBits(altitude) : 0);
        result = 31 * result + (geoid != +0.0f ? Float.floatToIntBits(geoid) : 0);
        result = 31 * result + dgpsLastUpdate;
        result = 31 * result + dgpsStationId;
        return result;
    }
}
