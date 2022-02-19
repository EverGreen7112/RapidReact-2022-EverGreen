package frc.robot.Static.subsystems; // Package

// imports \\
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Static.RobotContainer.Constants;

// Collector class \\
public class Collector extends SubsystemBase {
    // Instance \\
    private static Collector m_collector = new Collector();    

    // Motors \\
    private static MotorControllerGroup m_collectorMotor; // the motor that collects things
    private static MotorControllerGroup m_collectorLift; // the motor that controlls if the collector is up or down

    // Switches \\
    private static DigitalInput m_topLimitSwitch;
    private static DigitalInput m_bottomLimitSwitch;
    
    // Constructor \\
    public Collector() {
        // setting up the motors \\
        m_collectorMotor = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.collector)); 
        m_collectorLift = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.collectorLift));

        // Setting up the switches \\
        /*
        ! ERROR ! - wrong ports. Real ports must be found ASAP
        m_topLimitSwitch = new DigitalInput(0); // TODO enter the real port
        m_bottomLimitSwitch = new DigitalInput(0); // TODO enter the real port
        */
    } 

    // Get the instance of subsystem \\
    public static Collector getInstance() {
        return m_collector;
    }

    // Collector motor getter \\
    public static MotorControllerGroup getM_CollectorMotor() {
        return m_collectorMotor;
    } 

    // Lift motor getter \\
    public static MotorControllerGroup getM_collectorLift() {
        return m_collectorLift;
    }

    // Switch-1 motor getter \\
    public static DigitalInput getM_bottomLimitSwitch() {
        return m_bottomLimitSwitch;
    }

    // Switch-2 motor getter \\
    public static DigitalInput getM_topLimitSwitch() {
        return m_topLimitSwitch;
    }

}
