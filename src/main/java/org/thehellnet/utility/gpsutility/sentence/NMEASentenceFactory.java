package org.thehellnet.utility.gpsutility.sentence;

import org.thehellnet.utility.gpsutility.exception.nmea.NMEAException;
import org.thehellnet.utility.gpsutility.exception.nmea.NMEASentenceParseException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sardylan on 06/10/16.
 */
public final class NMEASentenceFactory {

    private static final Set<Class<?>> classes = new HashSet<>();

    static {
        classes.add(GLGNSSentence.class);
        classes.add(GLGSVSentence.class);
        classes.add(GNGNSSentence.class);
        classes.add(GNGSASentence.class);
        classes.add(GPGGASentence.class);
        classes.add(GPGNSSentence.class);
        classes.add(GPGSASentence.class);
        classes.add(GPGSVSentence.class);
        classes.add(GPRMCSentence.class);
        classes.add(GPVTGSentence.class);
    }

    public static NMEASentence parseSentence(String sentence) throws NMEAException {
        String sentencePrefix = sentence.substring(1, 3);
        String sentenceIdentifier = sentence.substring(3, 6);
        String sentenceTag = String.format("%s%s", sentencePrefix, sentenceIdentifier);

        for (Class<?> clazz : getClasses()) {
            Sentence annotation = clazz.getAnnotation(Sentence.class);
            String tag = String.format("%s%s", annotation.prefix(), annotation.identifier());
            if (tag.equals(sentenceTag)) {
                Constructor<?> constructor;
                try {
                    constructor = clazz.getConstructor(String.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    break;
                }

                NMEASentence nmeaSentence;
                try {
                    nmeaSentence = (NMEASentence) constructor.newInstance(sentence);
                } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                    break;
                }

                return nmeaSentence;
            }
        }

        throw new NMEASentenceParseException();
    }

    private static Set<Class<?>> getClasses() {
        return classes;
    }
}
