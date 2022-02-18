// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer.Constants;

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
        m_collectorMotor = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.collector));
        m_collectorLift = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.collectorLift));
        m_topLimitSwitch = new DigitalInput(0); // TODO enter the real port
        m_bottomLimitSwitch = new DigitalInput(0); // TODO enter the real port
    } 

    // Get the instance of subsystem \\
    public static Collector getInstance() {
        return m_collector;
    }

    // Getters \\ 
    
    public static MotorControllerGroup getM_CollectorMotor() {
        return m_collectorMotor;
    } 
 
    // set speed \\
    public static void set(double speed) {
        m_collectorMotor.set(speed);
    }

    public static DigitalInput getM_bottomLimitSwitch() {
        return m_bottomLimitSwitch;
    }

    public static DigitalInput getM_topLimitSwitch() {
        return m_topLimitSwitch;
    }

    public static MotorControllerGroup getM_collectorLift() {
        return m_collectorLift;
    }
}
