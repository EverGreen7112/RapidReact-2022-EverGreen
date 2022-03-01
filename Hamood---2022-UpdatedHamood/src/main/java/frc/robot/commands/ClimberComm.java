// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer.Constants;
import frc.robot.RobotContainer.NonConstants;
import frc.robot.subsystems.Climber;

public class ClimberComm extends CommandBase {

  long m_startTime;

  public ClimberComm() {
  }

  @Override
  public void initialize() {
    Climber.move(Constants.MathConsts.CLIMB_SPEED); // TODO check the direction
    NonConstants.driversControl = false; // makes sure the drivers wont mess up the climb
  }

  @Override
  public void end(boolean interrupted) {
    Climber.move(0);
  }

  @Override
  public boolean isFinished() {
    return (Climber.getM_bottomSwitch().get());
  }
}
