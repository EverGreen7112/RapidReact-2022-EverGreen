package frc.robot.Static.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Static.RobotContainer.Constants;
import frc.robot.Static.sensors.GyroClass;

public class Chassis extends SubsystemBase {

  // initialize right motors
  private MotorControllerGroup m_right = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.chassisRight1), new WPI_VictorSPX(Constants.MotorPorts.chassisRight2), new WPI_VictorSPX(Constants.MotorPorts.chassisRight3));
  
  // initialize left motors 
  private MotorControllerGroup m_left = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.chassisLeft1), new WPI_VictorSPX(Constants.MotorPorts.chassisLeft2), new WPI_VictorSPX(Constants.MotorPorts.chassisLeft3));

  // Instance \\
  private static final Chassis m_chassis = new Chassis(); // creates the only instance of Chassis

  // Pid Controllers \\
  /*
  UNUSED!
  private PIDController m_velocityPID = new PIDController(Constants.StuffThatPID.VELOCITY_KP, Constants.StuffThatPID.VELOCITY_KI, Constants.StuffThatPID.VELOCITY_KD);
  private PIDController m_distancePID = new PIDController(Constants.StuffThatPID.DISTANCE_KP, Constants.StuffThatPID.DISTANCE_KI, Constants.StuffThatPID.DISTANCE_KD);
  */

  // Constructor \\
  private Chassis() {
    m_left.setInverted(true);
    GyroClass.getGyro().reset();
  }

  // Getter of instance \\
  public static Chassis getInstance() {
    return m_chassis;
  }

  // seting the speeds of the motors
  public void setRightMotorsSpeed(double speed) {
    m_right.set(speed); 
  }

  public void setLeftMotorsSpeed(double speed) {
    m_left.set(speed); 
  }

  // tank move (using the speed controllers above)
  public void tankMove(double leftSpeed, double rightSpeed) {
    this.setRightMotorsSpeed(rightSpeed);
    this.setLeftMotorsSpeed(leftSpeed);
  }

  public void turn(double speed){
    this.tankMove(-speed, speed);
  }

  public MotorControllerGroup getM_left() {
      return m_left;
  }

  public MotorControllerGroup getM_right() {
      return m_right;
  }
}
