package frc.robot.commands; // Package

// imports \\
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.sensors.GyroClass;
import frc.robot.subsystems.Chassis;

// PT class \\
public class PID_turn extends PIDCommand {
    private String values;

    @Override
    public void initialize() {
        GyroClass.ResetAnglePID();
        super.initialize();
        GyroClass.ResetGyro();
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
}
