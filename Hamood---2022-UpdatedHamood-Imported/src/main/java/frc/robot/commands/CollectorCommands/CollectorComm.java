// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CollectorCommands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

// this command is used to collect things

public class CollectorComm extends CommandBase {

  public CollectorComm() {
    addRequirements(Collector.getInstance());
  }

  @Override
  public void initialize() {
    Collector.set(0.4);
  }

  @Override
  public void end(boolean interrupted) {
      Collector.set(0);
      super.end(interrupted);
  }
}
