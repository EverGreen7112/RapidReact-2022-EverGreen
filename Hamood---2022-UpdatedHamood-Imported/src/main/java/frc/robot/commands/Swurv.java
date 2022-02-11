// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Controls;
import frc.robot.subsystems.Chassis;

public class Swurv extends CommandBase {
  PIDController m_pid = new PIDController(Constants.StuffThatPID.SWURV_KP,
    Constants.StuffThatPID.SWURV_KI,
    Constants.StuffThatPID.SWURV_KD);

  /** Creates a new Swurv. */
  public Swurv() {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pid.setTolerance(Constants.StuffThatPID.SWURV_TOLERANCE);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!(Controls.getM_rightJoystick().getY() == 0 && Controls.getM_rightJoystick().getX() == 0)){

      double speed = ((Controls.getM_rightJoystick().getX() + Controls.getM_rightJoystick().getY()) / 2)
       * Constants.MathConsts.CHASSIS_MOTOR_SPEED * 0.5;
      double error = m_pid.calculate(Chassis.getInstance().getInstance().getGyroAngleInDegrees(),
      Controls.getRightJoystickAsAngle());
      
      Chassis.getInstance().tankMove(speed - error, speed + error);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Chassis.getInstance().tankMove(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
