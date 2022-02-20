package frc.robot.commands.CollectorCommands; // Package

// imports \\
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

// CC class \\
public class CollectorComm extends CommandBase {


  // CC constructor \\
  public CollectorComm() {
    addRequirements(Collector.getInstance()); // making sure that there is only one command
  }

  // When command is first called \\
  @Override
  public void initialize() {
    Collector.getM_CollectorMotor().set(0.4); // Starts the motor
  }

  // When command has ended \\
  @Override
  public void end(boolean interrupted) {
      Collector.getM_CollectorMotor().stopMotor(); // Stops the motor
      super.end(interrupted);
  }
}
