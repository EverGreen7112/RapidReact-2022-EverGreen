// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public final class Constants {
    public interface MotorPorts {
        public static final int
        chassisRightBack = 14, //Victor
        chassisRightFront = 15, //victor
        chassisLeftBack = 0, //Victor
        chassisLeftFront = 1, //Victor
        collector = 12; //Victor
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
            rightChassisJS = 0,
            leftChassisJS = 1,
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

            // Right joystick ports \\
            RIGHT_JS_COLLECTOR=0,

            // Left joystick ports \\
            LEFT_JS_TURBO = 0;  
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
            REGULAR_SPEED = 0.4,
            TURBO_SPEED = 0.7;
    }

    //-------------------------------------------------------------------------------------------------------------\\
    public interface StuffThatPID {
        public static final double

        // Angle PID Variables \\
        ANGLE_KP = 0.0467,
        ANGLE_KI = 0,
        ANGLE_KD = 0,

        // Velocity PID Variables \\
        VELOCITY_KP = 0.0468,
        VELOCITY_KI = 0,
        VELOCITY_KD = 0,

        // Distance PID Varibles \\
        DISTANCE_KP = 0,
        DISTANCE_KI = 0,
        DISTANCE_KD = 0,
        DISTANCE_TOLERANCE = 1;
    }
    //-------------------------------------------------------------------------------------------------------------\\
    public interface Censors {
        public static final int
        ENCODER_ONE = 0,
        ENCODER_TWO = 1;
    }
    //-------------------------------------------------------------------------------------------------------------\\
    // Old Robot Shit \\
    public interface oldRobotShit {
        public interface MotorPorts {
            public static final int
            chassisRightBack = 0, //Victor
            chassisRightMiddle = 1, //Talon
            chassisRightFront = 2, //victor
            chassisLeftBack = 3, //Victor
            collector = 4, //Victor
            passer = 5, //Victor. The motor which passes a power cell from the storage to the shooter.
            aimer = 6, //Talon. Aims the shooter.
            lifter = 7, //Victor
            thrower = 8, //Victor
            spinner = 9, //Talon
            climbUp = 12, //Talon
            climbPull = 13, //Victor
            chassisLeftFront = 14, //Victor
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