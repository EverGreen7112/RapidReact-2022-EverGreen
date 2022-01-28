package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.math.controller.PIDController;
public class PidSpeedControllerGroup extends SpeedControllerGroup{
    // Local class variables \\
    private PIDController m_pidController;
    private Encoder m_encoder;
    //-----------------------------------------------------------------------------------------\\
    //constructor\\
    public PidSpeedControllerGroup(Encoder encoder,double setpoint,double kp, double ki, double kd,SpeedControllerGroup m_rightGroup) {
        
        super(m_rightGroup); // SpeedContrllerGroup constructor \\
        this.m_encoder = encoder; // sets the local variable of the encoder towhat given in the constructor \\

        m_pidController = new PIDController(kp, ki, kd); // Creating the PID controller \\  
        m_pidController.setSetpoint(setpoint); // setting the setpoint \\
        
        SmartDashboard.putNumber("speed rate", 0);
    }
    //-----------------------------------------------------------------------------------------\\
    public void setSpeed(double setpoint){
        m_pidController.setSetpoint(setpoint); // set the setpoint\\
    }
    //-----------------------------------------------------------------------------------------\\
    // Moving a SpeedControllerGroup \\
    @Override
    public void set(double speed){
        this.setSpeed(speed);
        this.move();
    }
    //-----------------------------------------------------------------------------------------\\
    // Moving the entire tank \\
    public void move() {
        SmartDashboard.putNumber("speed rate", this.m_encoder.getDistance());
        super.set(m_pidController.calculate(m_encoder.getDistance(),
         m_pidController.getSetpoint()));
    }
    //-----------------------------------------------------------------------------------------\\
    // sets PID K values \\
    public void setPID(double kp, double ki, double kd){
        m_pidController.setPID(kp, ki, kd);
        
    }
}
