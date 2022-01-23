package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
public class PidSpeedControllerGroup extends SpeedControllerGroup{
    // Local class variables \\
    private PIDController m_pidController;
    private Encoder m_encoder;
    //-----------------------------------------------------------------------------------------\\
    //constructor\\
    public PidSpeedControllerGroup(Encoder encoder,double setpoint,double kp, double ki, double kd,WPI_VictorSPX ... motors) {
        super(motors); // SpeedContrllerGroup constructor \\
        this.m_encoder = encoder; // sets the local variable of the encoder towhat given in the constructor \\

        m_pidController = new PIDController(kp, ki, kd); // Creating the PID controller \\  
        m_pidController.setSetpoint(setpoint); // setting the setpoint \\
    }
    //-----------------------------------------------------------------------------------------\\
    public void setSpeed(double setpoint){
        m_pidController.setSetpoint(setpoint); // set the setpoint\\
    }
    //-----------------------------------------------------------------------------------------\\
    // Moving a SpeedControllerGroup \\
    public void move(){
        super.set(m_pidController.calculate(m_encoder.getDistance(),
         m_pidController.getSetpoint()));
    }
    //-----------------------------------------------------------------------------------------\\
    // Moving the entire tank \\
    public void tankMove() {
        super.set(m_pidController.calculate(m_encoder.getDistance(),
         m_pidController.getSetpoint()));
    }


    
}
