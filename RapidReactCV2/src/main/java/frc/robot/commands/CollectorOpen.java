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
        Collector.getInstance().open(1);
    }

    @Override
    public void end(boolean interrupted) {
        Collector.getInstance().open(0); // completely stop motor movements
    }
    
}
