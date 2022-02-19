package frc.robot; // package

// imports \\
import edu.wpi.first.wpilibj.RobotBase; 

// Main class
public final class Main {
  // Main constructor \\
  private Main() {}

  // Main java function to start the robot \\
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new); // Starting the robot
  }
}