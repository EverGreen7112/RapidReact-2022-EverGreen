package frc.robot;

// imports \\
import com.kauailabs.navx.frc.AHRS; // Gyro liberary import
import edu.wpi.first.wpilibj.SPI; // SPI port import
import frc.robot.RobotContainer.Constants;
import edu.wpi.first.math.controller.PIDController; // PID controller import for m_anglePID

public class Sensors {
    // Gyro Variables \\
    private static AHRS m_gyro = new AHRS(SPI.Port.kMXP); // Gyro Variable

    // PID Variables \\
    private static PIDController m_anglePID = new PIDController(Constants.StuffThatPID.ANGLE_KP, Constants.StuffThatPID.ANGLE_KI, Constants.StuffThatPID.ANGLE_KD); // Angle PID Controller

    // Get Gyro Method \\
    public static AHRS getGyro() {
        return m_gyro; // returns the gyro
    }

    // Get The Gyro Angle In Degrees \\
    public static double getGyroAngleInDegrees() {
        return Math.toDegrees(m_gyro.getAngle()); // returns the robot angle in degrees
    }

    // Get Robot Angle \\
    public static PIDController getAnglePID() {
        return m_anglePID; // returns the angle
    }

    // Reset the Angle PID \\ 
    public static void ResetAnglePID() {
        m_anglePID.reset(); // resets the PID
    }

    // Reset the gyro \\
    public static void ResetGyro() {
        m_gyro.reset();
    }
}
