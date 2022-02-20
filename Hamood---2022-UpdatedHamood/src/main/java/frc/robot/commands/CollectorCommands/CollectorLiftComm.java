package frc.robot.commands.CollectorCommands; // Package

// imports \\
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer.Constants;
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

    m_isDown = Collector.getM_bottomLimitSwitch().get();

    Collector.getM_collectorLift().set(Constants.MathConsts.CL_MOTOR_SPEED * (m_isDown ? 1 : -1)); // if true then .set(0.2) else .set(-0.2)
  }

  // When commad is about to end \\
  @Override
  public void end(boolean interrupted) {
    Collector.getM_collectorLift().set(0);
    Collector.getM_collectorLift().stopMotor(); // Stops the motor
  }

  // Check if command needs to end \\
  @Override
  public boolean isFinished() {
    return (Collector.getM_topLimitSwitch().get() || Collector.getM_bottomLimitSwitch().get()); // if one of the switches is pressed return true
  }
}
