// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {
    // Instance \\
    private static Collector m_collector = new Collector();

    // Motor \\
    private WPI_VictorSPX m_collectorMotor;

    // Constructor \\
    public Collector() {
        m_collectorMotor = new WPI_VictorSPX(Constants.MotorPorts.collector);
    } 

    // Get the instance of subsys \\
    public static Collector getInstance() {
        return m_collector;
    }

    // Getters \\
    public WPI_VictorSPX getM_CollectorMotor() {
        return this.m_collectorMotor;
    }
}
