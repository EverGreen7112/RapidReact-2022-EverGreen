package frc.robot; // Package

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// Imports \\
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.RobotContainer.Controls;
import frc.robot.commands.PID_turn;

// Robot Class \\
public class Robot extends TimedRobot {

  // Autonomous command local variable \\
  private Command m_autonomousCommand;


  // Robot Init - When the robot first loads the code \\ 
  @Override
  public void robotInit(){
    m_autonomousCommand = new PID_turn(90).withTimeout(7); // defining the autonomous command

    super.robotInit(); // Calling the robotInit of the oarent classs

    Controls.init(); // Setting up the controls

    Sensors.getGyro().reset(); // Reseting the gyro
  }


  @Override
  public void robotPeriodic() { // When the robot is running

    CommandScheduler.getInstance().run();
  }

  // When the robot enters the disabled mode \\
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {    
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }


  }


  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //Controls.movePeriodic(); // uses tank-drive with joysticks \\

    Controls.commandsPeriodic(); // Calls all of the commands \\
    
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  WPI_VictorSPX motor = new WPI_VictorSPX(0);
  @Override
  public void testPeriodic() {
    motor.set(-0.1);
  }

}