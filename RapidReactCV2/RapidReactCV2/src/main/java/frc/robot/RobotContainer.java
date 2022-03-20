package frc.robot;

import java.util.Set;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.CollectorCollect;
import frc.robot.commands.CollectorOpen;
import frc.robot.commands.StorageUp;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Storage;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Configure the button bindings
		configureButtonBindings();
	}

	/**
	 * Use this method to define your button->command mappings. Buttons can be
	 * created by
	 * instantiating a {@link GenericHID} or one of its subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
	 * it to a {@link
	 * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() {
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousComand() {
		Trajectory trajectory = Robot.trajectory4; // get motion profiling trajectory

		RamseteCommand ramseteCommand = new RamseteCommand(
				trajectory,
				DriveTrain.getInstance()::getPose,
				new RamseteController(Constants.DriveConstants.kRamseteB, Constants.DriveConstants.kRamseteZeta),
				new SimpleMotorFeedforward(
						Constants.DriveConstants.kS,
						Constants.DriveConstants.kV,
						Constants.DriveConstants.kA),
				Constants.DriveConstants.kDriveKinematics,
				DriveTrain.getInstance()::getWheelSpeeds,
				new PIDController(Constants.DriveConstants.kP, 0, 0),
				new PIDController(Constants.DriveConstants.kP, 0, 0),
				DriveTrain.getInstance()::tankDriveVolts,
				DriveTrain.getInstance());
		DriveTrain.getInstance().resetOdometry(trajectory.getInitialPose());
		Command folowTraj = ramseteCommand.andThen(() -> DriveTrain.getInstance().tankDriveVolts(0, 0));
		// Command shoot = new Command() {
		// 	@Override 
		// 	public void execute() {
		// 		Controls.shoot(1);
		// 	}

		// 	@Override
		// 	public void end(boolean interrupted) {
		// 		Controls.shoot(0);
		// 	};

		// 	@Override
		// 	public Set<Subsystem> getRequirements() {
		// 		// TODO Auto-generated method stub
		// 		return null;
		// 	};
		// };
		// Command allCombined = (new ParallelCommandGroup(new StorageUp().withTimeout(5), shoot.withTimeout(5))).andThen(folowTraj);

		return folowTraj;
	}

	public Command getOGAuto(){
		
		Trajectory trajectory = Robot.trajectory; // get motion profiling trajectory
		Trajectory trajectory2 = Robot.trajectory2; // canal
		Trajectory trajectory3 = Robot.trajectory3; // canal again

		// move robot according to the trajectory (basically the motion profiling part)
		RamseteCommand ramseteCommand = new RamseteCommand(
				trajectory,
				DriveTrain.getInstance()::getPose,
				new RamseteController(Constants.DriveConstants.kRamseteB, Constants.DriveConstants.kRamseteZeta),
				new SimpleMotorFeedforward(
						Constants.DriveConstants.kS,
						Constants.DriveConstants.kV,
						Constants.DriveConstants.kA),
				Constants.DriveConstants.kDriveKinematics,
				DriveTrain.getInstance()::getWheelSpeeds,
				new PIDController(Constants.DriveConstants.kP, 0, 0),
				new PIDController(Constants.DriveConstants.kP, 0, 0),
				DriveTrain.getInstance()::tankDriveVolts,
				DriveTrain.getInstance());

			

		// reset robot's position in odometry in order to make sure movement is done
		// correctly
		// according to the trajectory
		DriveTrain.getInstance().resetOdometry(trajectory.getInitialPose());
		Command folowTraj = ramseteCommand.andThen(() -> DriveTrain.getInstance().tankDriveVolts(0, 0));
		//Command folowTraj2 = ramseteCommand.andThen(() -> DriveTrain.getInstance().tankDriveVolts(0, 0)).asProxy();
		Command folowAndcollect = new ParallelDeadlineGroup(folowTraj, new CollectorCollect());// chance for problem due
		// Command allAuto = new SequentialCommandGroup(new
		// CollectorOpen().withTimeout(0.5), folowAndcollect,
		// new StorageUp());
		ramseteCommand.andThen(() -> DriveTrain.getInstance().tankDriveVolts(0, 0));
		SequentialCommandGroup allAuto = new SequentialCommandGroup(new StorageUp().withTimeout(5), folowAndcollect);
		// return the ramsete command in order to cause the motion profiling
		// then stop the robot's movements after finished (without it, it keeps going

		// RamseteCommand ramseteCommand2 = new RamseteCommand(
		// 		trajectory2,
		// 		DriveTrain.getInstance()::getPose,
		// 		new RamseteController(Constants.DriveConstants.kRamseteB, Constants.DriveConstants.kRamseteZeta),
		// 		new SimpleMotorFeedforward(
		// 				Constants.DriveConstants.kS,
		// 				Constants.DriveConstants.kV,
		// 				Constants.DriveConstants.kA),
		// 		Constants.DriveConstants.kDriveKinematics,
		// 		DriveTrain.getInstance()::getWheelSpeeds,
		// 		new PIDController(Constants.DriveConstants.kP, 0, 0),
		// 		new PIDController(Constants.DriveConstants.kP, 0, 0),
		// 		DriveTrain.getInstance()::tankDriveVolts,
		// 		DriveTrain.getInstance());

		
		// until it stops alone)
		return folowTraj;
		//return allAuto.asProxy();
	}

}