package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;

/**
 * Created by sardylan on 11/10/16.
 */
@NMEASentence(identifier = "GNS", prefix = "GL", items = 13)
public class GLGNSSentence extends AbstractCommonGNSSentence {

    public GLGNSSentence() {
        super();
    }

    public GLGNSSentence(String sentence) throws NMEAException {
        super(sentence);
    }
}
