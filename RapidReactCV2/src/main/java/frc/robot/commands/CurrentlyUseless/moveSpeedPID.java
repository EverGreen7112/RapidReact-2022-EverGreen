// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.NoneConstants;
// import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
// import frc.robot.PidSpeedControllerGroup;
// import frc.robot.subsystems.Chassis;
// import frc.robot.Constants;

// public class moveSpeedPID extends CommandBase {

//   private static PidSpeedControllerGroup m_MotorControllerL; 

//   //check if the sides are right
//   private static PidSpeedControllerGroup m_MotorControllerR;


//   private double m_distance;

//   /** Creates a new moveSpeedPID. */
//   public moveSpeedPID(double distance) {
//     // Use addRequirements() here to declare subsystem dependencies.
//     m_distance = distance;

//     addRequirements(Chassis.getInstance());
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {

//     m_MotorControllerL = new PidSpeedControllerGroup(
//     Chassis.getInstance().getLeftEncoder(),
//     0.0, 
//     NoneConstants.collectorKP, 
//     NoneConstants.collectorKI,
//     NoneConstants.collectorKD, 
//     Chassis.getInstance().getM_left());

//     m_MotorControllerR = new PidSpeedControllerGroup(
//     Chassis.getInstance().getRightEncoder(),
//     0.0, 
//     NoneConstants.collectorKP, 
//     NoneConstants.collectorKI,
//     NoneConstants.collectorKD, 
//     Chassis.getInstance().getM_right()); 

//     Chassis.getInstance().tankMove(0.1, 0.1);
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     Chassis.getInstance().tankMove(0.1, 0.1);
//   }

//   public void setSpeeds(double speedL, double speedR){
//     m_MotorControllerR.set(speedR);
//     m_MotorControllerL.set(speedL);
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     Chassis.getInstance().tankMove(0, 0);
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return Chassis.getInstance().getLeftEncoder().getDistance() >= m_distance - Chassis.getInstance().getLeftEncoder().getRate()/10; // p is distance left PID remember its important
//   }
// }
