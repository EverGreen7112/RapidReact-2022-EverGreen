// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CollectorCommands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class CollectorLiftComm extends CommandBase { 

  private boolean m_isDown; // tracks the position of the collector

  public CollectorLiftComm() {
    addRequirements(Collector.getInstance());
  }


  @Override
  public void initialize() {

    // initialize the m_isDown variable based on the starting position \\

    if (Collector.getM_bottomLimitSwitch().get()) {
      m_isDown = true;
    }
    else {
      m_isDown = false;
    }

    if (m_isDown) {
      Collector.getM_collectorLift().set(0.2); // TODO make sure this number is OK before running
    }
    else {
      Collector.getM_collectorLift().set(-0.2); // TODO make sure this number is OK before running
    }
  }

  @Override
  public void end(boolean interrupted) {
    Collector.getM_collectorLift().set(0); // I don't think set(0) is necessary here but it's here just to make sure it stops
    Collector.getM_collectorLift().stopMotor();
  }

  @Override
  public boolean isFinished() {
    return (Collector.getM_topLimitSwitch().get() || Collector.getM_bottomLimitSwitch().get());
  }
}
