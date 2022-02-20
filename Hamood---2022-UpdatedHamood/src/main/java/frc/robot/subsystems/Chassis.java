package frc.robot.subsystems; // Package

import edu.wpi.first.math.controller.PIDController;
// imports \\
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Sensors;
import frc.robot.RobotContainer.Constants;

// Chassis class \\
public class Chassis extends SubsystemBase {

  // initialize right motors
  private MotorControllerGroup m_right = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.chassisRight1), new WPI_VictorSPX(Constants.MotorPorts.chassisRight2), new WPI_VictorSPX(Constants.MotorPorts.chassisRight3));
  
  // initialize left motors 
  private MotorControllerGroup m_left = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.chassisLeft1), new WPI_VictorSPX(Constants.MotorPorts.chassisLeft2), new WPI_VictorSPX(Constants.MotorPorts.chassisLeft3));

  // Instance \\
  private static final Chassis m_chassis = new Chassis(); // creates the only instance of Chassis

  // Pid Controllers \\

  // PID Variables \\
  private static PIDController m_anglePID = new PIDController(Constants.StuffThatPID.ANGLE_KP, Constants.StuffThatPID.ANGLE_KI, Constants.StuffThatPID.ANGLE_KD); // Angle PID Controller

  /*
  UNUSED!
  private PIDController m_velocityPID = new PIDController(Constants.StuffThatPID.VELOCITY_KP, Constants.StuffThatPID.VELOCITY_KI, Constants.StuffThatPID.VELOCITY_KD);
  private PIDController m_distancePID = new PIDController(Constants.StuffThatPID.DISTANCE_KP, Constants.StuffThatPID.DISTANCE_KI, Constants.StuffThatPID.DISTANCE_KD);
  */

  // Constructor \\
  private Chassis() {
    m_left.setInverted(true); // Inverting the left motor so it would drive in the right direction
    Sensors.ResetGyro(); // reseting the gyro once Chassis is created
  }

  // Getter of instance \\
  public static Chassis getInstance() {
    return m_chassis;
  }

  // Moving the right motor by setting the speed \\
  public void setRightMotorsSpeed(double speed) {
    m_right.set(speed); // Moving the right motor
  }

  // Moving the left motor by setting the speed
  public void setLeftMotorsSpeed(double speed) {
    m_left.set(speed); // Moving the right motor
  }

  // tank move (using the speed controllers above)
  public void tankMove(double leftSpeed, double rightSpeed) {
    this.setRightMotorsSpeed(rightSpeed); // Moving the right motor
    this.setLeftMotorsSpeed(leftSpeed); // Moving the left motor
  }


  // Turning the robot \\
  public void turn(double speed){
    this.tankMove(-speed, speed); // moving the motors
  }

  // Getter of left motor group \\
  public MotorControllerGroup getM_left() {
      return m_left;
  }

  // Getter of right motor group \\
  public MotorControllerGroup getM_right() {
      return m_right;
  }

  // Get Robot Angle \\
  public static PIDController getAnglePID() {
    return m_anglePID; // returns the angle
  }

  // Reset the Angle PID \\ 
  public static void ResetAnglePID() {
      m_anglePID.reset(); // resets the PID
  }
}
