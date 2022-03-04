package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class Controls {


  private static Joystick m_rightJoystick, m_leftJoystick, m_operator; 

  private static JoystickButton m_collectorCollect, m_collectorOpen, m_collectorClose;
    

  public static void init() {

    // initialize joysticks and operator
    m_rightJoystick = new Joystick(Constants.JoystickPorts.rightJoystick);
    m_leftJoystick = new Joystick(Constants.JoystickPorts.leftJoystick);
    m_operator = new Joystick(Constants.JoystickPorts.operator);

    // initialize buttons for specific commands later on
    m_collectorOpen = new JoystickButton(m_operator, Constants.ButtonPorts.collectorOpen);
    m_collectorClose = new JoystickButton(m_operator, Constants.ButtonPorts.collectorClose);
    m_collectorCollect = new JoystickButton(m_operator, Constants.ButtonPorts.collectorCollect);
    
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

    CollectorOpen collectorOpen = new CollectorOpen();
    m_collectorOpen.whileHeld(collectorOpen);

    CollectorClose collectorClose = new CollectorClose();
    m_collectorClose.whileHeld(collectorClose);

    CollectorCollect collectorCollect = new CollectorCollect();
    m_collectorCollect.whileHeld(collectorCollect);

  }
}