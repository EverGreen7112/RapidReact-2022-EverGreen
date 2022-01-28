package frc.robot;

public class NoneConstants {
    // TEST PID K VALUES \\
    public static double 
        //collector\\
        collectorKP = 0,
        collectorKI = 0,
        collectorKD = 0;
    
    //-----------------------------------------------------------------------------------------\\
    // Chassis speed \\
    public static double chassisSpeed = 0.4;

    // Getter \\
    public static double get_chassisSpeed() {
        return chassisSpeed;
    }

    // Setter \\ 
    public static void set_chassisSpeed(double newChassisSpeed) {
        chassisSpeed = newChassisSpeed;
    }
    //-----------------------------------------------------------------------------------------\\
}
