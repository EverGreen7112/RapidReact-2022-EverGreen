package frc.robot.Static.commands;

import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Static.sensors.GyroClass;
import frc.robot.Static.subsystems.Chassis;

import java.io.FileWriter;
import java.io.IOException;

public class PID_turn extends PIDCommand implements DoubleArgCommand {
    private String values;

    @Override
    public void initialize() {
        GyroClass.ResetAnglePID();
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

    public PID_turn(double setpoint) {
        super(GyroClass.getAnglePID(), // Controller
                () -> GyroClass.getGyro().getAngle(), // Mesurement Source
                () -> setpoint, // Setpoint Supplier
                Chassis.getInstance()::turn, // Output Consumer
                Chassis.getInstance()); // Requirement

    }

    @Override
    public void execute() {
        super.execute(); 
        values = values.concat("" + GyroClass.getGyro().getAngle() + System.currentTimeMillis() + "\n");
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
