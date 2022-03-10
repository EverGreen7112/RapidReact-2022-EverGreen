package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Storage extends SubsystemBase {

    private static final Storage m_storage = new Storage(); // storage's instance

    private WPI_VictorSPX m_motor;

    public Storage() {
        // initialize motor
        m_motor = new WPI_VictorSPX(Constants.MotorPorts.storage);
        m_motor.setInverted(true);
    }

    public static Storage getInstance() {
        return m_storage;
    }

    public void set(double speed) {
        m_motor.set(speed);
    }

}
