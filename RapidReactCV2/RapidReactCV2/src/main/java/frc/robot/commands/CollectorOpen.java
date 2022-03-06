package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Collector;

public class CollectorOpen extends CommandBase {
    
    @Override
    public void initialize() {
        addRequirements(Collector.getInstance());
    }
    
    @Override
    public void execute() {
        Collector.getInstance().open(Constants.Speeds.collectorOpen);
    }

    @Override
    public void end(boolean interrupted) {
        Collector.getInstance().set(0); // completely stop motor movements
    }
    
}