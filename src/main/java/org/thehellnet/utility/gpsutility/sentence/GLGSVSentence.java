package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;

/**
 * Created by sardylan on 11/10/16.
 */
@Sentence(identifier = "GSV", prefix = "GL", items = 0)
public class GLGSVSentence extends AbstractCommonGSVSentence {

    public GLGSVSentence() {
        super();
    }

    public GLGSVSentence(String sentence) throws NMEAException {
        super(sentence);
    }
}
