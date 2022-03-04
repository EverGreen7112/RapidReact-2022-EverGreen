package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Collector;

public class CollectorClose extends CommandBase {
    
    @Override
    public void initialize() {
        addRequirements(Collector.getInstance());
    }
    
    @Override
    public void execute() {
        Collector.getInstance().open(-Constants.Speeds.collectorOpen); // move the other way (up)
    }

    @Override
    public boolean isFinished() {
        return Collector.getInstance().isUp(); // stop if microswitch was pressed
    }

    @Override
    public void end(boolean interrupted) {
        Collector.getInstance().stopMotor(); // completely stop motor movements
    }

}
