// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.NoneConstants;
import frc.robot.PidSpeedControllerGroup;

public class Collector extends SubsystemBase {
    // Instance \\
    private static Collector m_collector = new Collector();
    private static Encoder m_encoder = new Encoder(Constants.Sensors.ENCODER_COLLECTOR_ONE, Constants.Sensors.ENCODER_COLLECTOR_TWO);
    

    // Motor \\
    private static MotorControllerGroup m_collectorMotorRaw; //TODO change this code to move the collector motor instead of chassis
    private static PidSpeedControllerGroup m_collectorMotor = new PidSpeedControllerGroup(
    m_encoder,
    0.0, 
    NoneConstants.collectorKP, 
    NoneConstants.collectorKI,
    NoneConstants.collectorKD, 
    new MotorControllerGroup(m_collectorMotorRaw)); //TODO change this code to move the collector motor instead of chassis

    // Constructor \\
    public Collector() {
        m_collectorMotorRaw = new MotorControllerGroup(new WPI_VictorSPX(Constants.MotorPorts.chassisRightFront), new WPI_VictorSPX(Constants.MotorPorts.chassisRightBack)); //TODO change this code to move the collector motor instead of chassis
    } 

    // Get the instance of subsystem \\
    public static Collector getInstance() {
        return m_collector;
    }

    // Getters \\ 
    /*
    public static WPI_VictorSPX getM_CollectorMotor() {
        return m_collectorMotorRaw;
    } */
 
    // set speed \\
    public static void set(double speed){
        updatePID();
        m_collectorMotor.setSpeed(speed);
    }

    // move with current speed \\
    public static void move(){
        updatePID();
        m_collectorMotor.move();
    }

    // update PID \\
    private static void updatePID(){
        m_collectorMotor.setPID(NoneConstants.collectorKP, NoneConstants.collectorKI, NoneConstants.collectorKD);
    }

    // upadates the thingy at the shuffleborad \\
    /* public static void updateShuffleBoard(){
        m_collectorMotor.putUpdatedRate();
    } */



    // get encoder \\
    public static Encoder getM_encoder() {
        return m_encoder;
    }
}
