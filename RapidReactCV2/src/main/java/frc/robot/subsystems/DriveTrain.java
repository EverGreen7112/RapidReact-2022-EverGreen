package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private static final DriveTrain m_driveTrain = new DriveTrain(); // drivetrain's instance

   // private final DifferentialDrive m_drive;

    private final DifferentialDriveOdometry m_odometry;
    
    private final Field2d m_field;

    private double m_leftSpeed = 0;
    private double m_rightSpeed = 0;
    private double m_maxOutput = 1;

    public DriveTrain(){

        // initialize tank move mechanism for automatic movement
        // m_drive = new DifferentialDrive(
        //     Chassis.getInstance().getLeftMotors(),
        //     Chassis.getInstance().getRightMotors());

        // reset encoders' values
        resetEncoders();

        // initialize odometry which is in charge of position checks for automatic movement
        // uses encoders and the gyro in order to do so
        m_odometry = new DifferentialDriveOdometry(Chassis.getInstance().getGyro().getRotation2d());

        m_field = new Field2d();

        SmartDashboard.putData("Field", m_field);
    }

    public static DriveTrain getInstance(){
        return m_driveTrain;
    }

    public void resetEncoders(){

        // reset encoders' values
        Chassis.getInstance().getLeftEncoder().reset();
        Chassis.getInstance().getRightEncoder().reset();

    }

    @Override
    public void periodic(){

        // update position and rotation in odometry using the encoders and gyro
        m_odometry.update(
            Chassis.getInstance().getGyro().getRotation2d(),
            Chassis.getInstance().getLeftEncoder().getDistance(),
            Chassis.getInstance().getRightEncoder().getDistance());
        //m_drive.check();
        m_field.setRobotPose(m_odometry.getPoseMeters());
        //m_drive.tankDrive(m_leftSpeed, m_rightSpeed);

    }

    public Pose2d getPose(){

        // returns (x,y) representation of the robot's current positon
        return m_odometry.getPoseMeters();

    }

    public DifferentialDriveWheelSpeeds getWheelSpeeds(){

        // return wheels speeds in meters per second
        return new DifferentialDriveWheelSpeeds(
            Chassis.getInstance().getLeftEncoder().getRate(),
            Chassis.getInstance().getRightEncoder().getRate());

    }

    public void resetOdometry(Pose2d pose){

        // reset the encoders and odometry's position
        resetEncoders();
        m_odometry.resetPosition(pose, Chassis.getInstance().getGyro().getRotation2d());

    }

    public void tankDriveVolts(double leftVolts, double rightVolts){

        // tank drive using specific voltage amounts per side of motors
        //m_drive.tankDrive(leftVolts, rightVolts);
        Chassis.getInstance().tankMove(Math.max(leftVolts, m_maxOutput), Math.max(rightVolts, m_maxOutput));
        m_leftSpeed  = leftVolts;
        m_rightSpeed = rightVolts;
        //m_drive.setSafetyEnabled(false);
        // reset timeout clock for movement
        // m_drive.feed();
        // m_drive.check();
    
    }

    public double getAverageEncoderDistance(){

        // result in meters
        return (
            Chassis.getInstance().getLeftEncoder().getDistance() + 
            Chassis.getInstance().getRightEncoder().getDistance()) / 2.0;
        
    }

    public void setMaxOutput(double maxOutput){
        m_maxOutput = maxOutput;
    }

    public void zeroHeading(){
        
        // reset gyro's rotation
        Chassis.getInstance().getGyro().reset();

    }

    public double getHeading(){
        
        // return gyro's rotation in degrees
        return Chassis.getInstance().getGyro().getRotation2d().getDegrees();

    }

    public double getTurnRate(){

        // return gyro's rotation rate
        return -Chassis.getInstance().getGyro().getRate();
        
    }

}
