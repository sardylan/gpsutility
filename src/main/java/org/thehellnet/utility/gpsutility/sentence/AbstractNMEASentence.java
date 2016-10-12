package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEAFormatException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEASentenceParseException;
import org.thehellnet.utility.gpsutility.utility.Utility;

/**
 * Created by sardylan on 05/10/16.
 */
public abstract class AbstractNMEASentence {

    private int items;
    private String identifier;
    private String prefix;

    AbstractNMEASentence() {
        initParams();
        init();
    }

    AbstractNMEASentence(String sentence) throws NMEAException {
        initParams();
        init();
        parseSentence(sentence);
    }

    public int getItems() {
        return items;
    }

    public String getIdentifier() {
        return identifier;
    }

    protected abstract void init();

    protected abstract String serialize();

    protected abstract void parse(String[] sentenceItems) throws NMEASentenceParseException;

    private void initParams() {
        NMEASentence annotation = this.getClass().getAnnotation(NMEASentence.class);
        items = annotation.items();
        identifier = annotation.identifier();
        prefix = annotation.prefix();
    }

    private String serializeSentence() {
        String serializedSentence = serialize();
        return String.format("$%s*%02X",
                serializedSentence,
                Utility.checksum(serializedSentence));
    }

    private void parseSentence(String sentence) throws NMEAException {
        if (!Utility.verifyChecksum(sentence)) {
            throw new NMEAFormatException();
        }

        String sentenceTag = String.format("%s%s", prefix, identifier);
        String[] sentenceItems = Utility.sentenceSplit(sentence);
        if (sentenceItems.length != items || !sentenceItems[0].equals(sentenceTag)) {
            throw new NMEASentenceParseException();
        }

        parse(sentenceItems);
    }

    @Override
    public String toString() {
        return serializeSentence();
    }
}
