package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEASentenceParseException;

/**
 * Created by sardylan on 06/10/16.
 */
@NMEASentence(identifier = "VTG", prefix = "GP", items = 10)
public class GPVTGSentence extends AbstractNMEASentence {

    private float trueTrack;
    private float magneticTrack;
    private float groundSpeedKnots;
    private float groundSpeedKph;

    public GPVTGSentence() {
        super();
    }

    public GPVTGSentence(String sentence) throws NMEAException {
        super(sentence);
    }

    @Override
    protected void init() {
        trueTrack = 0;
        magneticTrack = 0;
        groundSpeedKnots = 0;
        groundSpeedKph = 0;
    }

    @Override
    protected String serialize() {
        return null;
    }

    @Override
    protected void parse(String[] sentenceItems) throws NMEASentenceParseException {
        if (sentenceItems[1].length() > 0)
            trueTrack = Float.parseFloat(sentenceItems[1]);
        if (sentenceItems[3].length() > 0)
            magneticTrack = Float.parseFloat(sentenceItems[3]);
        if (sentenceItems[5].length() > 0)
            groundSpeedKnots = Float.parseFloat(sentenceItems[5]);
        if (sentenceItems[7].length() > 0)
            groundSpeedKph = Float.parseFloat(sentenceItems[7]);
    }

    public float getTrueTrack() {
        return trueTrack;
    }

    public void setTrueTrack(float trueTrack) {
        this.trueTrack = trueTrack;
    }

    public float getMagneticTrack() {
        return magneticTrack;
    }

    public void setMagneticTrack(float magneticTrack) {
        this.magneticTrack = magneticTrack;
    }

    public float getGroundSpeedKnots() {
        return groundSpeedKnots;
    }

    public void setGroundSpeedKnots(float groundSpeedKnots) {
        this.groundSpeedKnots = groundSpeedKnots;
    }

    public float getGroundSpeedKph() {
        return groundSpeedKph;
    }

    public void setGroundSpeedKph(float groundSpeedKph) {
        this.groundSpeedKph = groundSpeedKph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GPVTGSentence)) return false;

        GPVTGSentence that = (GPVTGSentence) o;

        if (Float.compare(that.trueTrack, trueTrack) != 0) return false;
        if (Float.compare(that.magneticTrack, magneticTrack) != 0) return false;
        if (Float.compare(that.groundSpeedKnots, groundSpeedKnots) != 0) return false;
        return Float.compare(that.groundSpeedKph, groundSpeedKph) == 0;

    }

    @Override
    public int hashCode() {
        int result = (trueTrack != +0.0f ? Float.floatToIntBits(trueTrack) : 0);
        result = 31 * result + (magneticTrack != +0.0f ? Float.floatToIntBits(magneticTrack) : 0);
        result = 31 * result + (groundSpeedKnots != +0.0f ? Float.floatToIntBits(groundSpeedKnots) : 0);
        result = 31 * result + (groundSpeedKph != +0.0f ? Float.floatToIntBits(groundSpeedKph) : 0);
        return result;
    }
}
