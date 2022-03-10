package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Chassis;

public class Turbu extends CommandBase{
	@Override
	public void initialize() {
		Constants.Speeds.motorSpeed = 1;
	}
	@Override
	public void end(boolean interrupted) {
		Constants.Speeds.motorSpeed = 0.7;
	}

}
