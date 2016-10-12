package org.thehellnet.utility.gpsutility.model;

/**
 * Created by sardylan on 05/10/16.
 */
public enum Mode {

    INVALID,
    AUTONOMOUS,
    DIFFERENTIAL,
    PPS,
    REAL_TIME_KINEMATIC,
    FLOAT_RTK,
    ESTIMATED,
    MANUAL_INPUT,
    SIMULATION;

    public static Mode fromNumber(String number) {
        return fromNumber(Integer.parseInt(number));
    }

    public static Mode fromNumber(int number) {
        switch (number) {
            case 1:
                return AUTONOMOUS;
            case 2:
                return DIFFERENTIAL;
            case 3:
                return PPS;
            case 4:
                return REAL_TIME_KINEMATIC;
            case 5:
                return FLOAT_RTK;
            case 6:
                return ESTIMATED;
            case 7:
                return MANUAL_INPUT;
            case 8:
                return SIMULATION;
            default:
                return INVALID;
        }
    }

    public static Mode fromString(char c) {
        return fromString(String.valueOf(c));
    }

    public static Mode fromString(String mode) {
        switch (mode) {
            case "A":
                return AUTONOMOUS;
            case "D":
                return DIFFERENTIAL;
            case "P":
                return PPS;
            case "R":
                return REAL_TIME_KINEMATIC;
            case "F":
                return FLOAT_RTK;
            case "E":
                return ESTIMATED;
            case "M":
                return MANUAL_INPUT;
            case "S":
                return SIMULATION;
            default:
                return INVALID;
        }
    }

    public int toInt() {
        switch (this) {
            case AUTONOMOUS:
                return 1;
            case DIFFERENTIAL:
                return 2;
            case PPS:
                return 3;
            case REAL_TIME_KINEMATIC:
                return 4;
            case FLOAT_RTK:
                return 5;
            case ESTIMATED:
                return 6;
            case MANUAL_INPUT:
                return 7;
            case SIMULATION:
                return 8;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case AUTONOMOUS:
                return "Autonomous (GPS - SPS)";
            case DIFFERENTIAL:
                return "Differential";
            case PPS:
                return "Precise";
            case REAL_TIME_KINEMATIC:
                return "Real Time Kinematic";
            case FLOAT_RTK:
                return "Float RTK";
            case ESTIMATED:
                return "Estimated (dead reckoning)";
            case MANUAL_INPUT:
                return "Manual input";
            case SIMULATION:
                return "Simulation mode";
            default:
                return "Invalid";
        }
    }
}
