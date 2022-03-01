package frc.robot.PID_FILES;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer.NonConstants;
import edu.wpi.first.math.controller.PIDController;

public class PidSpeedControllerGroup extends MotorControllerGroup{
    // Local class variables \\
    private PIDController m_pidController;
    private Encoder m_encoder;

    //constructor\\
    public PidSpeedControllerGroup(Encoder encoder,double setpoint,double kp, double ki, double kd, MotorControllerGroup motorControllerGroup) {
        
        super(motorControllerGroup); // SpeedContrllerGroup constructor \\
        this.m_encoder = encoder; // sets the local variable of the encoder towhat given in the constructor \\

        m_pidController = new PIDController(kp, ki, kd); // Creating the PID controller \\  
        m_pidController.setSetpoint(setpoint); // setting the setpoint \\
        
        //this.putUpdatedRate();

        this.m_encoder.setDistancePerPulse(EncoderRateToDistance(20, 10.71, 0.1524));
    }

    public void setSpeed(double setpoint) {
        m_pidController.setSetpoint(setpoint); // set the setpoint\\
    }
    
    // Moving a SpeedControllerGroup \\
    @Override
    public void set(double speed){
        this.setSpeed(speed);
        this.move();
    }
    
    // Moving the entire tank \\
    public void move() {
         super.set(m_pidController.calculate(m_encoder.getRate(),
         m_pidController.getSetpoint()));
         SmartDashboard.putNumber("pid value position", m_pidController.getPositionError());
    }
    
    // sets PID K values \\
    public void setPID(double kp, double ki, double kd){
        m_pidController.setPID(kp, ki, kd);
        
    }

    public double getRateByDistance() {
        double returnedRate = this.m_encoder.getDistance() - NonConstants.previousDistance;

        NonConstants.previousDistance = this.m_encoder.getDistance();

        return returnedRate;
    }

    public static double EncoderRateToDistance(double ticksPerCycle, double transmitionRatio, double CircleDiameter) {
        return ((CircleDiameter * Math.PI) / (ticksPerCycle * transmitionRatio));
    }

    // sts the 0 to the integral \\
    public void resetI(){
        this.m_pidController.reset();
    }
}
