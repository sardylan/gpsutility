package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;

/**
 * Created by sardylan on 12/10/16.
 */
@NMEASentence(identifier = "GSA", prefix = "GN", items = 18)
public class GNGSASentence extends AbstractCommonGSASentence {

    public GNGSASentence() {
        super();
    }

    public GNGSASentence(String sentence) throws NMEAException {
        super(sentence);
    }
}
