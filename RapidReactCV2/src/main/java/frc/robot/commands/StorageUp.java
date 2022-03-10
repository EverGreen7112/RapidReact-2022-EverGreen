package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Storage;

public class StorageUp extends CommandBase {
    
    @Override
    public void initialize(){
        addRequirements(Storage.getInstance());
    }

    @Override
    public void execute(){
        Storage.getInstance().set(Constants.Speeds.storageMotor);
    }

    @Override
    public void end(boolean interrupted){
        Storage.getInstance().set(0);
    }
}
