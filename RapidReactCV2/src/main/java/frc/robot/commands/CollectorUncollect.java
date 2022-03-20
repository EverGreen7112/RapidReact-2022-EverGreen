package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Storage;

public class CollectorUncollect extends CommandBase {
    
    @Override
    public void initialize(){
        addRequirements(Collector.getInstance(),Storage.getInstance());
    }

    @Override
    public void execute(){
		Storage.getInstance().set(-Constants.Speeds.storageMotor);
        Collector.getInstance().set(-Constants.Speeds.collectorCollect);
    }

    @Override
    public void end(boolean interrupted){
        Collector.getInstance().set(0);
		Storage.getInstance().set(0);

    }
}
