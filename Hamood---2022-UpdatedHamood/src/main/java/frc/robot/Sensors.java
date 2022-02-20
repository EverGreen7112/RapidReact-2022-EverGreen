package frc.robot;

// imports \\
import com.kauailabs.navx.frc.AHRS; // Gyro liberary import
import edu.wpi.first.wpilibj.SPI; // SPI port import

public class Sensors {
    // Gyro Variables \\
    private static AHRS m_gyro = new AHRS(SPI.Port.kMXP); // Gyro Variable

    // Get Gyro Method \\
    public static AHRS getGyro() {
        return m_gyro; // returns the gyro
    }

    // Get The Gyro Angle In Degrees \\
    public static double getGyroAngleInDegrees() {
        return Math.toDegrees(m_gyro.getAngle()); // returns the robot angle in degrees
    }

    // Reset the gyro \\
    public static void ResetGyro() {
        m_gyro.reset();
    }
}
