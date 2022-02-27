// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer.Constants;

public class Climber extends SubsystemBase {
  
  private static MotorControllerGroup climberMotors = 
    new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.climberMotor));

  public static void move(double speed) {
    climberMotors.set(speed);
  }
}
