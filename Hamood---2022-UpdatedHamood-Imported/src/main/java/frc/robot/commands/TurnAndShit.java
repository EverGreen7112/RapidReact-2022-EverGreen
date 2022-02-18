package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Chassis;
import java.io.FileWriter;
import java.io.IOException;

public class TurnAndShit extends PIDCommand implements DoubleArgCommand {
    private String values;

    @Override
    public void initialize() {
        Chassis.getAnglePID().reset();
        super.initialize();
        //Chassis.getInstance().getGyro().reset();
        values = "";
    }

    public void setSetPoint(double setpoint) {
        m_setpoint = () -> setpoint;
    }

    public double getSetPoint() {
        return m_setpoint.getAsDouble();
    }

    public TurnAndShit(double setpoint) {
        super(Chassis.getInstance().getAnglePID(), // Controller
                () -> Chassis.getInstance().getGyro().getAngle(), // Mesurement Source
                () -> setpoint, // Setpoint Supplier
                Chassis.getInstance()::turn, // Output Consumer
                Chassis.getInstance()); // Requirement

    }

    @Override
    public void execute() {
        super.execute(); 
        values = values.concat("" + Chassis.getInstance().getGyro().getAngle() + System.currentTimeMillis() + "\n");
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void setValue(double setpoint) {
        setSetPoint(setpoint);
    }

    @Override
    public double getValue() {
        return getSetPoint();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);

        FileWriter file = null;
        try {
            file = new FileWriter("/home/lvuser/values.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file.write(values);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
