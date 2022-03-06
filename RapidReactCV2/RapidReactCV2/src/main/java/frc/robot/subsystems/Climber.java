package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {

    private static final Climber m_climber = new Climber(); // climber's instance

    private static WPI_VictorSPX m_motor;

    private static DigitalInput m_switchOpen;

    public Climber(){

        m_motor = new WPI_VictorSPX(Constants.MotorPorts.climber);

        m_motor.setNeutralMode(NeutralMode.Brake);

        m_switchOpen = new DigitalInput(Constants.DigitalPorts.switchClimber);

    }

    public static Climber getInstance(){
        return m_climber;
    }

    public void set(double speed){
        m_motor.set(speed);
    }

    public boolean isUp(){
        return m_switchOpen.get();
    }

}
