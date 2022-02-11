// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import frc.robot.commands.Swurv;

public final class Constants {
    public interface testValues {
        public static final double 
            SPEED_JUMPS = 0.01;
    }
    public interface MotorPorts {
        public static final int
        chassisRightBack = 14, //WPI_VictorSPX
        chassisRightFront = 15, //WPI_VictorSPX
        chassisLeftBack = 0, //WPI_VictorSPX
        chassisLeftFront = 1, //WPI_VictorSPX
        collector = 12; //WPI_VictorSPX
    }
    //-------------------------------------------------------------------------------------------------------------\\
    //Detail Piston Components
    public interface PistonPorts {
    
        
    }
    //-------------------------------------------------------------------------------------------------------------\\
    
    //Detail Digital components
    public interface DigitalPorts {
    }
    //-------------------------------------------------------------------------------------------------------------\\
    public interface AnalogPorts{
    }
    //-------------------------------------------------------------------------------------------------------------\\
    
    //Detail Joysticks used
    public interface JoystickPorts {
        public static final int
            rightChassisJS = 1,
            leftChassisJS = 0,
            operatorJS = 2;        
    }
    //-------------------------------------------------------------------------------------------------------------\\

    //Detail the Buttons of each Joystick
    public interface ButtonPorts {
        public static final int 
            // Operator joystick buttons \\
            OPERATOR_JS_X = 1,
            OPERATOR_JS_A = 2,
            OPERATOR_JS_B = 3,
            OPERATOR_JS_Y = 4,
            OPERATOR_JS_LB = 5,
            OPERATOR_JS_RB = 6,
            OPERATOR_JS_LT = 7,
            OPERATOR_JS_RT = 8,
            OPERATOR_JS_Back = 9,
            OPERATOR_JS_Start = 10,
            OPERATOR_JS_LeftS = 11,
            OPERATOR_JS_RS =12,

            // Left joystick ports \\
            LEFT_JS_COLLECTOR = 1;
    }
    //-------------------------------------------------------------------------------------------------------------\\
    //Detail Cameras used
    public interface CameraPorts {
        public static int 
        backCamera = 0;
        
    }
    //-------------------------------------------------------------------------------------------------------------\\
    // Math constants \\
    public interface MathConsts {
        public static final double 
            COLLECTOR_SPEED = 0.7,
            CHASSIS_MOTOR_SPEED = 0.5;
    }

    //-------------------------------------------------------------------------------------------------------------\\
    public interface StuffThatPID {
        public static final double

        // Angle PID Variables \\
        ANGLE_KP = 0.0186,
        ANGLE_KI = 0.002,
        ANGLE_KD = 0.003,
        ANGLE_TOLERANCE = 0.25,

        // Velocity PID Variables \\
        VELOCITY_KP = 0.0468,
        VELOCITY_KI = 0,
        VELOCITY_KD = 0.01,

        // Distance PID Varibles \\
        DISTANCE_KP = 0,
        DISTANCE_KI = 0,
        DISTANCE_KD = 0,
        DISTANCE_TOLERANCE = 1,

        // Swurv PID Variables \\
        SWURV_KP = 0.019,
        SWURV_KI = 0.005,
        SWURV_KD = 0.008,
        SWURV_TOLERANCE = 0.25;
    }
    //-------------------------------------------------------------------------------------------------------------\\
    public interface Sensors {
        public static final int
        ENCODER_ONE = 4,
        ENCODER_TWO = 5,
        ENCODER_THREE = 7,
        ENCODER_FOUR = 8;
    }
    //-------------------------------------------------------------------------------------------------------------\\
    // Old Robot Shit \\
    public interface oldRobotShit {
        public interface MotorPorts {
            public static final int
            chassisRightBack = 0, //WPI_VictorSPX
            chassisRightMiddle = 1, //Talon
            chassisRightFront = 2, //WPI_VictorSPX
            chassisLeftBack = 3, //WPI_VictorSPX
            collector = 4, //WPI_VictorSPX
            passer = 5, //WPI_VictorSPX. The motor which passes a power cell from the storage to the shooter.
            aimer = 6, //Talon. Aims the shooter.
            lifter = 7, //WPI_VictorSPX
            thrower = 8, //WPI_VictorSPX
            spinner = 9, //Talon
            climbUp = 12, //Talon
            climbPull = 13, //WPI_VictorSPX
            chassisLeftFront = 14, //WPI_VictorSPX
            chassisLeftMiddle = 15; //Talon
        }

        //Detail Piston Components
        public interface PistonPorts {
        

        }


        //Detail Digital components
        public interface DigitalPorts {
            public static final int 
            leftChassisEncoderA = 0,
            leftChassisEncoderB = 1,
            throwerEncoderB = 2,
            throwerEncoderA = 3,
            rolletaMicroSwitchDown = 4,
            rolletaMicroSwitchUp = 5,
            aimerSwitch = 6;

        }
        public interface AnalogPorts{
            public static final int 
              storageUltrasonic = 1,
              collectorUltrasonic = 0;

            public static final I2C.Port
                colorSensor = Port.kOnboard;
        }


        //Detail Joysticks used
        public interface JoystickPorts {
            public static final int
                rightChasisJS = 0,
                leftChassisJS = 1,
                operatorJS = 2;        
        }

        //Detail the Buttons of each Joystick
        public interface ButtonPorts {
            public static final int 
                operatorJSX = 1,
                operatorJSA = 2,
                operatorJSB = 3,
                operatorJSY = 4,
                operatorJSLB = 5,
                operatorJSRB = 6,
                operatorJSLT = 7,
                operatorJSRT = 8,
                operatorJSBack = 9,
                operatorJSStart = 10,
                operatorJSLeftS = 11,
                operatorJSRS =12;
        }

        //Detail Cameras used
        public interface CameraPorts {
            public static int 
            backCamera = 0;

        }
    }
}