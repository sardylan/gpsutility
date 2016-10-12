package org.thehellnet.utility.gpsutility.model;

/**
 * Created by sardylan on 06/10/16.
 */
public class Satellite {

    private int id = 0;
    private int elevation = 0;
    private int azimuth = 0;
    private int snr = 0;

    public Satellite() {
    }

    public Satellite(int id, int elevation, int azimuth, int snr) {
        this.id = id;
        this.elevation = elevation;
        this.azimuth = azimuth;
        this.snr = snr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public int getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(int azimuth) {
        this.azimuth = azimuth;
    }

    public int getSnr() {
        return snr;
    }

    public void setSnr(int snr) {
        this.snr = snr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Satellite)) return false;

        Satellite satellite = (Satellite) o;

        if (id != satellite.id) return false;
        if (elevation != satellite.elevation) return false;
        if (azimuth != satellite.azimuth) return false;
        return snr == satellite.snr;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + elevation;
        result = 31 * result + azimuth;
        result = 31 * result + snr;
        return result;
    }
}
