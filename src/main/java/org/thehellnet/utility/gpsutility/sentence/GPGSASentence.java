package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;

/**
 * Created by sardylan on 06/10/16.
 */
@NMEASentence(identifier = "GSA", prefix = "GP", items = 18)
public class GPGSASentence extends AbstractCommonGSASentence {

    public GPGSASentence() {
        super();
    }

    public GPGSASentence(String sentence) throws NMEAException {
        super(sentence);
    }
}
