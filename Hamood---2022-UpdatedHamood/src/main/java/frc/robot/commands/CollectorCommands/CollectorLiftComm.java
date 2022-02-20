package frc.robot.commands.CollectorCommands; // Package

// imports \\
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

// CLC class \\
public class CollectorLiftComm extends CommandBase { 

  private boolean m_isDown; // tracks the position of the collector

  // CLC Constructor \\
  public CollectorLiftComm() {
    addRequirements(Collector.getInstance()); // making sure that there is only one command like this
  }

  // When Command is first called \\
  @Override
  public void initialize() {

    // initialize the m_isDown variable based on the starting position \\

    if (Collector.getM_bottomLimitSwitch().get()) { // if the switch is pressed
      m_isDown = true;
    }
    else { // if the switch is not pressed
      m_isDown = false;
    }

    if (m_isDown) { // if the collector is down
      // TODO make sure this number is OK before running
      Collector.getM_collectorLift().set(0.2); // set motor speed
    }
    else {
      // TODO make sure this number is OK before running
      Collector.getM_collectorLift().set(-0.2); // set motor speed
    }
  }

  // When commad is about to end \\
  @Override
  public void end(boolean interrupted) {
    Collector.getM_collectorLift().stopMotor(); // Stops the motor
  }

  // Check if command needs to end \\
  @Override
  public boolean isFinished() {
    return (Collector.getM_topLimitSwitch().get() || Collector.getM_bottomLimitSwitch().get()); // if both switches are pressed return true
  }
}
