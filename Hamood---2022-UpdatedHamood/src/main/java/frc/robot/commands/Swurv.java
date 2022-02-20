package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Sensors;
import frc.robot.RobotContainer.Constants;
import frc.robot.RobotContainer.Controls;
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
    // ShuffleBoard \\
    SmartDashboard.putNumber("Right Joystick Y", Controls.getM_rightJoystick().getY());
    SmartDashboard.putNumber("Right Joystick X", Controls.getM_rightJoystick().getX());

    // Should I turn \\
    if (!(Math.abs(Controls.getM_rightJoystick().getY()) <= Constants.MathConsts.JOYSTICK_MINIMUM &&
     Math.abs(Controls.getM_rightJoystick().getX()) <= Constants.MathConsts.JOYSTICK_MINIMUM)) {

      //  Dashboard \\
      SmartDashboard.putNumber("Gyro", (360 + Sensors.getGyroAngleInDegrees()) % 360);
      SmartDashboard.putNumber("Joystick", Controls.getRightJoystickAsAngle());
      SmartDashboard.putNumber("Angle error", Controls.getRightJoystickAsAngle() - ((360 + Sensors.getGyroAngleInDegrees()) % 360));

      // speed calc \\
      double speed = (
          (
            Controls.getM_rightJoystick().getX() +
            Controls.getM_rightJoystick().getY()
          ) / 2
        ) * 
        Constants.MathConsts.CHASSIS_MOTOR_SPEED * 0;
      

      // error calc \\
      double error = m_pid.calculate(
        (
          360 + Sensors.getGyroAngleInDegrees()
        ) % 360,
        Controls.getRightJoystickAsAngle());
      
      // moving the robot \\
      Chassis.getInstance().tankMove(speed + error, speed - error);

    }

    // If not to turn \\
    else{
      Chassis.getInstance().tankMove(0, 0);
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
