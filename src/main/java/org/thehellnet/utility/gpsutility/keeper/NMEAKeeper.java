package org.thehellnet.utility.gpsutility.keeper;

import org.thehellnet.utility.gpsutility.keeper.callback.DateTimeCallback;
import org.thehellnet.utility.gpsutility.keeper.callback.PositionCallback;
import org.thehellnet.utility.gpsutility.sentence.GPGGASentence;
import org.thehellnet.utility.gpsutility.sentence.GPGSASentence;
import org.thehellnet.utility.gpsutility.sentence.GPRMCSentence;
import org.thehellnet.utility.gpsutility.sentence.NMEASentence;

/**
 * Created by sardylan on 13/10/16.
 */
public class NMEAKeeper implements NMEAListener {

    private NMEAContext context;

    private CallbackCaller callbackCaller = new CallbackCaller();

    public NMEAKeeper(NMEAContext context) {
        this.context = context;
    }

    @Override
    public void newSentence(NMEASentence sentence) {
        if (sentence instanceof GPGGASentence) parseGPGGA((GPGGASentence) sentence);
        else if (sentence instanceof GPGSASentence) parseGPGSA((GPGSASentence) sentence);
        else if (sentence instanceof GPRMCSentence) parseGPRMC((GPRMCSentence) sentence);
    }

    public void setPositionCallback(PositionCallback callback) {
        callbackCaller.setPositionCallback(callback);
    }

    public void setDateTimeCallback(DateTimeCallback callback) {
        callbackCaller.setDateTimeCallback(callback);
    }

    private void parseGPGGA(GPGGASentence sentence) {
        double oldLatitude = context.getLatitude();
        double oldLongitude = context.getLongitude();
        float oldAltitude = context.getAltitude();

        context.setLatitude(sentence.getLatitude());
        context.setLongitude(sentence.getLongitude());
        context.setAltitude(sentence.getAltitude());
        context.setGeoid(sentence.getGeoid());
        context.setSatellites(sentence.getSatellites());
        context.setHdop(sentence.getHdop());
        context.setDgpsLastUpdate(sentence.getDgpsLastUpdate());
        context.setDgpsStationId(sentence.getDgpsStationId());
        context.setGpsMode(sentence.getMode());

        if (oldLatitude != context.getLatitude()
                || oldLongitude != context.getLongitude()
                || oldAltitude != context.getAltitude()) {
            callbackCaller.callPosition(context.getLatitude(), context.getLongitude(), context.getAltitude());
        }
    }

    private void parseGPGSA(GPGSASentence sentence) {
        context.setPdop(sentence.getPdop());
        context.setHdop(sentence.getHdop());
        context.setVdop(sentence.getVdop());
    }

    private void parseGPRMC(GPRMCSentence sentence) {
        context.setDateTime(sentence.getDateTime());

        if (sentence.isStatus()) {
            callbackCaller.callDateTime(context.getDateTime());
        }
    }
}
