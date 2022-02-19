// TODO: comment the entire file
package frc.robot.Static.RobotContainer;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public final class Constants {
    public interface testValues {
        public static final double 
            SPEED_JUMPS = 0.01;
    }
    public interface MotorPorts {
        public static final int
        chassisRight1 = 14, //WPI_VictorSPX
        chassisRight2 = 15, //WPI_VictorSPX
        chassisRight3 = 12, //WPI_VictorSPX
        chassisLeft1 = 0, //WPI_VictorSPX
        chassisLeft2 = 1, //WPI_VictorSPX
        chassisLeft3 = 3,
        collector = 0, //WPI_VictorSPX TODO change to the right port
        collectorLift = 0; //WPI_VictorSPX TODO change to the right port
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
            CHASSIS_MOTOR_SPEED = 0.8,
            JOYSTICK_MINIMUM = 0.5;
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
        SWURV_KP = 0.00001,
        SWURV_KI = 0.04,
        SWURV_KD = 0.00008,
        SWURV_TOLERANCE = 0.25;
    }
    //-------------------------------------------------------------------------------------------------------------\\
    public interface Sensors {
        public static final int
        ENCODER_ONE = 2,
        ENCODER_TWO = 5,
        ENCODER_THREE = 0,
        ENCODER_FOUR = 1;
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