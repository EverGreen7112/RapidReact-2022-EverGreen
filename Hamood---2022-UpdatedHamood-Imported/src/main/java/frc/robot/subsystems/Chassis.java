package frc.robot.subsystems;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.NoneConstants;
import frc.robot.PidSpeedControllerGroup;

public class Chassis extends SubsystemBase {

  // initialize right motors
  private MotorControllerGroup m_right = new MotorControllerGroup(new com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX(Constants.MotorPorts.chassisRightFront), new WPI_VictorSPX(Constants.MotorPorts.chassisRightBack));
  
  // initialize left motors 
  private MotorControllerGroup m_left = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.chassisLeftFront), new WPI_VictorSPX(Constants.MotorPorts.chassisLeftBack));

  // Gyro local variable \\
  AHRS m_gyro = new AHRS(SPI.Port.kMXP);

  // Instance \\
  private static final Chassis m_chassis = new Chassis(); // creates the only instance of Chassis

  // Pid Controllers \\
  //creating pid controllers for angle velocity and distance
  private PIDController 
    m_anglePID = new PIDController(Constants.StuffThatPID.ANGLE_KP, Constants.StuffThatPID.ANGLE_KI, Constants.StuffThatPID.ANGLE_KD),
    m_velocityPID = new PIDController(Constants.StuffThatPID.VELOCITY_KP, Constants.StuffThatPID.VELOCITY_KI, Constants.StuffThatPID.VELOCITY_KD),
    m_distancePID = new PIDController(Constants.StuffThatPID.DISTANCE_KP, Constants.StuffThatPID.DISTANCE_KI, Constants.StuffThatPID.DISTANCE_KD);
  // Constructor \\
  private Chassis() {
    m_left.setInverted(true);
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

  // Gyro Things \\
  public AHRS getGyro() { // Getter \\
    return m_gyro;
  }

  public double getGyroAngleInDegrees() {
    return Math.toDegrees(m_gyro.getAngle());
  }

  public PIDController getAnglePID() { // Get robot angle \\
    return m_anglePID;
  }
}
