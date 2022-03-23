package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  
  private static final Chassis m_chassis = new Chassis(); // chassis's instance

  private MotorControllerGroup m_rightMotors, m_leftMotors;

  private WPI_VictorSPX m_leftFront;

  private Encoder m_encoderR, m_encoderL;

  AHRS m_gyro;

  private Chassis() {
    // initialize motors and fix rotation for head side 
    m_leftFront = new WPI_VictorSPX(Constants.MotorPorts.chassisLeftFront);
    m_leftFront.setInverted(true);

    m_rightMotors = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.chassisRightFront), new WPI_VictorSPX(Constants.MotorPorts.chassisRightMiddle), new WPI_VictorSPX(Constants.MotorPorts.chassisRightBack));
    m_leftMotors = new MotorControllerGroup(m_leftFront, new WPI_VictorSPX(Constants.MotorPorts.chassisLeftMiddle), new WPI_VictorSPX(Constants.MotorPorts.chassisLeftBack));

    m_rightMotors.setInverted(true);
    
    // initialize encoders (one on each side), fix rotation for head side
    m_encoderR = new Encoder(Constants.EncoderPorts.ENCODER_RIGHT_ONE, Constants.EncoderPorts.ENCODER_RIGHT_TWO);
    m_encoderL = new Encoder(Constants.EncoderPorts.ENCODER_LEFT_ONE, Constants.EncoderPorts.ENCODER_LEFT_TWO);
    
    m_encoderR.setReverseDirection(true);

    // turn the distance into meters
    m_encoderR.setDistancePerPulse((Math.PI * 0.1524) / (10.71 * 20));
    m_encoderL.setDistancePerPulse((Math.PI * 0.1524) / (10.71 * 20));
    
    // initialize gyro
    m_gyro = new AHRS(SPI.Port.kMXP);

  }

  public static Chassis getInstance() {
    return m_chassis;
  }

  public MotorControllerGroup getRightMotors() {
    return m_rightMotors;
  }

  public MotorControllerGroup getLeftMotors() {
      return m_leftMotors;
  }

  public Encoder getRightEncoder(){
    return m_encoderR;
  }

  public Encoder getLeftEncoder(){
    return m_encoderL;
  }
  
  public AHRS getGyro() {
    return m_gyro;
  }
  
  public void tankMove(double leftSpeed, double rightSpeed) {

    // used by the joysticks
    m_rightMotors.set(rightSpeed);
    m_leftMotors.set(leftSpeed);

    
  }

  public void turn(double speed){

    // in order to turn, move motors to opposite sides.
    this.tankMove(speed, -speed);

  }

}