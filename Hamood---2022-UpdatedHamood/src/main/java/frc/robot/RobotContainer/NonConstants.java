package frc.robot.RobotContainer; // Package

// NC class \\
public class NonConstants {

    public static boolean
        driversControl = true;
    

    public static double 
        //collector\\
        collectorKP = 0.73,
        collectorKI = 0.018,
        collectorKD = 0.0004,

        // PID Speed Controller Group \\
        previousDistance = 0; // previous distance for getRateByDistance() in PidSpeedControllerGroup
}
