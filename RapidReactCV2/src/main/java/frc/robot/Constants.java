// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public final class Constants {

    public interface MotorPorts {
        public static final int
            chassisRightFront = 15,
            chassisRightMiddle = 14,
            chassisRightBack = 12,

            chassisLeftFront = 0,
            chassisLeftMiddle = 1,
            chassisLeftBack = 3,

            // missing ports
            collectorOpen = 0, 
            collectorCollect = 0; 
    }
    
    public interface DigitalPorts {
        public static final int
            // missing ports
            switchUp = 0,
            switchDown = 0;
    }
    
    public interface JoystickPorts {
        public static final int
            rightJoystick = 0,
            leftJoystick = 1,
            operator = 2;
    }  
    
    //Detail the Buttons of each Joystick
    public interface ButtonPorts {
        public static final int
            // missing ports
            collectorOpen = 0,
            collectorClose = 0,
            collectorCollect = 0;
    }

    public interface CameraPorts {
        public static int
            // missing ports
            camera = 0;
    }

    public interface Speeds {
        public static final double
            motorSpeed = 0.6,
            collectorOpen = 0.8,
            collectorCollect = 0.7;
    }

    public interface DriveConstants {
        public static double
            kS = 0.83925,
            kV = 2.6136,
            kA = 0.69928,
            kP = 4.0113,
            kTrackWidth= 0.45,
            kRamseteB = 2, // supposedly fine with any robot
            kRamseteZeta = 0.7; // supposedly fine with any robot
            
        public static DifferentialDriveKinematics kDriveKinematics = 
            new DifferentialDriveKinematics(kTrackWidth);
    }

    public interface PID {
        public static final double

        // can probably remove these later
        
        // Angle PID Variables \\
        ANGLE_KP = 0.04,
        ANGLE_KI = 0.001,
        ANGLE_KD = 0.006,
        ANGLE_TOLERANCE = 0.25,

        // Velocity PID Variables \\
        VELOCITY_KP = 0.0468,
        VELOCITY_KI = 0,
        VELOCITY_KD = 0.01,

        // Distance PID Varibles \\
        DISTANCE_KP = 0,
        DISTANCE_KI = 0,
        DISTANCE_KD = 0,
        DISTANCE_TOLERANCE = 1;
    }
    
    public interface EncoderPorts {
        public static final int
        ENCODER_RIGHT_ONE = 0,
        ENCODER_RIGHT_TWO = 1,

        ENCODER_LEFT_ONE = 5,
        ENCODER_LEFT_TWO = 6;
    }

}