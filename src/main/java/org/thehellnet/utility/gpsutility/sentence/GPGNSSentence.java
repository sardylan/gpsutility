package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;

/**
 * Created by sardylan on 11/10/16.
 */
@Sentence(identifier = "GNS", prefix = "GP", items = 13)
public class GPGNSSentence extends AbstractCommonGNSSentence {

    public GPGNSSentence() {
        super();
    }

    public GPGNSSentence(String sentence) throws NMEAException {
        super(sentence);
    }
}
