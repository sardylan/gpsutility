package org.thehellnet.utility.gpsutility.keeper

import org.joda.time.DateTime
import org.thehellnet.utility.gpsutility.keeper.callback.DateTimeCallback
import org.thehellnet.utility.gpsutility.keeper.callback.PositionCallback
import org.thehellnet.utility.gpsutility.sentence.GPGGASentence
import org.thehellnet.utility.gpsutility.sentence.GPRMCSentence
import spock.lang.Specification

/**
 * Created by sardylan on 14/10/16.
 */
class NMEAKeeperTest extends Specification {

    def nmeaContext
    def nmeaKeeper
    def callback
    def sentence
    def dateTime

    def setup() {
        nmeaContext = new NMEAContext()
        nmeaKeeper = new NMEAKeeper(nmeaContext)
    }

    def "Should invoke newPosition callback with GPGGA sentence"() {
        given:
        sentence = new GPGGASentence()
        sentence.latitude = 1
        sentence.longitude = 1
        sentence.altitude = 1

        callback = Mock(PositionCallback)
        nmeaKeeper.setPositionCallback(callback)

        when:
        nmeaKeeper.newSentence(sentence)

        then:
        1 * callback.newPosition(1, 1, 1)
    }

    def "Should invoke newDateTime callback with GPRMC sentence"() {
        given:
        dateTime = new DateTime()
        sentence = new GPRMCSentence()
        sentence.dateTime = dateTime

        callback = Mock(DateTimeCallback)
        nmeaKeeper.setPositionCallback(callback)

        when:
        nmeaKeeper.newSentence(sentence)

        then:
        1 * callback.newDateTime(dateTime)
    }
}
