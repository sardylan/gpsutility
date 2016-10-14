package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;

/**
 * Created by sardylan on 06/10/16.
 */
@Sentence(identifier = "GSV", prefix = "GP", items = 0)
public class GPGSVSentence extends AbstractCommonGSVSentence {

    public GPGSVSentence() {
        super();
    }

    public GPGSVSentence(String sentence) throws NMEAException {
        super(sentence);
    }
}
