// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.NoneConstants;

public class Turbo extends CommandBase {
  @Override
  public void execute() {
    NoneConstants.set_chassisSpeed(Constants.MathConsts.TURBO_SPEED);
  }

  public void end() {
    NoneConstants.set_chassisSpeed(Constants.MathConsts.REGULAR_SPEED);
  }
}
