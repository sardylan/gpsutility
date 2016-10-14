package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEAFormatException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEASentenceParseException;
import org.thehellnet.utility.gpsutility.utility.Utility;

/**
 * Created by sardylan on 05/10/16.
 */
public abstract class NMEASentence {

    private int items;
    private String identifier;
    private String prefix;

    NMEASentence() {
        initParams();
        init();
    }

    NMEASentence(String sentence) throws NMEAException {
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
        Sentence annotation = this.getClass().getAnnotation(Sentence.class);
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
        if (!sentenceItems[0].equals(sentenceTag) || (items > 0 && sentenceItems.length != items)) {
            throw new NMEASentenceParseException();
        }

        parse(sentenceItems);
    }

    @Override
    public String toString() {
        return serializeSentence();
    }
}
