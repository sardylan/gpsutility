package org.thehellnet.utility.gpsutility.model;

/**
 * Created by sardylan on 12/10/16.
 */
public enum Type {

    NO_FIX,
    FIX_2D,
    FIX_3D;

    public static Type fromNumber(String number) {
        return fromNumber(Integer.parseInt(number));
    }

    public static Type fromNumber(int number) {
        switch (number) {
            case 2:
                return FIX_2D;
            case 3:
                return FIX_3D;
            default:
                return NO_FIX;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case FIX_2D:
                return "2D fix";
            case FIX_3D:
                return "3D fix";
            default:
                return "Fix not available";
        }
    }
}
