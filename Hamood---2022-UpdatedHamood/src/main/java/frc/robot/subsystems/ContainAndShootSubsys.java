// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer.Constants;

public class ContainAndShootSubsys extends SubsystemBase {

  // instance \\
  private static ContainAndShootSubsys casss = new ContainAndShootSubsys();

  // Constructor \\
  public ContainAndShootSubsys() {}

  // Local vars \\
  MotorControllerGroup casMotors = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.cassBottom), new WPI_VictorSPX(Constants.MotorPorts.cassTop));


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Get instance \\
  public static ContainAndShootSubsys getInstance() {
    return casss;
  }

  // Getter \\
  public MotorControllerGroup getCasMotors() {
      return casMotors;
  }
}
