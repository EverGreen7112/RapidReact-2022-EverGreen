package frc.robot;

import java.util.Set;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class Controls {


  private static Joystick m_rightJoystick, m_leftJoystick, m_operator; 
	private static JoystickButton m_cancelAll;
  private static JoystickButton m_collectorCollect, m_collectorUncollect, m_collectorOpen, m_collectorClose, m_climberDown, m_climberUp, m_storageUp, m_storageDown;
    

  public static void init() {

    // initialize joysticks and operator
    m_rightJoystick = new Joystick(Constants.JoystickPorts.rightJoystick);
    m_leftJoystick = new Joystick(Constants.JoystickPorts.leftJoystick);
    m_operator = new Joystick(Constants.JoystickPorts.operator);
	m_cancelAll =   new JoystickButton(m_rightJoystick,5);
    // initialize buttons for specific commands later on
    m_collectorOpen = new JoystickButton(m_operator, Constants.ButtonPorts.collectorOpen);
    m_collectorClose = new JoystickButton(m_operator, Constants.ButtonPorts.collectorClose);
    m_collectorCollect = new JoystickButton(m_operator, Constants.ButtonPorts.collectorCollect);
    m_collectorUncollect = new JoystickButton(m_operator, Constants.ButtonPorts.collectorUncollect);

    m_climberDown = new JoystickButton(m_operator, Constants.ButtonPorts.climberDown);
    m_climberUp = new JoystickButton(m_operator, Constants.ButtonPorts.climberUp);

    m_storageUp = new JoystickButton(m_operator, Constants.ButtonPorts.storageUp);
    m_storageDown = new JoystickButton(m_operator, Constants.ButtonPorts.storageDown);
    
    // initialize commands on buttons
    initCommands();

  }

  public static void movePeriodic() {

    // tank move robot according to the joystick's movement levels
    Chassis.getInstance().tankMove(
      -m_leftJoystick.getY() * Constants.Speeds.motorSpeed,
      -m_rightJoystick.getY() * Constants.Speeds.motorSpeed);

  }

  private static void initCommands() {

    // make each button do what it was defined for
	final Command cancelAll = new Command(){
		
		@Override
		public boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void initialize(){
			CommandScheduler.getInstance().cancelAll();
		}
		@Override
		public Set<Subsystem> getRequirements() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	m_cancelAll.whenHeld(cancelAll);
    CollectorOpen collectorOpen = new CollectorOpen();
    m_collectorOpen.whileHeld(collectorOpen);

    CollectorClose collectorClose = new CollectorClose();
    m_collectorClose.whileHeld(collectorClose);

    CollectorCollect collectorCollect = new CollectorCollect();
    m_collectorCollect.whileHeld(collectorCollect);

    CollectorUncollect collectorUncollect = new CollectorUncollect();
    m_collectorUncollect.whileHeld(collectorUncollect);

    ClimberDown climberD = new ClimberDown();
    m_climberDown.whileHeld(climberD);

    ClimberUp climberU = new ClimberUp();
    m_climberUp.whileHeld(climberU);

    StorageUp storageU = new StorageUp();
    m_storageUp.whileHeld(storageU);
    
    StorageDown storageD = new StorageDown();
    m_storageDown.whileHeld(storageD);
  }
}