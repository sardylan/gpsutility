package org.thehellnet.utility.gpsutility.sentence;

import org.joda.time.DateTime;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEASentenceParseException;
import org.thehellnet.utility.gpsutility.utility.Parser;

/**
 * Created by sardylan on 06/10/16.
 */
@NMEASentence(identifier = "RMC", prefix = "GP", items = 13)
public class GPRMCSentence extends AbstractNMEASentence {

    private DateTime dateTime;
    private boolean status;
    private double latitude;
    private double longitude;
    private float speed;
    private float angle;
    private float variation;

    public GPRMCSentence() {
        super();
    }

    public GPRMCSentence(String sentence) throws NMEAException {
        super(sentence);
    }

    @Override
    protected void init() {
        dateTime = DateTime.now();
        status = false;
        latitude = 0;
        longitude = 0;
        speed = 0;
        angle = 0;
        variation = 0;
    }

    @Override
    protected String serialize() {
        return null;
    }

    @Override
    protected void parse(String[] sentenceItems) throws NMEASentenceParseException {
        if (sentenceItems[1].length() > 0 && sentenceItems[9].length() > 0)
            dateTime = Parser.dateTime(sentenceItems[9], sentenceItems[1]);
        if (sentenceItems[2].length() > 0)
            status = sentenceItems[2].equals("A");
        if (sentenceItems[3].length() > 0 && sentenceItems[4].length() > 0)
            latitude = Parser.latitude(sentenceItems[3], sentenceItems[4]);
        if (sentenceItems[5].length() > 0 && sentenceItems[6].length() > 0)
            longitude = Parser.longitude(sentenceItems[5], sentenceItems[6]);
        if (sentenceItems[7].length() > 0)
            speed = Float.parseFloat(sentenceItems[7]);
        if (sentenceItems[8].length() > 0)
            angle = Float.parseFloat(sentenceItems[8]);
        if (sentenceItems[9].length() > 0 && sentenceItems[10].length() > 0)
            variation = Parser.variation(sentenceItems[10], sentenceItems[11]);
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getVariation() {
        return variation;
    }

    public void setVariation(float variation) {
        this.variation = variation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GPRMCSentence)) return false;

        GPRMCSentence that = (GPRMCSentence) o;

        if (status != that.status) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (Float.compare(that.speed, speed) != 0) return false;
        if (Float.compare(that.angle, angle) != 0) return false;
        if (Float.compare(that.variation, variation) != 0) return false;
        return dateTime.equals(that.dateTime);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dateTime.hashCode();
        result = 31 * result + (status ? 1 : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (speed != +0.0f ? Float.floatToIntBits(speed) : 0);
        result = 31 * result + (angle != +0.0f ? Float.floatToIntBits(angle) : 0);
        result = 31 * result + (variation != +0.0f ? Float.floatToIntBits(variation) : 0);
        return result;
    }
}
