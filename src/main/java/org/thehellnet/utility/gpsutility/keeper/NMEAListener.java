package org.thehellnet.utility.gpsutility.keeper;

import org.thehellnet.utility.gpsutility.sentence.NMEASentence;

/**
 * Created by sardylan on 13/10/16.
 */
public interface NMEAListener {

    void newSentence(NMEASentence sentence);
}
