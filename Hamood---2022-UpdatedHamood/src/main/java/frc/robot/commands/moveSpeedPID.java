package frc.robot.commands; // Package

// imports \\
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.PID_FILES.PidSpeedControllerGroup;
import frc.robot.RobotContainer.Constants;
import frc.robot.RobotContainer.NoneConstants;
import frc.robot.subsystems.Chassis;

// MSP class \\
public class moveSpeedPID extends CommandBase {

  private static Encoder m_encoderL = new Encoder(Constants.Sensors.ENCODER_ONE, Constants.Sensors.ENCODER_TWO);

  private static Encoder m_encoderR = new Encoder(Constants.Sensors.ENCODER_THREE, Constants.Sensors.ENCODER_FOUR);

  // Motor Controllers local variables \\
  private static PidSpeedControllerGroup m_MotorControllerL, m_MotorControllerR; 

  // Local speed variables \\
  private double m_speedL, m_speedR;

  // MSP Constructor \\
  public moveSpeedPID(double speedL, double speedR) {
    addRequirements(Chassis.getInstance());

    // Defining The Local Speed Vars \\
    m_speedL = speedL;
    m_speedR = speedR;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_encoderR.setDistancePerPulse(PidSpeedControllerGroup.EncoderRateToDistance(20, 10.71, 0.1524));
    m_encoderL.setDistancePerPulse(PidSpeedControllerGroup.EncoderRateToDistance(20, 10.71, 0.1524));
    m_encoderR.setReverseDirection(true);

    m_MotorControllerL = new PidSpeedControllerGroup(
    m_encoderR,
    0.0, 
    NoneConstants.collectorKP, 
    NoneConstants.collectorKI,
    NoneConstants.collectorKD, 
    Chassis.getInstance().getM_left());

    m_MotorControllerR = new PidSpeedControllerGroup(
    m_encoderL,
    0.0, 
    NoneConstants.collectorKP, 
    NoneConstants.collectorKI,
    NoneConstants.collectorKD, 
    Chassis.getInstance().getM_right()); 
    
    m_MotorControllerL.set(m_speedL);
    m_MotorControllerR.set(m_speedR);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_MotorControllerL.move();
    m_MotorControllerR.move();
  }

  public void setSpeeds(double speedL, double speedR){
    m_MotorControllerR.set(speedR);
    m_MotorControllerL.set(speedL);
  }

  public static Encoder getM_encoderL() {
      return m_encoderL;
  }

  public static Encoder getM_encoderR() {
      return m_encoderR;
  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_MotorControllerR.set(0);
    m_MotorControllerL.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
