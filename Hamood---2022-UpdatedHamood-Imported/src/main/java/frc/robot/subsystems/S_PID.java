// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;

public class S_PID extends PIDSubsystem {
  /** Creates a new S_PID. */
  private MotorControllerGroup m_motor;
  //private Encoder encoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
  private Encoder m_encoder;
  public S_PID(Encoder encoder,MotorControllerGroup motor, double setpoint) {
    
    super(
        // The PIDController used by the subsystem 
        new PIDController(
            Constants.StuffThatPID.ANGLE_KP, 
            Constants.StuffThatPID.ANGLE_KI,
            Constants.StuffThatPID.ANGLE_KD)
          );
      super.getController().setSetpoint(setpoint);
      this.m_motor = motor;
  }
  

  @Override
  public void useOutput(double output, double setpoint) { // use it to Move the motors
    this.m_motor.set(getController().calculate(output, setpoint));
  }

  @Override
  public double getMeasurement() { // use it to return the value that you want to pid
    // Return the process variable measurement here
    return 0;
  }
}