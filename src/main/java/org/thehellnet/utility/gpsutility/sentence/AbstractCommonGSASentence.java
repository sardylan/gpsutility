package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEASentenceParseException;

import java.util.Arrays;

/**
 * Created by sardylan on 12/10/16.
 */
public abstract class AbstractCommonGSASentence extends AbstractNMEASentence {

    protected boolean automatic;
    protected int fixType;
    protected int[] prns;
    protected float pdop;
    protected float hdop;
    protected float vdop;

    protected AbstractCommonGSASentence() {
        super();
    }

    protected AbstractCommonGSASentence(String sentence) throws NMEAException {
        super(sentence);
    }

    @Override
    protected void init() {
        automatic = false;
        fixType = 0;
        prns = new int[12];
        pdop = 0;
        hdop = 0;
        vdop = 0;
    }

    @Override
    protected String serialize() {
        return null;
    }

    @Override
    protected void parse(String[] sentenceItems) throws NMEASentenceParseException {
        automatic = sentenceItems[1].equals("A");
        fixType = Integer.parseInt(sentenceItems[2]);

        for (int i = 0; i < 12; i++) {
            prns[i] = sentenceItems[3 + i].length() > 0
                    ? Integer.parseInt(sentenceItems[3 + i])
                    : 0;
        }

        pdop = Float.parseFloat(sentenceItems[15]);
        hdop = Float.parseFloat(sentenceItems[16]);
        vdop = Float.parseFloat(sentenceItems[17]);
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public int getFixType() {
        return fixType;
    }

    public void setFixType(int fixType) {
        this.fixType = fixType;
    }

    public int[] getPrns() {
        return prns;
    }

    public void setPrns(int[] prns) {
        this.prns = prns;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCommonGSASentence)) return false;

        AbstractCommonGSASentence that = (AbstractCommonGSASentence) o;

        if (automatic != that.automatic) return false;
        if (fixType != that.fixType) return false;
        if (Float.compare(that.pdop, pdop) != 0) return false;
        if (Float.compare(that.hdop, hdop) != 0) return false;
        if (Float.compare(that.vdop, vdop) != 0) return false;
        return Arrays.equals(prns, that.prns);

    }

    @Override
    public int hashCode() {
        int result = (automatic ? 1 : 0);
        result = 31 * result + fixType;
        result = 31 * result + Arrays.hashCode(prns);
        result = 31 * result + (pdop != +0.0f ? Float.floatToIntBits(pdop) : 0);
        result = 31 * result + (hdop != +0.0f ? Float.floatToIntBits(hdop) : 0);
        result = 31 * result + (vdop != +0.0f ? Float.floatToIntBits(vdop) : 0);
        return result;
    }
}
