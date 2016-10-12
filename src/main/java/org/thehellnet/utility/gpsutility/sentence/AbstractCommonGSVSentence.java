package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEASentenceParseException;
import org.thehellnet.utility.gpsutility.model.Satellite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sardylan on 11/10/16.
 */
public abstract class AbstractCommonGSVSentence extends AbstractNMEASentence {

    protected int sentences;
    protected int sentenceNum;
    protected int satNum;
    protected List<Satellite> satellites;

    protected AbstractCommonGSVSentence() {
        super();
    }

    protected AbstractCommonGSVSentence(String sentence) throws NMEAException {
        super(sentence);
    }

    @Override
    protected void init() {
        sentences = 0;
        sentenceNum = 0;
        satNum = 0;
        satellites = new ArrayList<>();
    }

    @Override
    protected String serialize() {
        return null;
    }

    @Override
    protected void parse(String[] sentenceItems) throws NMEASentenceParseException {
        sentences = Integer.parseInt(sentenceItems[1]);
        sentenceNum = Integer.parseInt(sentenceItems[2]);
        satNum = Integer.parseInt(sentenceItems[3]);

        for (int i = 0; i < 4; i++) {
            if (sentenceItems[4 + i * 4].length() > 0
                    || sentenceItems[5 + i * 4].length() > 0
                    || sentenceItems[6 + i * 4].length() > 0
                    || sentenceItems[7 + i * 4].length() > 0) {
                Satellite satellite = new Satellite();

                if (sentenceItems[4 + i * 4].length() > 0)
                    satellite.setId(Integer.parseInt(sentenceItems[4 + i * 4]));
                if (sentenceItems[5 + i * 4].length() > 0)
                    satellite.setElevation(Integer.parseInt(sentenceItems[5 + i * 4]));
                if (sentenceItems[6 + i * 4].length() > 0)
                    satellite.setAzimuth(Integer.parseInt(sentenceItems[6 + i * 4]));
                if (sentenceItems[7 + i * 4].length() > 0)
                    satellite.setSnr(Integer.parseInt(sentenceItems[7 + i * 4]));

                satellites.add(satellite);
            }
        }
    }

    public int getSentences() {
        return sentences;
    }

    public void setSentences(int sentences) {
        this.sentences = sentences;
    }

    public int getSentenceNum() {
        return sentenceNum;
    }

    public void setSentenceNum(int sentenceNum) {
        this.sentenceNum = sentenceNum;
    }

    public int getSatNum() {
        return satNum;
    }

    public void setSatNum(int satNum) {
        this.satNum = satNum;
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCommonGSVSentence)) return false;

        AbstractCommonGSVSentence sentence = (AbstractCommonGSVSentence) o;

        if (sentences != sentence.sentences) return false;
        if (sentenceNum != sentence.sentenceNum) return false;
        if (satNum != sentence.satNum) return false;
        return satellites.equals(sentence.satellites);

    }

    @Override
    public int hashCode() {
        int result = sentences;
        result = 31 * result + sentenceNum;
        result = 31 * result + satNum;
        result = 31 * result + satellites.hashCode();
        return result;
    }
}
