package frc.robot.commands; // Package

// imports \\
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer.Constants;
import frc.robot.subsystems.ContainAndShootSubsys;

// CAS class \\
public class ContainAndShoot extends CommandBase {

  // Constructor \\
  public ContainAndShoot() {
    addRequirements(ContainAndShootSubsys.getInstance());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ContainAndShootSubsys.getInstance().getCasMotors().set(Constants.MathConsts.CAS_MOTOR_SPEED);
  }
}
