package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;
import frc.robot.Constants;

public class CollectorClose extends CommandBase {

	@Override
	public void initialize() {
		
		addRequirements(Collector.getInstance());
	}

	@Override
	public void execute() {
		Collector.getInstance().open(-1f);; // move the other way (up)
	}

	@Override
	public boolean isFinished() {
		return false; // stop if microswitch was pressed
	}

	@Override
	public void end(boolean interrupted) {
		Collector.getInstance().open(0); // completely stop motor movements
	}

}
