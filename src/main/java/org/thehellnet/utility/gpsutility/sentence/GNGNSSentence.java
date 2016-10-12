package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;

/**
 * Created by sardylan on 11/10/16.
 */
@NMEASentence(identifier = "GNS", prefix = "GN", items = 13)
public class GNGNSSentence extends AbstractCommonGNSSentence {

    public GNGNSSentence() {
        super();
    }

    public GNGNSSentence(String sentence) throws NMEAException {
        super(sentence);
    }
}
