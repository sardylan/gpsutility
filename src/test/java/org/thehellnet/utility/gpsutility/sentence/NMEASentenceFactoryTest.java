package org.thehellnet.utility.gpsutility.sentence;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Test;
import org.thehellnet.utility.gpsutility.model.Mode;
import org.thehellnet.utility.gpsutility.model.Satellite;
import org.thehellnet.utility.gpsutility.model.Type;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sardylan on 06/10/16.
 */
public class NMEASentenceFactoryTest {

    private String input;
    private AbstractNMEASentence expected;
    private AbstractNMEASentence actual;

    @Test
    public void parseSentenceGPGGA01() throws Exception {
        GPGGASentence sentence = new GPGGASentence();
        sentence.setTime(new LocalTime(14, 6, 13, 83));

        input = "$GPGGA,140613.083,,,,,0,0,,,M,,M,,*42";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGPGGA02() throws Exception {
        GPGGASentence sentence = new GPGGASentence();
        sentence.setTime(new LocalTime(13, 54, 12));
        sentence.setLatitude(39.22349965);
        sentence.setLongitude(9.101924033333333);
        sentence.setMode(Mode.AUTONOMOUS);
        sentence.setSatellites(3);
        sentence.setHdop(2.1f);
        sentence.setAltitude(-9.9f);
        sentence.setGeoid(47);
        sentence.setDgpsLastUpdate(0);
        sentence.setDgpsStationId(0);

        input = "$GPGGA,135412.0,3913.409979,N,00906.115442,E,1,03,2.1,-9.9,M,47.0,M,,*78";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGPRMC01() throws Exception {
        GPRMCSentence sentence = new GPRMCSentence();
        sentence.setDateTime(new DateTime(2016, 10, 12, 14, 6, 13, 83));

        input = "$GPRMC,140613.083,V,,,,,0.00,0.00,121016,,,N*42";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGPRMC02() throws Exception {
        GPRMCSentence sentence = new GPRMCSentence();
        sentence.setDateTime(new DateTime(2016, 10, 5, 13, 54, 12));
        sentence.setStatus(true);
        sentence.setLatitude(39.22349965);
        sentence.setLongitude(9.1019240333333333);
        sentence.setSpeed(0);
        sentence.setAngle(295.7f);
        sentence.setVariation(-0.1f);

        input = "$GPRMC,135412.0,A,3913.409979,N,00906.115442,E,0.0,295.7,051016,0.1,W,A*16";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGPVTG01() throws Exception {
        GPVTGSentence sentence = new GPVTGSentence();

        input = "$GPVTG,0.00,T,,M,0.00,N,0.00,K,N*32";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGPVTG02() throws Exception {
        GPVTGSentence sentence = new GPVTGSentence();
        sentence.setTrueTrack(295.7f);
        sentence.setMagneticTrack(295.8f);
        sentence.setGroundSpeedKnots(0);
        sentence.setGroundSpeedKph(0);

        input = "$GPVTG,295.7,T,295.8,M,0.0,N,0.0,K,A*2C";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGPGSA01() throws Exception {
        GPGSASentence sentence = new GPGSASentence();
        sentence.setAutomatic(true);

        input = "$GPGSA,A,1,,,,,,,,,,,,,,,*1E";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGPGSA02() throws Exception {
        GPGSASentence sentence = new GPGSASentence();
        sentence.setAutomatic(true);
        sentence.setFixType(Type.FIX_2D);
        sentence.setPrns(new int[]{17, 22, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        sentence.setPdop(2.3f);
        sentence.setHdop(2.1f);
        sentence.setVdop(1.0f);

        input = "$GPGSA,A,2,17,22,28,,,,,,,,,,2.3,2.1,1.0*3C";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGPGSV01() throws Exception {
        GPGSVSentence sentence = new GPGSVSentence();
        sentence.setSentences(1);
        sentence.setSentenceNum(1);
        sentence.setSatNum(1);
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(new Satellite(6, 0, 0, 19));
        sentence.setSatellites(satellites);

        input = "$GPGSV,1,1,01,06,,,19*76";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGPGSV02() throws Exception {
        GPGSVSentence sentence = new GPGSVSentence();
        sentence.setSentences(3);
        sentence.setSentenceNum(1);
        sentence.setSatNum(12);
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(new Satellite(17, 16, 319, 29));
        satellites.add(new Satellite(22, 74, 309, 16));
        satellites.add(new Satellite(28, 12, 275, 29));
        satellites.add(new Satellite(1, 74, 5, 0));
        sentence.setSatellites(satellites);

        input = "$GPGSV,3,1,12,17,16,319,29,22,74,309,16,28,12,275,29,01,74,005,*72";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGLGSV() throws Exception {
        GLGSVSentence sentence = new GLGSVSentence();
        sentence.setSentences(2);
        sentence.setSentenceNum(1);
        sentence.setSatNum(8);
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(new Satellite(69, 18, 232, 16));
        satellites.add(new Satellite(84, 10, 326, 22));
        satellites.add(new Satellite(83, 65, 326, 15));
        satellites.add(new Satellite(68, 68, 261, 16));
        sentence.setSatellites(satellites);

        input = "$GLGSV,2,1,08,69,18,232,16,84,10,326,22,83,65,326,15,68,68,261,16*6F";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGNGNS() throws Exception {
        List<Mode> modes = new ArrayList<>();
        modes.add(Mode.AUTONOMOUS);
        modes.add(Mode.AUTONOMOUS);

        GNGNSSentence sentence = new GNGNSSentence();
        sentence.setTime(new LocalTime(13, 54, 12));
        sentence.setLatitude(39.22349965);
        sentence.setLongitude(9.101924033333333);
        sentence.setModes(modes);
        sentence.setSatellites(7);
        sentence.setHdop(2.1f);
        sentence.setAltitude(-9.9f);
        sentence.setGeoid(47);
        sentence.setDgpsLastUpdate(0);
        sentence.setDgpsStationId(0);

        input = "$GNGNS,135412.0,3913.409979,N,00906.115442,E,AA,07,2.1,-9.9,47.0,,*48";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGNGSA1() throws Exception {
        GNGSASentence sentence = new GNGSASentence();
        sentence.setAutomatic(true);
        sentence.setFixType(Type.FIX_2D);
        sentence.setPrns(new int[]{17, 22, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        sentence.setPdop(2.3f);
        sentence.setHdop(2.1f);
        sentence.setVdop(1.0f);

        input = "$GNGSA,A,2,17,22,28,,,,,,,,,,2.3,2.1,1.0*22";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceGNGSA2() throws Exception {
        GNGSASentence sentence = new GNGSASentence();
        sentence.setAutomatic(true);
        sentence.setFixType(Type.FIX_2D);
        sentence.setPrns(new int[]{68, 69, 83, 84, 0, 0, 0, 0, 0, 0, 0, 0});
        sentence.setPdop(2.3f);
        sentence.setHdop(2.1f);
        sentence.setVdop(1.0f);

        input = "$GNGSA,A,2,68,69,83,84,,,,,,,,,2.3,2.1,1.0*28";
        expected = sentence;
        actual = NMEASentenceFactory.parseSentence(input);
        assertEquals(expected, actual);
    }
}
