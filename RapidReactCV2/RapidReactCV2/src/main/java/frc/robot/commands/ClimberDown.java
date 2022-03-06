package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;

public class ClimberDown extends CommandBase {
    
    @Override
    public void initialize(){
        addRequirements(Climber.getInstance());
    }

    @Override
    public void execute(){
        if (Climber.getInstance().isUp())
            Climber.getInstance().set(-Constants.Speeds.climberMotor);
    }

    @Override
    public boolean isFinished(){
        return !Climber.getInstance().isUp();
    }

    @Override
    public void end(boolean interrupted){
        Climber.getInstance().set(0);
    }
}
