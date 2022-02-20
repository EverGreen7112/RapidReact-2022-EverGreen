package frc.robot.commands; // Package

// imports \\
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Sensors;
import frc.robot.subsystems.Chassis;

// PT class \\
public class PID_turn extends PIDCommand {
    private String values;

    @Override
    public void initialize() {
        Sensors.ResetAnglePID();
        super.initialize();
        Sensors.ResetGyro();
        values = "";
    }

    public void setSetPoint(double setpoint) {
        m_setpoint = () -> setpoint;
    }

    public double getSetPoint() {
        return m_setpoint.getAsDouble();
    }

    public PID_turn(double setpoint) {
        super(Sensors.getAnglePID(), // Controller
                () -> Sensors.getGyro().getAngle(), // Mesurement Source
                () -> setpoint, // Setpoint Supplier
                Chassis.getInstance()::turn, // Output Consumer
                Chassis.getInstance()); // Requirement

    }

    @Override
    public void execute() {
        super.execute(); 
        values = values.concat("" + Sensors.getGyro().getAngle() + System.currentTimeMillis() + "\n");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
