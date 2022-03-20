// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Handler;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.CollectorCollect;
import frc.robot.commands.CollectorOpen;
import frc.robot.commands.StorageUp;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Storage;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

	private Command m_autonomousCommand;
	private RobotContainer m_robotContainer;
	private long startTime = System.currentTimeMillis();
	private String trajectoryJSON = "Unnamed.wpilib.json"; // path for trajectory
	private String trajectoryJSON2 = "Unnamed_0.wpilib.json"; // path for trajectory
	private String trajectoryJSON3 = "Unnamed_1.wpilib.json"; // path for trajectory
	private String trajectoryJSON4 = "Unnamed_2.wpilib.json"; // path for trajectory
	public static Trajectory trajectory = new Trajectory(); // create new Trajectory
	public static Trajectory trajectory2 = new Trajectory(); // create new Trajectory
	public static Trajectory trajectory3 = new Trajectory(); // create new Trajectory
	public static Trajectory trajectory4 = new Trajectory(); // create new Trajectory

	// -------------------------------------------------------------------------------------------------------------\\
	/**
	 * This function is run when the robot is first started up and should be used
	 * for any
	 * initialization code.
	 */
	@Override
	public void robotInit() {

		try {
			// get movement path from json
			Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
			if (trajectoryPath != null) // turn movement path into trajectory
				trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);

		} catch (IOException ex) {
			DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON, ex.getStackTrace());
		}

		try {
			// get movement path from json
			Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON2);
			if (trajectoryPath != null) // turn movement path into trajectory
				trajectory2 = TrajectoryUtil.fromPathweaverJson(trajectoryPath);

		} catch (IOException ex) {
			DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON2, ex.getStackTrace());
		}

		try {
			// get movement path from json
			Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON3);
			if (trajectoryPath != null) // turn movement path into trajectory
				trajectory3 = TrajectoryUtil.fromPathweaverJson(trajectoryPath);

		} catch (IOException ex) {
			DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON3, ex.getStackTrace());
		}


		try {
			// get movement path from json
			Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON4);
			if (trajectoryPath != null) // turn movement path into trajectory
				trajectory4 = TrajectoryUtil.fromPathweaverJson(trajectoryPath);

		} catch (IOException ex) {
			DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON4, ex.getStackTrace());
		}


		// reset gyro's rotation value
		Chassis.getInstance().getGyro().reset();

		super.robotInit();

		// initialize robot container (contains motion profiling command)
		m_robotContainer = new RobotContainer();

	}

	// -------------------------------------------------------------------------------------------------------------\\
	/**
	 * This function is called every robot packet, no matter the mode. Use this for
	 * items like
	 * diagnostics that you want ran during disabled, autonomous, teleoperated and
	 * test.
	 *
	 * <p>
	 * This runs after the mode specific periodic functions, but before LiveWindow
	 * and
	 * SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
		// Runs the Scheduler. This is responsible for polling buttons, adding
		// newly-scheduled
		// commands, running already-scheduled commands, removing finished or
		// interrupted commands,
		// and running subsystem periodic() methods. This must be called from the
		// robot's periodic
		// block in order for anything in the Command-based framework to work.

		CommandScheduler.getInstance().run();
		SmartDashboard.putNumber("Right Encoder", Chassis.getInstance().getRightEncoder().getDistance());
		SmartDashboard.putNumber("Left Encoder", Chassis.getInstance().getLeftEncoder().getDistance());
		if (isEnabled()) {
			String s = "";
			long passedTime = (System.currentTimeMillis() - startTime);
			int minuteLeft = 2 - ((int) (passedTime / 1000L) / 60);
			int secondsLeft = (int) (passedTime / 1000L) > 30 ? 60 - (int) (passedTime / 1000L) % 60
					: 30 - (int) (passedTime / 1000L) % 60;
			s = minuteLeft + ":" + secondsLeft;
			SmartDashboard.putString("timeLeft", s);
		}
		SmartDashboard.putBoolean("Is Up", Climber.getInstance().isUp());
		SmartDashboard.putBoolean("Is Climber Down", Collector.getInstance().isDown());

	}
	// -------------------------------------------------------------------------------------------------------------\\

	/** This function is called once each time the robot enters Disabled mode. */
	@Override
	public void disabledInit() {
	}

	// -------------------------------------------------------------------------------------------------------------\\
	@Override
	public void disabledPeriodic() {
	}

	// -------------------------------------------------------------------------------------------------------------\\
	/**
	 * This autonomous runs the autonomous command selected by your
	 * {@link RobotContainer} class.
	 */
	@Override
	public void autonomousInit() {

		startTime = System.currentTimeMillis();
		//Storage.getInstance().set(0.9);
		try {
			m_autonomousCommand = m_robotContainer.getAutonomousComand();
			m_autonomousCommand.schedule();
			// Thread.sleep(6000);
			// Storage.getInstance().set(0);
			// CollectorOpen test = new CollectorOpen();
			// test.schedule();
			// Thread.sleep(1000);
			
			
			// collectCommand.schedule();
			// Chassis.getInstance().tankMove(0.4, 0.4);
			// Thread.sleep(3000);
			// Chassis.getInstance().tankMove(0,0);
			
		} catch (Exception n) {

			n.printStackTrace();
			// Command storage = new StorageUp().withTimeout(5);
			// storage.schedule();
			// try {
			// 	Chassis.getInstance().tankMove(0.4, 0.4);
			// 	Thread.sleep(3000);
			// 	Chassis.getInstance().tankMove(0,0);
			// } catch (Exception e) {
			// 	e.printStackTrace();
			// }
		}
		
		

	}

	// -------------------------------------------------------------------------------------------------------------\\
	/** This function is called periodically during autonomous. */
	@Override
	public void autonomousPeriodic() {

		SmartDashboard.putNumber("Gyro Value", Chassis.getInstance().getGyro().getAngle());

		// SmartDashboard.putBoolean("SwitchDown", Collector.getInstance().isDown());

	}

	// -------------------------------------------------------------------------------------------------------------\\
	@Override
	public void teleopInit() {

		// init joysticks and button function
		Controls.init();

	}

	// -------------------------------------------------------------------------------------------------------------\\

	/** This function is called periodically during operator control. */
	@Override
	public void teleopPeriodic() {

		// tank move according to joysticks
		Controls.movePeriodic();
		Controls.climbToThird();

	}

	// -------------------------------------------------------------------------------------------------------------\\
	@Override
	public void testInit() {

		// Cancels all running commands at the start of test mode.
		CommandScheduler.getInstance().cancelAll();

	}

	// -------------------------------------------------------------------------------------------------------------\\
	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() {
		Climber.getInstance().set(Constants.Speeds.climberMotor);
	}

}